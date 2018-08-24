package stringUtils;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
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

    /**
     * 执行正则表达式，并返回所有结果
     * @param line
     * @param regex
     */
    public static List<String> getAllResult(String line,String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        List<String> results=new LinkedList<>();
        while (matcher.find()){
            String group = matcher.group();
            results.add(group);
        }
        return results;
    }
}
