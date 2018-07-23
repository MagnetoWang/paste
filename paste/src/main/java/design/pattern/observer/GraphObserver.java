package design.pattern.observer;

/**
 * @program: paste
 * @description: 图形化观察者
 * @author: MagnetoWang
 * @create: 2018-07-23 11:04
 **/
public class GraphObserver implements Observer{
    public void update(NumberGenerator generator) {
        System.out.print("GraphObserver:");
        int count = generator.getNumber();
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println("");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}
