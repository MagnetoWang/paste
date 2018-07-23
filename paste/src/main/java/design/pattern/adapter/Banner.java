package design.pattern.adapter;

/**
 * @program: paste
 * @description: 框架
 * @author: MagnetoWang
 * @create: 2018-07-23 13:33
 **/
public class Banner {
    private String string;
    public Banner(String string) {
        this.string = string;
    }
    public void showWithParen() {
        System.out.println("(" + string + ")");
    }
    public void showWithAster() {
        System.out.println("*" + string + "*");
    }
}
