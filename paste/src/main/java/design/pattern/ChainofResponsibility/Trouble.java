package design.pattern.ChainofResponsibility;

/**
 * @program: paste
 * @description: 用来描述异常的类
 * @author: MagnetoWang
 * @create: 2018-07-22 18:10
 **/
public class Trouble {
    private int number;
    public Trouble (int number){
        this.number=number;
    }
    public int getNumber() {        // 获取问题编号
        return number;
    }
    public String toString() {      // 代表问题的字符串
        return "[Trouble " + number + "]";
    }
}
