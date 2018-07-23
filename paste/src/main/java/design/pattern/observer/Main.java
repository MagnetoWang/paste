package design.pattern.observer;

/**
 * @program: paste
 * @description: 执行观察者类
 * @author: MagnetoWang
 * @create: 2018-07-23 11:06
 **/
public class Main {
    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator();
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.execute();
    }
}
