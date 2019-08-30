package file;

import org.apache.parquet.format.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.apache.parquet.format.Util.readFileMetaData;
import static org.apache.parquet.format.Util.writeFileMetaData;
import static java.util.Arrays.asList;




/**
 * @Author wangzixian
 * @Description 读写parquet文件
 * @Date 2019/8/29 09:47
 **/
public class ParquetUtil {

    @Test
    public void testReadFileMetadata() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        FileMetaData md = new FileMetaData(
                1,
                asList(new SchemaElement("foo")),
                10,
                asList(
                        new RowGroup(
                                asList(
                                        new ColumnChunk(0),
                                        new ColumnChunk(1)
                                ),
                                10,
                                5),
                        new RowGroup(
                                asList(
                                        new ColumnChunk(2),
                                        new ColumnChunk(3)
                                ),
                                11,
                                5)
                )
        );
        writeFileMetaData(md , baos);
        System.out.println(md.toString());
        FileMetaData md2 = readFileMetaData(in(baos));
        FileMetaData md3 = new FileMetaData();
        readFileMetaData(in(baos), new Util.DefaultFileMetaDataConsumer(md3));
        FileMetaData md4 = new FileMetaData();
        readFileMetaData(in(baos), new Util.DefaultFileMetaDataConsumer(md4), true);
        FileMetaData md5 = readFileMetaData(in(baos), true);
        FileMetaData md6 = readFileMetaData(in(baos), false);
        Assert.assertEquals(md, md2);
//        assertEquals(md, md3);
//        assertNull(md4.getRow_groups());
//        assertNull(md5.getRow_groups());
//        assertEquals(md4, md5);
        md4.setRow_groups(md.getRow_groups());
        md5.setRow_groups(md.getRow_groups());
//        assertEquals(md, md4);
//        assertEquals(md, md5);
//        assertEquals(md4, md5);
//        assertEquals(md, md6);
    }

    private ByteArrayInputStream in(ByteArrayOutputStream baos) {
        return new ByteArrayInputStream(baos.toByteArray());
    }
}
