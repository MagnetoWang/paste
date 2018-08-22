package json;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
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
        parseFilter(null);
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
                if(filterHashMap.containsKey(((JSONObject) e).getString("field"))){
                    filtersList=filterHashMap.get(((JSONObject) e).getString("field"));
                }else{
                    filtersList=new LinkedList<>();
                    filterHashMap.put(((JSONObject) e).getString("field"),filtersList);
                }
                if(((JSONObject) e).containsKey("field")
                        &&((JSONObject) e).containsKey("action")
                        &&((JSONObject) e).containsKey("value")){
                    filtersList.add(new String(((JSONObject) e).getString("value")));
                }
                if(((JSONObject) e).containsKey("or")){
                    findFilter(((JSONObject) e).getJSONArray("or"));
                }
            }
        }

    }
//    public static String parseFilter1(String json){
//        if(json == null){
//            logger.error("filterjson is null !!!!");
//            return null;
//        }
//        JSONObject jsonObject=JSON.parseObject(json);
//        if(jsonObject.containsKey("and")){
//            filterJsonList =new FilterJsons();
//            filterJsonList.setOperator("and");
//            findFilter(jsonObject.getJSONArray("and"));
//
//        }
//        return filterJsonList.toString();
//    }




    public static String parseSort(String json){
        return null;
    }

    public static String printFilter1(@NotNull JSONArray jsonArray){
        List<FilterJson> filtersJsonList =new LinkedList<>();
        for(Object e :jsonArray){
            if(e instanceof JSONObject){
//                System.out.println("object : "+e.toString());
                if(((JSONObject) e).containsKey("field")
                        &&((JSONObject) e).containsKey("action")
                        &&((JSONObject) e).containsKey("value")){
                    FilterJson filterJson=new FilterJson();
                    filterJson.setField(((JSONObject) e).get("field").toString());
                    filterJson.setAction(((JSONObject) e).get("action").toString());
                    filterJson.setValue(((JSONObject) e).get("value").toString());
                    filtersJsonList.add(filterJson);
                    System.out.println(filterJson.toString());
                }
                if(((JSONObject) e).containsKey("or")){
//                    filterJsonList.setFiltersJsonList(filtersJsonList);
                    findFilter(((JSONObject) e).getJSONArray("or"));
                }
            }
        }
        return jsonArray.toJSONString();
    }
}

class FilterJsons{



    private List<FilterJsons> operatorList;
    private List<FilterJson> filtersJsonList;
    private String operator;

        public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
    public List<FilterJson> getFiltersJsonList() {
        return filtersJsonList;
    }

    public void setFiltersJsonList(List<FilterJson> filtersJsonList) {
        this.filtersJsonList = filtersJsonList;
    }
    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }
    public List<FilterJsons> getOperatorList() {
        return operatorList;
    }

    public void setOperatorList(List<FilterJsons> operatorList) {
        this.operatorList = operatorList;
    }
}

/**
 * and or 对应操作value都是数组格式
 * value和key,可以分别toString
 */
class FilterJson{

    private String field;
    private String value;
    private String action;

    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }


    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

}

class SortJson{
    private List<SortJson> jsonList;
    private String jsonKey;
    private String jsonValue;
}


