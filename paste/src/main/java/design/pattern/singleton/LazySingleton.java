package design.pattern.singleton;

/**
 * @program: paste
 * @description: 懒汉模式的单例模式实现，用于在调用方法的时候才创建实例
 * @author: MagnetoWang
 * @create: 2018-07-19 18:01
 **/
public class LazySingleton {
    private volatile static LazySingleton singleton=null;
    private LazySingleton(){

    }

    /**
     * 用Double Check Locking 双检查锁机制。保证线程安全的同时，提高了效率。
     * 其实核心就是减小锁粒度，以及用volatile增加可见性
     * @return 单例的实例
     */
    public static LazySingleton getInstance(){
        if(singleton==null){
            try {
                //为了查看多线程竞争的效果
                Thread.sleep(300);

                synchronized (LazySingleton.class){
                    //双重检查！！
                    if(singleton == null){
                        singleton=new LazySingleton();
                    }

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return singleton;
    }
}
