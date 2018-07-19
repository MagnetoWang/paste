package design.pattern.factory;

/**
 * @program: paste
 * @description: 制造Iphone的手机工厂
 * @author: MagnetoWang
 * @create: 2018-07-19 18:42
 **/
public class IphoneFactory implements AbstractFactory {

    @Override
    public IPhone produceIphone() {
        return new IPhone();
    }

    @Override
    public XiaoMi produceXiaoMi() {
        return null;
    }
}
