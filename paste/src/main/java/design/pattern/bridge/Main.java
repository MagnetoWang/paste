package design.pattern.bridge;

/**
 * @program: paste
 * @description: 执行桥接模式
 * @author: MagnetoWang
 * @create: 2018-07-23 15:10
 **/
public class Main {
    public static void main(String[] args) {
        Display d1 = new Display(new StringDisplayImpl("Hello, China."));
        Display d2 = new CountDisplay(new StringDisplayImpl("Hello, World."));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe."));
        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(5);
    }
}
