package design.pattern.factory;

/**
 * @program: paste
 * @description: 手机制造商
 * @author: MagnetoWang
 * @create: 2018-07-19 18:39
 **/
public class PhoneFactory implements AbstractFactory {

    @Override
    public IPhone produceIphone() {

        return new IPhone();
    }

    @Override
    public XiaoMi produceXiaoMi() {
        return new XiaoMi();
    }
}
