package design.pattern.state;

/**
 * @program: paste
 * @description: 执行模式
 * @author: MagnetoWang
 * @create: 2018-07-23 11:22
 **/
public class Main {
    public static void main(String[] args) {
        SafeFrame safeFrame=new SafeFrame("state Frame");
        //一直循环
        while (true){
            for(int hour=0;hour<24;hour++){
                //设置时间
                safeFrame.setClock(hour);
                try {
                    Thread.sleep(300);
                }catch (    InterruptedException e){

                }
            }
        }
    }
}
