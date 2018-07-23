package design.pattern.observer;

/**
 * @program: paste
 * @description: 观察者模式
 * @author: MagnetoWang
 * @create: 2018-07-23 11:01
 **/
public interface Observer {
    public abstract void update(NumberGenerator generator);
}
