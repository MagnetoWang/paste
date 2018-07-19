package design.pattern.factory;

/**
 * @program: paste
 * @description: 制造小米的手机工厂
 * @author: MagnetoWang
 * @create: 2018-07-19 18:51
 **/
public class XiaoMiFactory implements AbstractFactory {
    @Override
    public IPhone produceIphone() {
        return null;
    }

    @Override
    public XiaoMi produceXiaoMi() {
        return new XiaoMi();
    }
}
