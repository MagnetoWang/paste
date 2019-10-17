package avro;

import org.apache.avro.AvroRuntimeException;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.SchemaParseException;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.file.SeekableByteArrayInput;
import org.apache.avro.file.SeekableInput;
import org.apache.avro.generic.*;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.MessageEncoder;
import org.apache.avro.specific.SpecificDatumWriter;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.*;

import static org.testng.Assert.*;
import static org.testng.AssertJUnit.fail;
import org.apache.avro.Schema.Field;
import org.apache.avro.Schema.Type;

/**
 * @Author wangzixian
 * @Description 关于avro的schema demo
 * @Date 2019/10/16 12:12
 **/
public class schema {
    @Test
    public void testSplitSchemaBuild() {
        Schema s = SchemaBuilder.record("HandshakeRequest").namespace("org.apache.avro.ipc").fields().name("clientProtocol")
                .type().optional().stringType().name("meta").type().optional().map().values().bytesType().endRecord();

        String schemaString = s.toString();
        int mid = schemaString.length() / 2;
        System.out.println(s.toString());

        Schema parsedStringSchema = new org.apache.avro.Schema.Parser().parse(s.toString());
        Schema parsedArrayOfStringSchema = new org.apache.avro.Schema.Parser().parse(schemaString.substring(0, mid),
                schemaString.substring(mid));
        assertNotNull(parsedStringSchema);
        assertNotNull(parsedArrayOfStringSchema);
        assertEquals(parsedStringSchema.toString(), parsedArrayOfStringSchema.toString());
    }

    @Test
    public void testDefaultRecordWithDuplicateFieldName() {
        String recordName = "name";
        Schema schema = Schema.createRecord(recordName, "doc", "namespace", false);
        List<Schema.Field> fields = new ArrayList<>();
        fields.add(new Schema.Field("field_name", Schema.create(Schema.Type.NULL), null, null));
        fields.add(new Schema.Field("field_name", Schema.create(Schema.Type.INT), null, null));
        try {
            schema.setFields(fields);
            fail("Should not be able to create a record with duplicate field name.");
        } catch (AvroRuntimeException are) {
            assertTrue(are.getMessage().contains("Duplicate field field_name in record " + recordName));
        }
    }

    @Test
    public void testCreateUnionVarargs() {
        List<Schema> types = new ArrayList<>();
        types.add(Schema.create(Schema.Type.NULL));
        types.add(Schema.create(Schema.Type.LONG));
        Schema expected = Schema.createUnion(types);

        Schema schema = Schema.createUnion(Schema.create(Type.NULL), Schema.create(Type.LONG));
        assertEquals(expected, schema);
    }

    @Test
    public void testRecordWithNullDoc() {
        Schema schema = Schema.createRecord("name", null, "namespace", false);
        String schemaString = schema.toString();
        assertNotNull(schemaString);
    }

    @Test
    public void testRecordWithNullNamespace() {
        Schema schema = Schema.createRecord("name", "doc", null, false);
        String schemaString = schema.toString();
        assertNotNull(schemaString);
    }

    @Test
    public void testEmptyRecordSchema() {
        Schema schema = createDefaultRecord();
        String schemaString = schema.toString();
        assertNotNull(schemaString);
    }

    @Test
    public void testSchemaWithFields() {
        List<Field> fields = new ArrayList<>();
        fields.add(new Field("field_name1", Schema.create(Type.NULL), null, null));
        fields.add(new Field("field_name2", Schema.create(Type.INT), null, null));
        Schema schema = createDefaultRecord();
        schema.setFields(fields);
        String schemaString = schema.toString();
        assertNotNull(schemaString);
        assertEquals(2, schema.getFields().size());
    }

//    @Test(expected = NullPointerException.class)
//    public void testSchemaWithNullFields() {
//        Schema.createRecord("name", "doc", "namespace", false, null);
//    }

    @Test
    public void testIsUnionOnUnionWithMultipleElements() {
        Schema schema = Schema.createUnion(Schema.create(Type.NULL), Schema.create(Type.LONG));
        assertTrue(schema.isUnion());
    }

    @Test
    public void testIsUnionOnUnionWithOneElement() {
        Schema schema = Schema.createUnion(Schema.create(Type.LONG));
        assertTrue(schema.isUnion());
    }

    @Test
    public void testIsUnionOnRecord() {
        Schema schema = createDefaultRecord();
        assertFalse(schema.isUnion());
    }

    @Test
    public void testIsUnionOnArray() {
        Schema schema = Schema.createArray(Schema.create(Type.LONG));
        assertFalse(schema.isUnion());
    }

    @Test
    public void testIsUnionOnEnum() {
        Schema schema = Schema.createEnum("name", "doc", "namespace", Collections.singletonList("value"));
        assertFalse(schema.isUnion());
    }

    @Test
    public void testIsUnionOnFixed() {
        Schema schema = Schema.createFixed("name", "doc", "space", 10);
        assertFalse(schema.isUnion());
    }

    @Test
    public void testIsUnionOnMap() {
        Schema schema = Schema.createMap(Schema.create(Schema.Type.LONG));
        assertFalse(schema.isUnion());
    }

    @Test
    public void testIsNullableOnUnionWithNull() {
        Schema schema = Schema.createUnion(Schema.create(Schema.Type.NULL), Schema.create(Schema.Type.LONG));
        assertTrue(schema.isNullable());
    }

    @Test
    public void testIsNullableOnUnionWithoutNull() {
        Schema schema = Schema.createUnion(Schema.create(Schema.Type.LONG));
        assertFalse(schema.isNullable());
    }

    @Test
    public void testIsNullableOnRecord() {
        Schema schema = createDefaultRecord();
        assertFalse(schema.isNullable());
    }

    private Schema createDefaultRecord() {
        return Schema.createRecord("name", "doc", "namespace", false);
    }

    @Test
    public void testSerialization() throws IOException, ClassNotFoundException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos);
             InputStream jsonSchema = getClass().getResourceAsStream("/SchemaBuilder.avsc")) {

            Schema payload = new Schema.Parser().parse(jsonSchema);
            oos.writeObject(payload);

            try (ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
                 ObjectInputStream ois = new ObjectInputStream(bis)) {
                Schema sp = (Schema) ois.readObject();
                assertEquals(payload, sp);
            }
        }
    }

    @Test
    public void testMapWithNonStringKeyToStringIsJson() throws Exception {
        Schema intMapSchema = new Schema.Parser()
                .parse("{\"type\": \"map\", \"values\": \"string\", \"java-key-class\" : \"java.lang.Integer\"}");
        Field intMapField = new Field("intMap", Schema.createMap(intMapSchema), null, null);
        Schema decMapSchema = new Schema.Parser()
                .parse("{\"type\": \"map\", \"values\": \"string\", \"java-key-class\" : \"java.math.BigDecimal\"}");
        Field decMapField = new Field("decMap", Schema.createMap(decMapSchema), null, null);
        Schema boolMapSchema = new Schema.Parser()
                .parse("{\"type\": \"map\", \"values\": \"string\", \"java-key-class\" : \"java.lang.Boolean\"}");
        Field boolMapField = new Field("boolMap", Schema.createMap(boolMapSchema), null, null);
        Schema fileMapSchema = new Schema.Parser()
                .parse("{\"type\": \"map\", \"values\": \"string\", \"java-key-class\" : \"java.io.File\"}");
        Field fileMapField = new Field("fileMap", Schema.createMap(fileMapSchema), null, null);
        Schema schema = Schema.createRecord("my_record", "doc", "mytest", false);
//        schema.setFields(Arrays.asList(intMapField, decMapField, boolMapField, fileMapField));
        schema.setFields(Arrays.asList(intMapField, decMapField, boolMapField));


        HashMap<Integer, String> intPair = new HashMap<>();
        intPair.put(1, "one");
        intPair.put(2, "two");

        HashMap<java.math.BigDecimal, String> decPair = new HashMap<>();
        decPair.put(java.math.BigDecimal.valueOf(1), "one");
        decPair.put(java.math.BigDecimal.valueOf(2), "two");

        HashMap<Boolean, String> boolPair = new HashMap<>();
        boolPair.put(true, "isTrue");
        boolPair.put(false, "isFalse");
        boolPair.put(null, null);

//        HashMap<java.io.File, String> filePair = new HashMap<>();
//        java.io.File f = new java.io.File(getClass().getResource("/SchemaBuilder.avsc").toURI());
//        filePair.put(f, "File");

        GenericRecord r = new GenericData.Record(schema);
        r.put(intMapField.name(), intPair);
        r.put(decMapField.name(), decPair);
        r.put(boolMapField.name(), boolPair);
//        r.put(fileMapField.name(), filePair);

        String json = r.toString();
        System.out.println(json);
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(json);
        ObjectMapper mapper = new ObjectMapper();

        // will throw exception if string is not parsable json
        mapper.readTree(parser);
    }

    /*
     * The toString has a detection for circular references to abort. This detection
     * has the risk of detecting that same value as being a circular reference. For
     * Record, Map and Array this is correct, for the rest is is not.
     */
    @Test
    public void testToStringSameValues() throws IOException {
        List<Field> fields = new ArrayList<>();
        fields.add(new Field("nullstring1", Schema.create(Type.STRING), null, null));
        fields.add(new Field("nullstring2", Schema.create(Type.STRING), null, null));

        fields.add(new Field("string1", Schema.create(Type.STRING), null, null));
        fields.add(new Field("string2", Schema.create(Type.STRING), null, null));

        fields.add(new Field("bytes1", Schema.create(Type.BYTES), null, null));
        fields.add(new Field("bytes2", Schema.create(Type.BYTES), null, null));

        fields.add(new Field("int1", Schema.create(Type.INT), null, null));
        fields.add(new Field("int2", Schema.create(Type.INT), null, null));

        fields.add(new Field("long1", Schema.create(Type.LONG), null, null));
        fields.add(new Field("long2", Schema.create(Type.LONG), null, null));

        fields.add(new Field("float1", Schema.create(Type.FLOAT), null, null));
        fields.add(new Field("float2", Schema.create(Type.FLOAT), null, null));

        fields.add(new Field("double1", Schema.create(Type.DOUBLE), null, null));
        fields.add(new Field("double2", Schema.create(Type.DOUBLE), null, null));

        fields.add(new Field("boolean1", Schema.create(Type.BOOLEAN), null, null));
        fields.add(new Field("boolean2", Schema.create(Type.BOOLEAN), null, null));

        List<String> enumValues = new ArrayList<>();
        enumValues.add("One");
        enumValues.add("Two");
        Schema enumSchema = Schema.createEnum("myEnum", null, null, enumValues);
        fields.add(new Field("enum1", enumSchema, null, null));
        fields.add(new Field("enum2", enumSchema, null, null));

        Schema recordSchema = SchemaBuilder.record("aRecord").fields().requiredString("myString").endRecord();
        fields.add(new Field("record1", recordSchema, null, null));
        fields.add(new Field("record2", recordSchema, null, null));

        Schema arraySchema = Schema.createArray(Schema.create(Type.STRING));
        fields.add(new Field("array1", arraySchema, null, null));
        fields.add(new Field("array2", arraySchema, null, null));

        Schema mapSchema = Schema.createMap(Schema.create(Type.STRING));
        fields.add(new Field("map1", mapSchema, null, null));
        fields.add(new Field("map2", mapSchema, null, null));

        Schema schema = Schema.createRecord("Foo", "test", "mytest", false);
        schema.setFields(fields);

        GenericData.Record testRecord = new GenericData.Record(schema);

        testRecord.put("nullstring1", null);
        testRecord.put("nullstring2", null);

        String fortyTwo = "42";
        testRecord.put("string1", fortyTwo);
        testRecord.put("string2", fortyTwo);
        testRecord.put("bytes1", 0x42);
        testRecord.put("bytes2", 0x42);
        testRecord.put("int1", 42);
        testRecord.put("int2", 42);
        testRecord.put("long1", 42L);
        testRecord.put("long2", 42L);
        testRecord.put("float1", 42F);
        testRecord.put("float2", 42F);
        testRecord.put("double1", 42D);
        testRecord.put("double2", 42D);
        testRecord.put("boolean1", true);
        testRecord.put("boolean2", true);

        testRecord.put("enum1", "One");
        testRecord.put("enum2", "One");

        GenericRecord record = new GenericData.Record(recordSchema);
        record.put("myString", "42");
        testRecord.put("record1", record);
        testRecord.put("record2", record);

        GenericArray<String> array = new GenericData.Array<>(1, arraySchema);
        array.clear();
        array.add("42");
        testRecord.put("array1", array);
        testRecord.put("array2", array);

        Map<String, String> map = new HashMap<>();
        map.put("42", "42");
        testRecord.put("map1", map);
        testRecord.put("map2", map);

        String testString = testRecord.toString();
        assertFalse(testString.contains("CIRCULAR REFERENCE"),"Record with duplicated values results in wrong 'toString()'");
    }

    @Test
    /**
     * 从创建schema，放入数据到序列化一条龙的流程demo演示
     */
    public void testDemo() throws Exception {
        Schema tableSchema = Schema.createRecord("studentInfomation", "different type information of student", null, false);
        List<Field> fields = new ArrayList<>();
//        Schema INT_TYPE = Schema.create(Type.STRING);
        fields.add(new Field("string1", Schema.create(Type.STRING), null, null));
//        fields.add(new Field("int1", Schema.create(Type.INT), null, null));
//        fields.add(new Field("int2", Schema.create(Type.BOOLEAN), null, null));
        tableSchema.setFields(fields);
        // 本身占10个字节 + 7个字节字符串 + 1个字节int + 1个字节布尔值 总共19个字节
        GenericData.Record testData = new GenericData.Record(tableSchema);
        // 可以put任何数据进去，但是在序列化的时候，就会报错
//        testData.put(0, 3);
//        testData.put(1, 3);
//        testData.put(2, 3);

        testData.put(0, "string");
//        testData.put(1, 3);
//        testData.put("int2", false);
        System.out.println(testData.toString());
//        byte[] data = getSerializedMessage(testData, tableSchema);
        MessageEncoder<GenericData.Record> encoder = new BinaryMessageEncoder<>(GenericData.get(), tableSchema);
        ByteBuffer byteBuffer = encoder.encode(testData);
        byte[] data = byteBuffer.array();

        System.out.println(data.length);
        BinaryMessageDecoder<GenericData.Record> decoder = new BinaryMessageDecoder<>(GenericData.get(), tableSchema);
        GenericData.Record rawData = decoder.decode(data);
        System.out.println(rawData.toString());

//        DecoderFactory factory = new DecoderFactory().configureDecoderBufferSize(521);
//        Decoder d = factory.binaryDecoder(new ByteArrayInputStream(data), null);
//        System.out.println(d.readString());
//        Decoder d = newDecoder(new ByteArrayInputStream(data));

    }

    private byte[] getSerializedMessage(IndexedRecord message, Schema schema) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(4096);
        SpecificDatumWriter<IndexedRecord> writer = new SpecificDatumWriter<>();
        try (DataFileWriter<IndexedRecord> dfw = new DataFileWriter<>(writer).create(schema, baos)) {
            dfw.append(message);
        }
        return baos.toByteArray();
    }

}
