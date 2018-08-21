package netUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import com.alibaba.fastjson.JSONObject;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @program: paste
 * @description: http协议的操作
 * @author: MagnetoWang
 * @create: 2018-08-21 13:53
 **/
public class http {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    String bowlingJson(String player1, String player2) {
        return "{'winCondition':'HIGH_SCORE',"
                + "'name':'Bowling',"
                + "'round':4,"
                + "'lastSaved':1367702411696,"
                + "'dateStarted':1367702378785,"
                + "'players':["
                + "{'name':'" + player1 + "','history':[10,8,6,7,8],'color':-13388315,'total':39},"
                + "{'name':'" + player2 + "','history':[6,10,5,10,10],'color':-48060,'total':41}"
                + "]}";
    }
//    OkHttpClient client = new OkHttpClient();

    String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return JSONObject.parseObject(response.body().string()).toJSONString();
        }
    }

    static String api="http://i.pt-house-api.lianjia.com/ershoufang/list?source=playback&house_codes=101103177921,101102723355";

    public static void main(String[] args) throws IOException {
//        String url="{\"error_code\":0,\"error_msg\":\"success\",\"request_id\":3084281799,\"uniq_id\":\"4E58-4BAD-D57B-E7F4-33665ED817ED\",\"server_ip\":\"10.26.64.100\",\"data\":{\"101103177921\":{\"hdic_house_id\":\"1115043080653\",\"house_info\":{\"app_ctime\":1533718299,\"app_ext_info\":\"\",\"app_mtime\":1534502160,\"app_pkid\":\"101103177921\",\"appid\":\"104\",\"bit_status\":\"268550100\",\"building_finish_year\":\"2010\",\"building_property\":\"0\",\"building_type\":\"102200000003\",\"building_type_cn\":\"\\u677f\\u5854\\u7ed3\\u5408\",\"ctime\":1533718620,\"deal_cycle\":null,\"decoration\":\"3\",\"decoration_cn\":\"\\u7cbe\\u88c5\",\"floor_level\":\"1\",\"floor_level_cn\":\"\\u4f4e\\u697c\\u5c42\",\"floor_num\":\"4\",\"floor_total\":\"28\",\"frame_bathroom_num\":\"1\",\"frame_bedroom_num\":\"2\",\"frame_hall_num\":\"1\",\"frame_kitchen_num\":\"1\",\"frame_orientation\":\"100500000003\",\"frame_orientation_cn\":\"\\u5357\",\"frame_picture_url\":\"x-se\\/hdic-frame\\/test-94c9788d-e350-432e-a100-5e5c887df465.png\",\"frame_structure\":\"101200000001\",\"frame_structure_cn\":\"\\u5e73\\u5c42\",\"hdic_bizcircle_id\":\"611100328\",\"hdic_building_id\":\"1112041899861\",\"hdic_city_id\":\"110000\",\"hdic_district_id\":\"23008613\",\"hdic_floor_id\":\"1114041899884\",\"hdic_frame_id\":\"1120033360261473\",\"hdic_house_id\":\"1115043080653\",\"hdic_process_id\":\"1130008883702502\",\"hdic_resblock_id\":\"1111041899696\",\"hdic_unit_id\":\"1113041899911\",\"heating_type\":\"101300000001\",\"heating_type_cn\":\"\\u96c6\\u4e2d\\u4f9b\\u6696\",\"house_area\":\"69.17\",\"house_code\":\"101103177921\",\"house_id\":\"231139350\",\"house_sell_status\":\"sell\",\"house_title\":\"\\u91d1\\u9685\\u4e3d\\u666f\\u56ed \\u5357\\u5411\\u4e24\\u5c45\\u5ba4 \\u65e0\\u906e\\u6321 \\u91c7\\u5149\\u597d \\u4e0d\\u4e34\\u8857\",\"house_type\":\"107500000003\",\"house_type_cn\":\"\\u666e\\u901a\\u4f4f\\u5b85\",\"is_cms_valid\":1,\"is_display\":1,\"is_sold\":0,\"is_valid\":1,\"list_picture\":{\"list\":{\"type\":\"list\",\"pic_url\":\"\\/110000-inspection\\/test-2b170657-16fe-442c-8542-daea47f4901c.png\"},\"frame\":{\"type\":\"frame\",\"pic_url\":\"x-se\\/hdic-frame\\/test-94c9788d-e350-432e-a100-5e5c887df465.png\",\"isStandard\":true},\"count\":8},\"list_picture_url\":\"\\/110000-inspection\\/test-2b170657-16fe-442c-8542-daea47f4901c.png\",\"mtime\":1534825013,\"payment_mode\":\"307500000009\",\"payment_mode_cn\":\"\\u4e00\\u7c7b\\u7ecf\\u6d4e\\u9002\\u7528\\u623f\",\"price_listing\":3050000,\"price_tax\":\"0\",\"price_trans\":null,\"price_variance\":\"0\",\"register_time\":1307030400,\"register_time_cn\":\"\\u6ee1\\u4e94\\u5e74\",\"sign_contract_code\":\"\",\"sign_source\":\"0\",\"sign_source_cn\":\"\\u94fe\\u5bb6\\u6210\\u4ea4\",\"sign_time\":null,\"sign_unit_price\":null,\"tags\":{\"is_key\":\"\\u968f\\u65f6\\u770b\\u623f\",\"is_focus\":\"\\u4f18\\u9009\",\"is_vr\":\"vr\\u770b\\u623f\",\"is_five\":\"\\u623f\\u672c\\u6ee1\\u4e94\\u5e74\",\"unique\":\"\\u552f\\u4e00\"},\"trade_type\":\"0\",\"unit_price\":44095,\"vr_list_picture_url\":\"\"},\"hdic_house_info\":{\"resblock_id\":1111041899696,\"resblock_name\":\"\\u91d1\\u9685\\u4e3d\\u666f\\u56ed\",\"city_name\":\"\\u5317\\u4eac\\u5e02\",\"district_id\":23008613,\"district_name\":\"\\u671d\\u9633\",\"district_spell\":\"chaoyang\",\"district_point_lat\":39.941870226449,\"district_point_lng\":116.51560779421,\"bizcircle_id\":611100328,\"bizcircle_name\":\"\\u5e38\\u8425\",\"bizcircle_spell\":\"changying\",\"bizcircle_point_lat\":39.935376414979,\"bizcircle_point_lng\":116.58864852112,\"admin_addr\":\"\\u5e38\\u8425\\u4e94\\u91cc\\u6865\\u4e00\\u8857\",\"water_type\":101700000002,\"water_type_cn\":\"\\u6c11\\u6c34\",\"electric_type\":101800000002,\"electric_type_cn\":\"\\u6c11\\u7535\",\"property_age_limit\":307600000003,\"property_age_limit_cn\":\"70\\u5e74\",\"floor\":{\"house_count\":8},\"elevator\":2,\"unit\":{\"elevator\":2},\"building\":{\"point_lat\":39.932148,\"point_lng\":116.618877,\"water_type\":101700000002,\"water_type_cn\":\"\\u6c11\\u6c34\",\"property_age_limit\":307600000003,\"property_age_limit_cn\":\"70\\u5e74\",\"electric_type\":101800000002,\"electric_type_cn\":\"\\u6c11\\u7535\",\"deal_property\":307500000009,\"deal_property_cn\":\"\\u4e00\\u7c7b\\u7ecf\\u6d4e\\u9002\\u7528\\u623f\",\"build_structure\":100700000002,\"build_structure_cn\":\"\\u94a2\\u6df7\\u7ed3\\u6784\",\"villa_type\":0,\"villa_type_cn\":\"\\u6682\\u65e0\\u6570\\u636e\",\"gas_fee\":2.63},\"resblock\":{\"cycle_line\":40630005,\"cycle_line_cn\":\"\\u4e94\\u81f3\\u516d\\u73af\",\"cubage_rate\":1.23,\"point_lat\":39.931048,\"point_lng\":116.619353},\"stat_function_enum\":{\"code\":107500000003,\"name\":\"\\u666e\\u901a\\u4f4f\\u5b85\",\"simple_name\":\"\\u666e\",\"parent_code\":1075}},\"house_subway_info\":[{\"line_name\":\"6\\u53f7\\u7ebf\",\"line_id\":46107350,\"station_name\":\"\\u8349\\u623f\",\"station_id\":46107204,\"distance\":533}],\"house_video_info\":[]}}}\n";
//        String chinese="\\u8349\\u623f";
//        JSONObject jsonObject = JSONObject.parseObject(url);
//        System.out.println(jsonObject);
//        String enStr = URLEncoder.encode(chinese, "GBK");
//        enStr = URLEncoder.encode(enStr, "utf-8");
//        enStr = URLEncoder.encode(enStr, "utf-8");
//        enStr = URLDecoder.decode(enStr, "utf-8");
//        System.out.println(enStr);
        http example = new http();
        String response = example.get(api);
        System.out.println(response);
    }

//    public static void main(String[] args) throws IOException {
//        http example = new http();
//        String json = example.bowlingJson("Jesse", "Jake");
//        String response = example.post("http://www.roundsapp.com/post", json);
//        System.out.println(response);
//    }
}
