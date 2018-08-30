package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @program: paste
 * @description: 替换json里面的内容
 * @author: MagnetoWang
 * @create: 2018-08-29 15:21
 **/
public class TranslateJson {
    private static String filterJson="";
    private static String sortJson="";
    private static String filterString="{\"and\":[{\"or\":[{\"field\":\"appid\",\"action\":\"match\",\"value\":\"104\"},{\"field\":\"appid\",\"action\":\"match\",\"value\":\"105\"}]},{\"or\":[{\"field\":\"cityId\",\"action\":\"match\",\"value\":\"410100\"}]},{\"or\":[{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107500000001\"},{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107500000002\"},{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107500000003\"},{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107500000004\"},{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107500000005\"},{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107500000009\"},{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107500000010\"},{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107500000012\"},{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107500000013\"},{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107500000014\"},{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107500000015\"},{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107500000017\"},{\"field\":\"houseType\",\"action\":\"match\",\"value\":\"107599999998\"}]},{\"or\":[{\"field\":\"resblockId\",\"action\":\"match\",\"value\":\"3320027151281521\"}]}]}";
    private static String sortString="[{\"field\":\"_score\",\"order\":\"desc\"},{\"field\":\"houseQ\",\"order\":\"desc\"},{\"field\":\"_uid\",\"order\":\"asc\"}]";


    private  Map<String,Map<String ,String>> twoLayerMap;

    public static void main(String[] args) {
        TranslateJson translateJson=new TranslateJson();
//        twoLayerMap=new HashMap<>();

//        translateJson.addData(filterJson);
//        translateJson.addData(sortJson);
        System.out.println(translateJson.getTwoLayerMap().toString());
        System.out.println(JSONObject.toJSONString(translateJson.translateFilter(ParseJson.parseFilter(filterString))));
        System.out.println(JSONObject.toJSONString(translateJson.translateSort(ParseJson.parseSort(ParseJson.sortToJsonString(sortString)))));
    }
    public  void addData(String twoLayer){
        if(twoLayer==null||twoLayer.equals("")){
//            logger.error("null: twoLayer = {} !!!  ");
            return;
        }
        JSONObject jsonObject=JSON.parseObject(twoLayer);
        for(String e:jsonObject.keySet()){
            Map<String ,String> coreMap=new HashMap<>();
            for(String ee:jsonObject.getJSONObject(e).keySet())
            {
                coreMap.put(ee,jsonObject.getJSONObject(e).getString(ee));
            }
            twoLayerMap.put(e,coreMap);
        }
    }
    public  Map translateSort(Map<String,String> map){
        Map<String,Map<String ,String>> twoLayerMap=getTwoLayerMap();

        Map<String,String> realData=new HashMap<>();
        for(String e:map.keySet()){
            if(twoLayerMap.containsKey(e)){
                realData.put(twoLayerMap.get("sort").get(e),twoLayerMap.get("sort").get(e));
            }else {
                realData.put(e,map.get(e));
            }
        }
//        realData.put("")
        return realData;
    }
    public  Map translateFilter(Map<String ,List<String>> map){
        Map<String,Map<String ,String>> twoLayerMap=getTwoLayerMap();

        Map<String ,List<String>> realdata=new HashMap<>();

        for(String e:map.keySet()){
            if(twoLayerMap.containsKey(e)){
                List<String> strings=new LinkedList<>();
                for(String ee:map.get(e)){
                    if(twoLayerMap.get(e).get(ee)!=null){

                    }
                    strings.add(twoLayerMap.get(e).get(ee));
                }
                realdata.put(twoLayerMap.get(e).get(e),strings);
            }else{
                realdata.put(e,map.get(e));
            }
        }
        return realdata;
    }

    public  Map<String, Map<String, String>> getTwoLayerMap() {
        if(twoLayerMap==null){
            twoLayerMap=new HashMap<>();
            addData(filterJson);
            addData(sortJson);
        }
        return twoLayerMap;
    }

    public  void setTwoLayerMap(Map<String, Map<String, String>> twoLayerMap) {
        this.twoLayerMap = twoLayerMap;
    }
}
