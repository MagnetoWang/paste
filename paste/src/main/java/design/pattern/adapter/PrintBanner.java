package design.pattern.adapter;



/**
 * @program: paste
 * @description: 打印标记
 * @author: MagnetoWang
 * @create: 2018-07-23 12:35
 **/
public class PrintBanner extends Print {
    private Banner banner;
    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }
    public void printWeak() {
        banner.showWithParen();
    }
    public void printStrong() {
        banner.showWithAster();
    }
}