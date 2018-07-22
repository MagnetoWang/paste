package design.pattern.ChainofResponsibility;

/**
 * @program: paste
 * @description:关于支持的一个功能。抽象类。集成所需要实现的方法
 * @author: MagnetoWang
 * @create: 2018-07-22 17:59
 **/
public abstract class Support {
    private String name;
    private Support next;
    public Support (String name){
        this.name=name;
    }
    public Support setNext(Support next) {  // 设置要推卸给的对象
        this.next = next;
        return next;
    
    }
    protected abstract boolean resolve(Trouble trouble);
    protected void done(Trouble trouble){
        System.out.println(trouble+" is resolved by "+this+".");
    }
    protected void fail(Trouble trouble){
        System.out.println(trouble+"cannot be resolved.");
    }
    //核心代码！
    public void support(Trouble trouble){
        if(resolve(trouble)){
            done(trouble);
        }else {
            if(next != null){
                next.support(trouble);
            }else{
                fail(trouble);
            }
        }
       
    }

    public String toString(){
        return "["+name+"]";
    }



}
