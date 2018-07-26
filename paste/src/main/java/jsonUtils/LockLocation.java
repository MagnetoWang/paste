package jsonUtils;


import com.alibaba.fastjson.JSONObject;

import java.util.Date;

/**
 * @program: paste
 * @description: 快速定位并提取想要的json字段位置
 * @author: MagnetoWang
 * @create: 2018-07-26 09:41
 **/
public class LockLocation {
    /**
     *
     * @param message json格式消息包
     * @param target 指定key值。按格式来，如："search_log request index"。空格分割开
     * @return
     */
    public String getJsonObjectStringValue(JSONObject message, String target){
//        target="search_log request index";
        String[] lastWord=target.split(" ");
        System.out.print(lastWord[lastWord.length-1]+"   =    ");
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
    public Integer getJsonObjectIntegerValue(JSONObject message, String target){
//        target="search_log request index";
        String[] lastWord=target.split(" ");
        System.out.println(lastWord[lastWord.length-1]);
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
    public Date getJsonObjectDateValue(JSONObject message, String target){
//        target="search_log request index";
        String[] lastWord=target.split(" ");
        System.out.println(lastWord[lastWord.length-1]);
        JSONObject object = message.getJSONObject(lastWord[0]);
        for(int i=1;i<lastWord.length-1;i++){
            object=object.getJSONObject(lastWord[i]);
        }
        return object.getDate(lastWord[lastWord.length-1]);
    }

}
