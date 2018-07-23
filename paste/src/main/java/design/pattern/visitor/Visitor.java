package design.pattern.visitor;

/**
 * @program: paste
 * @description: 访问者模式
 * @author: MagnetoWang
 * @create: 2018-07-23 11:58
 **/
public abstract class Visitor {
    public abstract void visit(File file);
    public abstract void visit(Directory directory);
}
