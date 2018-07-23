package design.pattern.state;

/**
 * @program: paste
 * @description: 状态模式.确定要做的内容
 * @author: MagnetoWang
 * @create: 2018-07-23 11:15
 **/
public interface State {
    public abstract void doClock(Context context, int hour);    // 设置时间
    public abstract void doUse(Context context);                // 使用金库
    public abstract void doAlarm(Context context);              // 按下警铃
    public abstract void doPhone(Context context);              // 正常通话
}
