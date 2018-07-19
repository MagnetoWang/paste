package design.pattern.singleton;

/**
 * @program: paste
 * @description: 多线程调用单例模式
 * @author: MagnetoWang
 * @create: 2018-07-19 17:37
 **/
public class Multithread extends Thread{
    @Override
    public void run(){
        System.out.println(LazySingleton.getInstance().hashCode());
    }

    public static void main(String[] args) {
        MultiSingleton();
//        MultiLazySingleton();
    }
    public static void MultiLazySingleton(){

    }
    public static void MultiSingleton(){
        Multithread[] multithreads=new Multithread[10 ];
        for(int i=0;i<multithreads.length;i++){
            multithreads[i]=new Multithread();
        }
        for(int i=0;i<multithreads.length;i++){
            multithreads[i].start();
        }
    }
}
