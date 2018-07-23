package design.pattern.mediator;

/**
 * @program: paste
 * @description: 同事接口
 * @author: MagnetoWang
 * @create: 2018-07-23 09:41
 **/
public interface Colleague {
    public abstract void setMediator(Mediator mediator);
    public abstract void setColleagueEnabled(boolean enabled);
}
