package design.pattern.proxy;

/**
 * @program: paste
 * @description: 代理模式基础类
 * @author: MagnetoWang
 * @create: 2018-07-23 13:51
 **/
public interface Printable {
    public abstract void setPrinterName(String name);   // 设置名字
    public abstract String getPrinterName();            // 获取名字
    public abstract void print(String string);          // 显示文字（打印输出）
}
