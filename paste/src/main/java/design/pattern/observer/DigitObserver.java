package design.pattern.observer;

/**
 * @program: paste
 * @description: 打印当前数字的观察者
 * @author: MagnetoWang
 * @create: 2018-07-23 11:05
 **/
public class DigitObserver implements Observer{
    public void update(NumberGenerator generator) {
        System.out.println("DigitObserver:" + generator.getNumber());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}
