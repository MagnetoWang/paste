package json;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
/**
 * @program: paste
 * @description: 解析json字符串
 * @author: MagnetoWang
 * @create: 2018-08-22 12:28
 **/
public class ParseJson {
    private static final Logger logger = LoggerFactory.getLogger(ParseJson.class);
    private static String jsonString="{\"and\":[{\"or\":[{\"field\":\"bizcircleId\",\"action\":\"match\",\"value\":\"613000253\"}]},{\"or\":[{\"field\":\"appid\",\"action\":\"match\",\"value\":\"104\"}]},{\"or\":[{\"field\":\"cityId\",\"action\":\"match\",\"value\":\"310000\"}]},{\"or\":[{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107500000001\"},{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107500000002\"},{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107500000003\"},{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107500000004\"},{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107500000005\"},{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107500000009\"},{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107500000010\"},{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107500000012\"},{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107500000013\"},{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107500000014\"},{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107500000015\"},{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107500000017\"},{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107599999998\"}]},{\"or\":[{\"field\":\"priceTotal\",\"action\":\"range\",\"value\":\"[0,200)\"}]}]}";

    public static void main(String[] args) {
        parseFilter(jsonString);
        for(String e:filterHashMap.keySet()){
            System.out.println(e+" = "+JSONObject.toJSONString(filterHashMap.get(e)));
        }

    }
    private static Map<String ,List<String>> filterHashMap=new HashMap<>();
    public static Map parseFilter(String json){
        if(json == null){
            logger.error("filterjson is null !!!!");
            return null;
        }
        JSONObject jsonObject=JSON.parseObject(json);
        if(jsonObject.containsKey("and")){
            if(filterHashMap!=null){
                findFilter(jsonObject.getJSONArray("and"));
                return filterHashMap;
            }
        }
        logger.warn("返回 null ！！！");
        return null;
    }

    public static void findFilter(JSONArray jsonArray){
        if(jsonArray == null){
            logger.error("filterjson is null !!!!");
            return ;
        }
        List<String> filtersList;
        for(Object e :jsonArray){
            if(e instanceof JSONObject){
                if(((JSONObject) e).containsKey("field")
                        &&((JSONObject) e).containsKey("action")
                        &&((JSONObject) e).containsKey("value")){
                    if(filterHashMap.containsKey(((JSONObject) e).getString("field"))){
                        filtersList=filterHashMap.get(((JSONObject) e).getString("field"));
                    }else{
                        filtersList=new LinkedList<>();
                        filterHashMap.put(((JSONObject) e).getString("field"),filtersList);
                    }
                    filtersList.add(new String(((JSONObject) e).getString("value")));
                }
                if(((JSONObject) e).containsKey("or")){
                    findFilter(((JSONObject) e).getJSONArray("or"));
                }
            }
        }
    }
    public static String parseSort(String json){
        return null;
    }


}




