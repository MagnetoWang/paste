package design.pattern.prototype.framework;

/**
 * @program: paste
 * @description: 具体的原型接口
 * @author: MagnetoWang
 * @create: 2018-07-19 21:08
 **/
public interface Product extends Cloneable {
    public abstract void use(String s);
    public abstract Product createClone();
}
