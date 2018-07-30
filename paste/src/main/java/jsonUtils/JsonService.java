package jsonUtils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * @program: paste
 * @description: json一些常用操作
 * @author: MagnetoWang
 * @create: 2018-07-30 16:41
 **/
public class JsonService {
    private  static Logger logger=LoggerFactory.getLogger(JsonService.class);
    private static  String[] playbackSet={"dig_timestamp","click_housecode","fb_query_id","pt","operation_type","requestFunctionScores","queryFuzziness","search_query","fb_ab_test_flag","uuid","fb_service_id","returnRelativeScore","total","requestId","client","strategyId","id","operation_timestamp","cityIds","sorts","queryOperator","ucid","click_timestamp","cost","click_fb_expo_id","search_docs","queryMinimumShouldMatch","filters","fls","search_index","route","size","page","sortedQueryMinimumShouldMatch","aggregations","qfs"};
    public static void main(String[] args) {
        String key="dig_timestamp,click_housecode,fb_query_id,queryFuzziness,fb_ab_test_flag,search_query,uuid,fb_service_id,returnRelativeScore,total,requestId,client,strategyId,cityIds,sorts,queryOperator,ucid,click_timestamp,cost,click_fb_expo_id,search_docs,queryMinimumShouldMatch,filters,fls,search_index,route,size,page,sortedQueryMinimumShouldMatch,aggregations,qfs,";
        StringBuilder keyBuiler=new StringBuilder();
        keyBuiler.append("(");
        keyBuiler.append(key);
        keyBuiler.delete(keyBuiler.length()-1,keyBuiler.length());
        keyBuiler.append(")");
        System.out.println(keyBuiler);
    }

    /**
     * "insert into 表名 ("+ key+") values ("+value+");"
     * @param message
     * @return
     */
    public static String convertJsonToSQLInsertStatement(JSONObject message){
        logger.debug(message.toJSONString());
//        HashMap<String,Object> map=new HashMap<>();
        StringBuilder key=new StringBuilder();
        StringBuilder value=new StringBuilder();
        for(String e:message.keySet()){
            key.append(e+",");

            if(message.get(e) instanceof String){
                value.append("'"+(String)message.get(e)+"',");
                continue;
            }
            if(message.get(e) instanceof Long){
                value.append((Long)message.get(e)+",");
                continue;
            }
            if(message.get(e) instanceof Integer){
                value.append((Integer)message.get(e)+",");
                continue;
            }

            value.append("'',");
            continue;
        }
        key.delete(key.length()-1,key.length());
        logger.debug(key.toString());
        value.delete(value.length()-1,value.length());
        String insert="insert into search.playback ("+ key+") values ("+value+");";
//        System.out.println();
//        System.out.println(insert);
//        System.out.println();
        return insert;
    }
    /**
     *
     * @param message json消息包
     * @param target 指定key值。按格式来，如："search_log request index"。空格分割开
     * @return
     */
    public static String getJsonObjectStringValue(JSONObject message, String target){
//        target="search_log request index";
        String[] lastWord=target.split(" ");
//        System.out.print(lastWord[lastWord.length-1]+"   =    ");
        JSONObject object = message.getJSONObject(lastWord[0]);
        for(int i=1;i<lastWord.length-1;i++){
            object=object.getJSONObject(lastWord[i]);
        }

//        return JSONObject.toJSONString(object);

        return object.getString(lastWord[lastWord.length-1]);
    }

    /**
     *
     * @param message json消息包
     * @param target 指定key值。按格式来，如："search_log request index"。空格分割开
     * @return
     */
    public static Integer getJsonObjectIntegerValue(JSONObject message,String target){
//        target="search_log request index";
        String[] lastWord=target.split(" ");
//        System.out.print(lastWord[lastWord.length-1]+"   =    ");
        JSONObject object = message.getJSONObject(lastWord[0]);
        for(int i=1;i<lastWord.length-1;i++){
            object=object.getJSONObject(lastWord[i]);
        }
        return object.getInteger(lastWord[lastWord.length-1]);
    }
    /**
     *
     * @param message json消息包
     * @param target 指定key值。按格式来，如："search_log request index"。空格分割开
     * @return
     */
    public static Date getJsonObjectDateValue(JSONObject message, String target){
//        target="search_log request index";
        String[] lastWord=target.split(" ");
//        System.out.print(lastWord[lastWord.length-1]+"   =    ");
        JSONObject object = message.getJSONObject(lastWord[0]);
        for(int i=1;i<lastWord.length-1;i++){
            object=object.getJSONObject(lastWord[i]);
        }
        return object.getDate(lastWord[lastWord.length-1]);
    }
    /**
     *
     * @param message json消息包
     * @param target 指定key值。按格式来，如："search_log request index"。空格分割开
     * @return
     */
    public static Long getJsonObjectLongValue(JSONObject message, String target){
        //        target="search_log request index";
        String[] lastWord=target.split(" ");
//        System.out.print(lastWord[lastWord.length-1]+"   =    ");
        JSONObject object = message.getJSONObject(lastWord[0]);
        for(int i=1;i<lastWord.length-1;i++){
            object=object.getJSONObject(lastWord[i]);
        }
        return object.getLong(lastWord[lastWord.length-1]);
    }

    /**
     * 打印json存储对象的类型，可以直接复制到markdown
     * @param jsonObject
     */
    public static void printJsonObjectType(JSONObject jsonObject){
        int i = 0;
        for (String e : jsonObject.keySet()) {
            i++;
            System.out.println(i + ". " + e + " : " + jsonObject.get(e).getClass().getName());
        }
    }

    /**
     * 打印json详细的信息，并直观表示出来。可以直接复制到markdown
     * @param jsonObject
     */
    public static void printJsonObject(JSONObject jsonObject) {
        int i = 0;
        for (String e : jsonObject.keySet()) {
            i++;
            System.out.println(i + ". " + e + " : " + jsonObject.get(e));
        }
    }
    /**
     * 目前支持Long,Integer,String
     * @param type
     * @return
     */
    public static Integer getSizeOf(String type){
        Integer size=new Integer(Integer.MIN_VALUE);
        if(type.equals("String")){
            size=new Integer(Integer.MAX_VALUE);
        }
        if(type.equals("Integer")){
            size=new Integer(16);
        }
        if(type.equals("Long")){
            size=new Integer(16);
        }

        return size;

    }
}
