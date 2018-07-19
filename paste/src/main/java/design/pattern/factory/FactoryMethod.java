package design.pattern.factory;

/**
 * @program: paste
 * @description: 工厂方法模式。其实和抽象工厂模式相比，本质区别不大。
 * 抽象工厂模式只是多了几个接口作为承接抽象和具体类之间的桥梁
 * @author: MagnetoWang
 * @create: 2018-07-19 18:35
 **/
//工厂方法模式
public class FactoryMethod {
    public static void main(String args[]){
        AbstractFactory bigfactory;
        bigfactory = new IphoneFactory();
        bigfactory.produceIphone().run();
        bigfactory = new XiaoMiFactory();
        bigfactory.produceXiaoMi().run();
    }
}





