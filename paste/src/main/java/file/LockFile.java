package file;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;


public class LockFile {
    public static String fileName="src/main/java/file/query.txt";
    public static void main(String[] args) {
        FileChannel channel = null;
        FileLock lock = null;
        try {
            RandomAccessFile file = new RandomAccessFile(fileName, "rw");
            channel = file.getChannel();
            String context = "01\nwrite ddddwrit";
            lock = channel.lock();
            channel.write(ByteBuffer.wrap(context.getBytes()));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (lock != null) {
                try {
                    lock.release();
                    lock = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (channel != null) {
                try {
                    channel.close();
                    channel = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
