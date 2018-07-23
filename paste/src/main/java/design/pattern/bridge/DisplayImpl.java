package design.pattern.bridge;

/**
 * @program: paste
 * @description: 桥接模式
 * @author: MagnetoWang
 * @create: 2018-07-23 15:07
 **/
public abstract class DisplayImpl {
    public abstract void rawOpen();
    public abstract void rawPrint();
    public abstract void rawClose();
}
