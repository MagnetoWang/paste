package design.pattern.prototype.framework;

import java.util.HashMap;

/**
 * @program: paste
 * @description: 管理原型文件的类。其实每个模式都需要一个有管理功能的类
 * @author: MagnetoWang
 * @create: 2018-07-19 21:00
 **/
public class Manager {
    private HashMap showcase = new HashMap();
    public void register(String name, Product proto) {
        showcase.put(name, proto);
    }
    public Product create(String protoname) {
        Product p = (Product)showcase.get(protoname);
        return p.createClone();
    }
}
