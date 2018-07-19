package design.pattern.builder;

import javax.swing.*;

/**
 * @program: paste
 * @description: 执行Builder类
 * @author: MagnetoWang
 * @create: 2018-07-19 20:15
 **/
public class Main {
    public static void main(String[] args) {


        String[] kindOf={"plain","html","Frame"};
        if (kindOf[0].equals("plain")) {
            TextBuilder textbuilder = new TextBuilder();
            Director director = new Director(textbuilder);
            director.construct();
            String result = textbuilder.getResult();
            System.out.println(result);
        }
        if (kindOf[1].equals("html")) {
            HTMLBuilder htmlbuilder = new HTMLBuilder();
            Director director = new Director(htmlbuilder);
            director.construct();
            String filename = htmlbuilder.getResult();
            System.out.println(filename + "文件编写完成。");
        }
        if(kindOf[2].equals("Frame")){
            FrameBuilder framebuilder = new FrameBuilder();
            Director director = new Director(framebuilder);
            director.construct();
            JFrame frame = framebuilder.getResult();
            frame.setVisible(true);
        }
        {
            usage();
//            System.exit(0);
        }
    }
    public static void usage() {
        System.out.println("Usage: java Main plain      编写纯文本文档");
        System.out.println("Usage: java Main html       编写HTML文档");
    }
}
