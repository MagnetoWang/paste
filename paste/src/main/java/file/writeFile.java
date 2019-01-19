package file;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @ClassName writeFile.java
 * @author : Magneto_Wang
 * @date  2018年11月28日 下午5:11:21
 * @Description  文件写入操作
 * @see ： 注意编码格式和文件读取流的顺序
 *
 */
public class writeFile {
    public static String fileName="src/main/java/file/query.txt";
    public static void main(String[] args) {
//        writeMethod1();
//        writeMethod2();
//        writeMethod3();
        writeFile one = new writeFile();
        one.nonStatic();
    }
    public void nonStatic () {
        writeMethod4();
        Scanner in = new Scanner(System.in);
        in.nextLine();
    }
    /**
     * 使用FileWriter类写文本文件
     */
    public static void writeMethod1() {
        try {
            //使用这个构造函数时，如果存在kuka.txt文件，
            //则先把这个文件给删除掉，然后创建新的kuka.txt
            File test = new File(fileName);
            FileWriter writer=new FileWriter(test);
            writer.write("Hello Kuka:\n");
            writer.write("  My name is coolszy!\n");
            writer.write("  I like you and miss you。");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 使用FileWriter类往文本文件中追加信息
     */
    public static void writeMethod2() {
        try {
            //使用这个构造函数时，如果存在kuka.txt文件，
            //则直接往kuka.txt中追加字符串
            FileWriter writer=new FileWriter(fileName,true);
            SimpleDateFormat format=new SimpleDateFormat();
            String time=format.format(new Date());
            writer.write("\n\t"+time);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //注意：上面的例子由于写入的文本很少，使用FileWrite类就可以了。但如果需要写入的
    //内容很多，就应该使用更为高效的缓冲器流类BufferedWriter。
    /**
     * 使用BufferedWriter类写文本文件
     */
    public static void writeMethod3() {
        try {
            BufferedWriter out=new BufferedWriter(new FileWriter(fileName));
            out.write("Hello Kuka:");
            out.newLine();  //注意\n不一定在各种计算机上都能产生换行的效果
            out.write("  My name is coolszy!\n");
            out.write("  I like you and miss you。");
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void writeMethod4() {
        File file = new File(fileName);
        FileWriter writer = null;
        String context = "01\nwrite writ";
        try {
            writer = new FileWriter(file, false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(context);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        context = "write write number 2";
//        try {
//            writer = new FileWriter(file, false);
//            BufferedWriter bufferedWriter = new BufferedWriter(writer);
//            bufferedWriter.write(context);
//            bufferedWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    /**
     * 使用FileReader类读文本文件
     */
    public static void readMethod1() {
        int c=0;
        try {
            FileReader reader=new FileReader(fileName);
            c=reader.read();
            while(c!=-1) {
                System.out.print((char)c);
                c=reader.read();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用BufferedReader类读文本文件
     */
    public static void readMethod2() {
        String fileName="c:/kuka.txt";
        String line="";
        try {
            BufferedReader in=new BufferedReader(new FileReader(fileName));
            line=in.readLine();
            while (line!=null) {
                System.out.println(line);
                line=in.readLine();
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
