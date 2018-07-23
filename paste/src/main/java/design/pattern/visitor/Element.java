package design.pattern.visitor;

/**
 * @program: paste
 * @description: 数据元素
 * @author: MagnetoWang
 * @create: 2018-07-23 11:59
 **/
public interface Element {
    public abstract void accept(Visitor v);
}
