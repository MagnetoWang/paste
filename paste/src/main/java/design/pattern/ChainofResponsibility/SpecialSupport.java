package design.pattern.ChainofResponsibility;

/**
 * @program: paste
 * @description: 专门处理特殊问题的类
 * @author: MagnetoWang
 * @create: 2018-07-22 18:17
 **/
public class SpecialSupport extends Support{
    private int number;                                 // 只能解决指定编号的问题
    public SpecialSupport(String name, int number) {    // 构造函数
        super(name);
        this.number = number;
    }
    protected boolean resolve(Trouble trouble) {        // 解决问题的方法
        if (trouble.getNumber() == number) {
            return true;
        } else {
            return false;
        }
    }
}
