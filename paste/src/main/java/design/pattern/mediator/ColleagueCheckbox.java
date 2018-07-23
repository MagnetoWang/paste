package design.pattern.mediator;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
/**
 * @program: paste
 * @description: 检查选项框
 * @author: MagnetoWang
 * @create: 2018-07-23 09:40
 **/
public class ColleagueCheckbox extends Checkbox implements ItemListener, Colleague {
    private Mediator mediator;
    public ColleagueCheckbox(String caption, CheckboxGroup group, boolean state) {  // 构造函数
        super(caption, group, state);
    }
    public void setMediator(Mediator mediator) {            // 保存Mediator
        this.mediator = mediator;
    }
    public void setColleagueEnabled(boolean enabled) {      // Mediator下达启用/禁用指示
        setEnabled(enabled);
    }
    public void itemStateChanged(ItemEvent e) {             // 当状态发生变化时通知Mediator
        mediator.colleagueChanged();
    }
}
