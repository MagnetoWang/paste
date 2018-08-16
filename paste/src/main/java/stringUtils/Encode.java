package stringUtils;

/**
 * @program: paste
 * @description: 解码相关字符串
 * @author: MagnetoWang
 * @create: 2018-08-16 10:54
 **/
public class Encode {
    static private String reg = "%([0-9]|[A-Z]){2}";
    static private String encode(String s){

        String replace = Regex.replace(reg, s, new Replacer() {
            @Override
            public String replace(String match) {
                switch (match) {
                    case "%20":
                        return " ";
                    case "%21":
                        return "!";
                    case "%22":
                        return "\"";
                    case "%23":
                        return "#";
                    case "%25":
                        return "%";
                    case "%26":
                        return "&";
                    case "%27":
                        return "'";
                    case "%28":
                        return "(";
                    case "%29":
                        return ")";
                    case "%2A":
                        return "*";
                    case "%2B":
                        return "+";
                    case "%2C":
                        return ",";
                    case "%40":
                        return "@";
                }
                return match;
            }
        });
        return replace;
    }
}
