package listUtils;
import java.util.*;
/**
 * @program: paste
 * @description: 验证list相关方法使用的易出错的地方
 * @author: MagnetoWang
 * @create: 2018-08-27 14:59
 **/
public class CheckListMethod {
    static String[] data={"107500000001","107500000002","107500000003","107500000004","107500000005","107500000009","107500000010","107500000012","107500000013","107500000014","107500000015","107500000017","107599999998"};

    public static void main(String[] args) {
        List<String> list = stringsToList(data);
        checkAddMethod(list);
    }

    /**
     * 验证结果
     * 从0计数，直接加入到第i个位置，当前的位置将会后移
     * @param list
     * @return
     */
    public static boolean checkAddMethod(List<String> list){
        showList(list);
        list.add(1,"asfds");
        showList(list);
        return true;
    }
    public static void showList(List<String> list){
        for(String e:list){
            System.out.printf(e+" , ");
        }
        System.out.println();
    }
    public static List<String> stringsToList(String[] list){
        List<String> list1=new LinkedList<>();
        for(String e:list){
            list1.add(e);
        }
        return list1;

    }
}
