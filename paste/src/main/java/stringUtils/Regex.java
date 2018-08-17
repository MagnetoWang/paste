package stringUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @program: paste
 * @description: 处理正则表达式
 * @create: 2018-08-16 10:58
 **/
public class Regex {
    static public String replace(String reg,String sourceString,Replacer replacer){
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(sourceString);
        while (matcher.find()){
            String group = matcher.group();
            String replace = replacer.replace(group);
            sourceString = matcher.replaceFirst(replace);
            matcher = Pattern.compile(reg).matcher(sourceString);
        }
        return sourceString;
    }
}
