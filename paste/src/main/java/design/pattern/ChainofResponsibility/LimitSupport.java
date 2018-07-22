package design.pattern.ChainofResponsibility;

/**
 * @program: paste
 * @description: 具有限制功能的类
 * @author: MagnetoWang
 * @create: 2018-07-22 18:13
 **/
public class LimitSupport extends Support{
    private int limit;
    public LimitSupport(String name,int limit){
        super(name);
        this.limit=limit;
    }
    protected boolean resolve(Trouble trouble){
        if(trouble.getNumber()<limit){
            return true;

        }else{
            return false;
        }
    }


}
