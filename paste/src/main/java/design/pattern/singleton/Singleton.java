package design.pattern.singleton;

/**
 * @program: paste
 * @description: 单例模式的基本类。在单线程下没什么问题
 * @author: MagnetoWang
 * @create: 2018-07-19 17:33
 **/
public class Singleton {
    public static Singleton getInstance(){
        return instance;
    }

    private static Singleton instance=new Singleton();

    private Singleton(){}

}
