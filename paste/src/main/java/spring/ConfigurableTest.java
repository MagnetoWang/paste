package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * @program: paste
 * @description: 配置测试
 * @author: MagnetoWang
 * @create: 2018-08-02 14:55
 **/
@Configurable
public class ConfigurableTest {
    @Autowired
    private ServiceTest serviceTest;
    public String print(String context){
        return serviceTest.ratePerMile()+" configurableTest + "+context;
    }
}
