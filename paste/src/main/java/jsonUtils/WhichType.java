package jsonUtils;

import com.alibaba.fastjson.JSONObject;

import java.sql.Date;

/**
 * @program: paste
 * @description: 判断json对象值是什么类型
 * @author: MagnetoWang
 * @create: 2018-07-28 20:20
 **/
public class WhichType {
    public static void main(String[] args) {
        String json ="{\"dig_timestamp\":1532662375943,\"click_housecode\":\"null\",\"fb_query_id\":\"75188676697059328\",\"pt\":\"2018-07-27\",\"operation_type\":-1,\"requestFunctionScores\":\"null\",\"queryFuzziness\":-1,\"search_query\":\"null\",\"fb_ab_test_flag\":\"null\",\"uuid\":\"a6eae1e38ed0c2da43d4771c0f2edc25\",\"fb_service_id\":\"1011710019\",\"returnRelativeScore\":0,\"total\":15,\"requestId\":\"null\",\"client\":\"app\",\"strategyId\":\"0\",\"id\":1532662395,\"operation_timestamp\":1532662395000,\"cityIds\":\"[\\\"320100\\\"]\",\"sorts\":\"[]\",\"queryOperator\":\"OR\",\"ucid\":\"0\",\"click_timestamp\":1532662395000,\"cost\":\"16\",\"click_fb_expo_id\":\"75188676705439745\",\"search_docs\":\"[{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"0\\\",\\\"fb_expo_id\\\":\\\"75188676705439744\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"1\\\",\\\"fb_expo_id\\\":\\\"75188676705439745\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"2\\\",\\\"fb_expo_id\\\":\\\"75188676705439746\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"3\\\",\\\"fb_expo_id\\\":\\\"75188676705439747\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"4\\\",\\\"fb_expo_id\\\":\\\"75188676705439748\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"5\\\",\\\"fb_expo_id\\\":\\\"75188676705439749\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"6\\\",\\\"fb_expo_id\\\":\\\"75188676705439750\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"7\\\",\\\"fb_expo_id\\\":\\\"75188676705439751\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"8\\\",\\\"fb_expo_id\\\":\\\"75188676705439752\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"9\\\",\\\"fb_expo_id\\\":\\\"75188676705439753\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"10\\\",\\\"fb_expo_id\\\":\\\"75188676705439754\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"11\\\",\\\"fb_expo_id\\\":\\\"75188676705439755\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"12\\\",\\\"fb_expo_id\\\":\\\"75188676705439756\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"13\\\",\\\"fb_expo_id\\\":\\\"75188676705439757\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"14\\\",\\\"fb_expo_id\\\":\\\"75188676705439758\\\"}}]\",\"queryMinimumShouldMatch\":\"-25%\",\"filters\":\"{\\\"and\\\":[{\\\"or\\\":[{\\\"field\\\":\\\"subwayLineId\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"99666695\\\"}]},{\\\"or\\\":[{\\\"field\\\":\\\"appid\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"104\\\"},{\\\"field\\\":\\\"appid\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"500\\\"},{\\\"field\\\":\\\"appid\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"105\\\"}]},{\\\"or\\\":[{\\\"field\\\":\\\"cityId\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"320100\\\"}]},{\\\"or\\\":[{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107500000001\\\"},{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107500000002\\\"},{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107500000003\\\"},{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107500000004\\\"},{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107500000005\\\"},{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107500000009\\\"},{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107500000010\\\"},{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107500000012\\\"},{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107500000013\\\"},{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107500000014\\\"},{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107500000015\\\"},{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107500000017\\\"},{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107599999998\\\"}]},{\\\"or\\\":[{\\\"field\\\":\\\"priceTotal\\\",\\\"action\\\":\\\"range\\\",\\\"value\\\":\\\"[0,80)\\\"}]}]}\",\"fls\":\"[\\\"houseCode\\\"]\",\"search_index\":\"1011710019\",\"route\":\"null\",\"size\":20,\"page\":0,\"sortedQueryMinimumShouldMatch\":\"1\",\"aggregations\":\"[]\",\"qfs\":\"[\\\"title\\\",\\\"houseCode\\\",\\\"resblockName\\\"]\"}";
                JSONObject jsonObject = JSONObject.parseObject(json);
                int i=0;
        for(String e:jsonObject.keySet()){
            i++;
            String[]  string=jsonObject.get(e).getClass().getName().split("\\.");
//            System.out.println(string[2]);
            System.out.println("ps.set"+string[2]+"("+i+",jsonObject.get"+string[2]+"(\""+e+"\"));");
        }


    }
}
