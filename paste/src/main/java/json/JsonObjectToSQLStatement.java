package json;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: paste
 * @description: json对象转换对应sql语句
 * @author: MagnetoWang
 * @create: 2018-07-26 15:24
 **/
public class JsonObjectToSQLStatement {
    private  static Logger logger=LoggerFactory.getLogger(JsonObjectToSQLStatement.class);

    public static String JsonToSQLInsertStatement(JSONObject message){
        logger.info(message.toJSONString());
//        HashMap<String,Object> map=new HashMap<>();
        StringBuilder key=new StringBuilder();
        StringBuilder value=new StringBuilder();
        for(String e:message.keySet()){
//            map.put(e,message.get(e));

            key.append(e+",");
            if(message.get(e) == null){
                value.append("'',");
                continue;
            }
            if(message.get(e) instanceof Integer){
                value.append(message.get(e)+",");
                continue;

            }
            if(message.get(e) instanceof String){
                value.append("'"+message.get(e)+"'"+",");
                continue;
            }


        }
        key.delete(key.length()-1,key.length());
        logger.info(key.toString());
        value.delete(key.length()-1,key.length());
        System.out.println(value);
        String insert="insert into search.playback ("+ key+") values ("+value+")";
        return insert;
    }
}
