package design.pattern.builder;

/**
 * @program: paste
 * @description: builder模式的基类
 * @author: MagnetoWang
 * @create: 2018-07-19 20:06
 **/
public abstract class Builder {
    public abstract void makeTitle(String title);
    public abstract void makeString(String str);
    public abstract void makeItems(String[] items);
    public abstract void close();
}
