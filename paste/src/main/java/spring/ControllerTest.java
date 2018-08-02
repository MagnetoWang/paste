package spring;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: paste
 * @description: Controller测试类
 * @author: MagnetoWang
 * @create: 2018-08-02 14:54
 **/
public class ControllerTest {
    @RequestMapping("/test/{miles}")
    @ResponseBody
    public String mileageFee(@PathVariable String context) {
        ConfigurableTest    calc = new ConfigurableTest();
        return calc.print(context);
    }
}
