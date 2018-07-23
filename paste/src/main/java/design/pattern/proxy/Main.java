package design.pattern.proxy;

/**
 * @program: paste
 * @description: 主函数类
 * @author: MagnetoWang
 * @create: 2018-07-23 13:52
 **/
public class Main {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("Alice");
        System.out.println("现在的名字是" + p.getPrinterName() + "。");
        p.setPrinterName("Bob");
        System.out.println("现在的名字是" + p.getPrinterName() + "。");
        p.print("Hello, world.");
    }
}
