package dataUtils;

import java.util.UUID;

public class createUUID {
    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString(); //获取UUID并转化为String对象
        uuid = uuid.replace("-", "");               //因为UUID本身为32位只是生成时多了“-”，所以将它们去点就可
        System.out.println(uuid);
        Long number=new Long("1532595497000");
        System.out.println(number);
        Integer integer=new Integer("1532595497");
        System.out.println(integer);
    }
}
