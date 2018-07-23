package design.pattern.mediator;

/**
 * @program: paste
 * @description: 同事按钮类
 * @author: MagnetoWang
 * @create: 2018-07-23 09:42
 **/
import java.awt.Button;

public class ColleagueButton extends Button implements Colleague {
    private Mediator mediator;
    public ColleagueButton(String caption) {
        super(caption);
    }
    public void setMediator(Mediator mediator) {            // 保存Mediator
        this.mediator = mediator;
    }
    public void setColleagueEnabled(boolean enabled) {      // Mediator下达启用/禁用的指示
        setEnabled(enabled);
    }
}