package jsonUtils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;

/**
 * @program: paste
 * @description: 快速定位并提取想要的json字段位置
 * @author: MagnetoWang
 * @create: 2018-07-26 09:41
 **/
public class LockLocation {
    public static void main(String[] args) {
        String message="{\"docs\":[{\"strategy_info\":{\"fb_expo_id\":\"74891355140698112\",\"fb_item_location\":\"0\"}},{\"strategy_info\":{\"fb_expo_id\":\"74891355140698113\",\"fb_item_location\":\"1\"}},{\"strategy_info\":{\"fb_expo_id\":\"74891355140698114\",\"fb_item_location\":\"2\"}},{\"strategy_info\":{\"fb_expo_id\":\"74891355140698115\",\"fb_item_location\":\"3\"}},{\"strategy_info\":{\"fb_expo_id\":\"74891355140698116\",\"fb_item_location\":\"4\"}},{\"strategy_info\":{\"fb_expo_id\":\"74891355140698117\",\"fb_item_location\":\"5\"}},{\"strategy_info\":{\"fb_expo_id\":\"74891355140698118\",\"fb_item_location\":\"6\"}},{\"strategy_info\":{\"fb_expo_id\":\"74891355140698119\",\"fb_item_location\":\"7\"}},{\"strategy_info\":{\"fb_expo_id\":\"74891355140698120\",\"fb_item_location\":\"8\"}},{\"strategy_info\":{\"fb_expo_id\":\"74891355140698121\",\"fb_item_location\":\"9\"}},{\"strategy_info\":{\"fb_expo_id\":\"74891355140698122\",\"fb_item_location\":\"10\"}},{\"strategy_info\":{\"fb_expo_id\":\"74891355140698123\",\"fb_item_location\":\"11\"}},{\"strategy_info\":{\"fb_expo_id\":\"74891355140698124\",\"fb_item_location\":\"12\"}},{\"strategy_info\":{\"fb_expo_id\":\"74891355140698125\",\"fb_item_location\":\"13\"}},{\"strategy_info\":{\"fb_expo_id\":\"74891355140698126\",\"fb_item_location\":\"14\"}},{\"strategy_info\":{\"fb_expo_id\":\"74891355140698127\",\"fb_item_location\":\"15\"}},{\"strategy_info\":{\"fb_expo_id\":\"74891355140698128\",\"fb_item_location\":\"16\"}},{\"strategy_info\":{\"fb_expo_id\":\"74891355140698129\",\"fb_item_location\":\"17\"}},{\"strategy_info\":{\"fb_expo_id\":\"74891355140698130\",\"fb_item_location\":\"18\"}},{\"strategy_info\":{\"fb_expo_id\":\"74891355140698131\",\"fb_item_location\":\"19\"}}]}\n";
        LockLocation lockLocation=new LockLocation();
        lockLocation.getJsonArrayValue(message);
    }
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

    /**
     * 定位json数组某个位置。感觉没有什么特别高效的方法啊
     * @param message
     * @return
     */
    public String getJsonArrayValue(String message){

//        jsonObject.getJSONArray("strategy_info");
        JSONArray jsonArray = JSONObject.parseObject(message).getJSONArray("docs");
        for(Object e:jsonArray){
            System.out.println(e.toString());
            System.out.println(((JSONObject)e).getJSONObject("strategy_info").getString("fb_item_location"));
        }

        return "";
    }
    //{"docs":[{"strategy_info":{"fb_expo_id":"74891355140698112","fb_item_location":"0"}},{"strategy_info":{"fb_expo_id":"74891355140698113","fb_item_location":"1"}},{"strategy_info":{"fb_expo_id":"74891355140698114","fb_item_location":"2"}},{"strategy_info":{"fb_expo_id":"74891355140698115","fb_item_location":"3"}},{"strategy_info":{"fb_expo_id":"74891355140698116","fb_item_location":"4"}},{"strategy_info":{"fb_expo_id":"74891355140698117","fb_item_location":"5"}},{"strategy_info":{"fb_expo_id":"74891355140698118","fb_item_location":"6"}},{"strategy_info":{"fb_expo_id":"74891355140698119","fb_item_location":"7"}},{"strategy_info":{"fb_expo_id":"74891355140698120","fb_item_location":"8"}},{"strategy_info":{"fb_expo_id":"74891355140698121","fb_item_location":"9"}},{"strategy_info":{"fb_expo_id":"74891355140698122","fb_item_location":"10"}},{"strategy_info":{"fb_expo_id":"74891355140698123","fb_item_location":"11"}},{"strategy_info":{"fb_expo_id":"74891355140698124","fb_item_location":"12"}},{"strategy_info":{"fb_expo_id":"74891355140698125","fb_item_location":"13"}},{"strategy_info":{"fb_expo_id":"74891355140698126","fb_item_location":"14"}},{"strategy_info":{"fb_expo_id":"74891355140698127","fb_item_location":"15"}},{"strategy_info":{"fb_expo_id":"74891355140698128","fb_item_location":"16"}},{"strategy_info":{"fb_expo_id":"74891355140698129","fb_item_location":"17"}},{"strategy_info":{"fb_expo_id":"74891355140698130","fb_item_location":"18"}},{"strategy_info":{"fb_expo_id":"74891355140698131","fb_item_location":"19"}}]
    //}},"timestamp":"1532591490478","fb_query_id":"74891355132325888","fb_service_id":"1011710017","ucid":"0","fb_ab_test_flag":"","request":{"index":"1011710017","qfs":["title","houseCode","resblockName"],"requestFunctionScores":[{"weight":1000.0,"filter":{"and":[{"or":[{"field":"tags","action":"match","value":"is_vr"}]}]}}],"queryOperator":"OR","requestId":"","query":"","strategyId":0,"fls":["houseCode"],"aggregations":[],"returnRelativeScore":false,"size":20,"cityIds":["440600"],"page":2,"queryMinimumShouldMatch":"-25%","queryFuzziness":-1,"sortedQueryMinimumShouldMatch":"1","sorts":[{"field":"priceTotal","order":"asc"}],"filters":{"and":[{"or":[{"field":"bizcircleId","action":"match","value":"1100000514"}]},{"or":[{"field":"appid","action":"match","value":"104"}]},{"or":[{"field":"cityId","action":"match","value":"440600"}]},{"or":[{"field":"houseType","action":"match","value":"107500000001"},{"field":"houseType","action":"match","value":"107500000002"},{"field":"houseType","action":"match","value":"107500000003"},{"field":"houseType","action":"match","value":"107500000004"},{"field":"houseType","action":"match","value":"107500000005"},{"field":"houseType","action":"match","value":"107500000009"},{"field":"houseType","action":"match","value":"107500000010"},{"field":"houseType","action":"match","value":"107500000012"},{"field":"houseType","action":"match","value":"107500000013"},{"field":"houseType","action":"match","value":"107500000014"},{"field":"houseType","action":"match","value":"107500000015"},{"field":"houseType","action":"match","value":"107500000017"},{"field":"houseType","action":"match","value":"107599999998"}]},{"or":[{"field":"bedroomNum","action":"match","value":"3"}]}]}},"uuid":"eb01ca40c178457430b9397c9913989b","type":"search","cost":18},"search_dig":{"timestamp":"1532591490000","fb_query_id":"74891355132325888","client":"app","uuid":"833FC61F-2F4C-48BA-B4D4-C6AECE3EDE20","time_local":"2018-07-26 15:52:24"}}

}
