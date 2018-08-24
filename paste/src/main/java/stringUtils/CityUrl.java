package stringUtils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
/**
 * @program: paste
 * @description: 城市列表和url文件的操作,代码不具有高内聚的特点,不过思路可以参考
 * @author: MagnetoWang
 * @create: 2018-08-24 10:43
 **/
public class CityUrl {
    private  static Logger logger=LoggerFactory.getLogger(CityUrl.class);
    //循环总是少读最后一条城市，结尾一定要加个enter,文本中
    public static void main(String[] args) {
        CityUrl cityUrl=new CityUrl();
        Scanner in=new Scanner(System.in);

        routeUrl=new HashMap<>();
        while (in.hasNext()){
            String line=in.nextLine();
            if(cityUrl.checkLine(line)){

                cityUrl.getUrl(line);
                System.out.println("routeUrl.size()="+routeUrl.size());
//                System.out.println(routeUrl.toString());
            }

        }
//        cityUrl.checkLine(in.nextLine());
        System.out.println("end");
    }

    /**
     * 检查每一行是否符合有url，city,cityID的特点
     * @param line
     * @return
     */
    int count=0;
    int wrongCount=0;
    int sumCount=0;
    public boolean checkLine(String line){
        sumCount++;
        line=StringUtils.deleteWhitespace(line);

//        if(StringUtils.contains(line,"'m.ke.com/")){
//            System.out.println(line);
//        }
        if(StringUtils.contains(line,"//")||StringUtils.isEmpty(line)
                ||StringUtils.contains(line,"'m.ke.com/")){
//
            wrongCount++;
//            System.out.println(StringUtils.contains(line,"//"));
//            System.out.println(StringUtils.isEmpty(line));
//            logger.debug(line);
//            logger.debug("当前行有注释语句，无效");
            return false;
        }
        if(StringUtils.contains(line,"self")
                &&StringUtils.contains(line,"id")
                &&StringUtils.contains(line,"host")
                &&StringUtils.contains(line,"name")
                ){
            count++;
            System.out.println("wrongCount="+wrongCount);
            System.out.println("sumCount="+sumCount);

            System.out.println("count="+count);

//            System.out.println(count+" : "+line);
//            logger.info(line);
            return true;
        }
        return false;


    }

    /**
     * 正则表达式提取单引号内容，单引号范围必须尽可能的短，就要用非贪心模式，在*后面加上?
     * @param line
     */
    private static Map<String,String> routeUrl;
    public void getUrl(String line){
//        line="self::CITY_ID_RONGCHENG=>array('id'=>'371082','name'=>'荣成','host'=>'rongcheng.ke.com','short'=>'rongcheng','province'=>'山东省','pinyin'=>'rongcheng',)";



        List<String> answers=  Regex.getAllResult(line,"'.*?'");

        String route=null;
        String url=null;
        for(int i=0;i<answers.size();i++){
//            System.out.println(answers.get(i));
            if(answers.get(i).equals("'id'")){
                route=answers.get(i+1);
            }
            if(answers.get(i).equals("'host'")){
                url=answers.get(i+1);
//                System.out.println(route+url);
            }

            routeUrl.put(route,url);

        }
//        System.out.println(routeUrl.toString());

//        Pattern pattern = Pattern.compile("'.*?'");
//        Matcher matcher = pattern.matcher(line);
//        MatchResult matchResult= matcher.toMatchResult();
//        System.out.println(matchResult.group(2));
//        while (matcher.find()){
//
//
////            System.out.println(matcher.groupCount());
//            String group = matcher.group();
//            System.out.println(group);
//
//        }
    }
}
