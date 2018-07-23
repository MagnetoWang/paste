package design.pattern.decorator;

/**
 * @program: paste
 * @description: 装饰模式
 * @author: MagnetoWang
 * @create: 2018-07-23 15:26
 **/

public abstract class Display {
    public abstract int getColumns();               // 获取横向字符数
    public abstract int getRows();                  // 获取纵向行数
    public abstract String getRowText(int row);     // 获取第row行的字符串
    public void show() {                            // 全部显示
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}
