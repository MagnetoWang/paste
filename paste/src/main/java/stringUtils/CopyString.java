package stringUtils;

public class CopyString {
    public static void main(String[] args) {
        String s = "nihao 1 hao";
        String t = s;
        t = t + s;
        System.out.println(s);
        System.out.println(t);
    }
}
