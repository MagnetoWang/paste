package design.pattern.bridge;

/**
 * @program: paste
 * @description: 显示计数情况
 * @author: MagnetoWang
 * @create: 2018-07-23 15:08
 **/
public class CountDisplay extends Display {
    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }
    public void multiDisplay(int times) {       // 循环显示times次
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}
