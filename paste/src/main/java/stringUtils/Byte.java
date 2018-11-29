package stringUtils;

import java.nio.ByteBuffer;

public class Byte {
    public static void main(String[] args) {
        final ByteBuffer buffer = ByteBuffer.allocate(24);

        buffer.put("H".getBytes());
        buffer.put("e".getBytes());
        buffer.put("l".getBytes());
        buffer.put("l".getBytes());
        buffer.put("o".getBytes());

        buffer.put(" ".getBytes());

        buffer.put("e".getBytes());
        buffer.put("a".getBytes());
        buffer.put("r".getBytes());
        buffer.put("t".getBytes());
        buffer.put("h".getBytes());
        buffer.put("!".getBytes());
        System.out.println(buffer.toString());
//
//        assertEquals("Buffer position invalid", 24, buffer.position());
//
//        buffer.flip();
//        assertEquals("Text data invalid", "Hello earth!", byteBufferToString(buffer));
    }
}
