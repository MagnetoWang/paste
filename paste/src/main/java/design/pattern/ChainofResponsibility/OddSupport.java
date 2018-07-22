package design.pattern.ChainofResponsibility;

/**
 * @program: paste
 * @description: 兼容过去支持的类
 * @author: MagnetoWang
 * @create: 2018-07-22 18:18
 **/
public class OddSupport extends Support {
    public OddSupport(String name) {                // 构造函数
        super(name);
    }
    protected boolean resolve(Trouble trouble) {    // 解决问题的方法
        if (trouble.getNumber() % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }
}
