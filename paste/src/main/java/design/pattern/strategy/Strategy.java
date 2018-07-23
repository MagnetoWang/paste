package design.pattern.strategy;

/**
 * @program: paste
 * @description: 策略模式
 * @author: MagnetoWang
 * @create: 2018-07-23 11:33
 **/
public interface Strategy   {
    public abstract Hand nextHand();
    public abstract void study(boolean win);
}
