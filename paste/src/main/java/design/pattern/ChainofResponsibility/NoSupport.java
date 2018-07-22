package design.pattern.ChainofResponsibility;



/**
 * @program: paste
 * @description: 不支持的类
 * @author: MagnetoWang
 * @create: 2018-07-22 18:11
 **/
public class NoSupport extends Support{
    public NoSupport (String name){
        super(name);
    }
    protected boolean resolve(Trouble trouble){
        return false;
    }
}
