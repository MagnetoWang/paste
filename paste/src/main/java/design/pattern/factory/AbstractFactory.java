package design.pattern.factory;

/**
 * @program: paste
 * @description: 工厂的抽象
 * @author: MagnetoWang
 * @create: 2018-07-19 18:38
 **/
//只能生产一种类型的手机。而不能生产其他类型的。有限制！
//public interface AbstractFactory {
//    AbstractPhone produce();
//}
//可以生产多个不同产品
public interface AbstractFactory {
    IPhone produceIphone();
    XiaoMi produceXiaoMi();
}