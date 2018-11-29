package file;

import java.io.File;

public class deleteFile {
    public static void main(String[] args) {
        File test = new File("test.txt");
        test.delete();
    }
}
