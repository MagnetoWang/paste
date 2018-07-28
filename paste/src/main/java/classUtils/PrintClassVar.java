package classUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: paste
 * @description: 打印类的字段，并包装在list中
 * @author: MagnetoWang
 * @create: 2018-07-27 18:51
 **/
public class PrintClassVar {
    public static List<String> orderList=new LinkedList<>();
    public static void main(String[] args) {
        String[] length={"dig_timestamp","click_housecode","fb_query_id","pt","operation_type","requestFunctionScores","queryFuzziness","search_query","fb_ab_test_flag","uuid","fb_service_id","returnRelativeScore","total","requestId","client","strategyId","id","operation_timestamp","cityIds","sorts","queryOperator","ucid","click_timestamp","cost","click_fb_expo_id","search_docs","queryMinimumShouldMatch","filters","fls","search_index","route","size","page","sortedQueryMinimumShouldMatch","aggregations","qfs"};
        StringBuilder sqlKey=new StringBuilder();
        StringBuilder sqlSet=new StringBuilder();
        for(String e:length){
            sqlKey.append(e+",");
            sqlSet.append("?,");
        }
        sqlKey.delete(sqlKey.length()-1,sqlKey.length());
        sqlSet.delete(sqlSet.length()-1,sqlSet.length());
        System.out.println("("+sqlKey.toString()+")");
        System.out.println("("+sqlSet.toString()+");");

        PlayBackTable playBackTable=new PlayBackTable();
        JSONObject jsonObject=JSONObject.parseObject(JSON.toJSONString(playBackTable));
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("[");
        for(String e: jsonObject.keySet()){
            orderList.add(e);
//            System.out.print(e);
            stringBuilder.append(e+",");
//            System.out.print(",");

        }
        Collections.sort(orderList);
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());


    }
}
