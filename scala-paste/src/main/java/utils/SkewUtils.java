package utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wangzixian
 * @Description TODO
 * @Date 2020/12/2 19:15
 **/
public class SkewUtils {

    public static String genPercentileSql(String table1, int quantile, List<String> keys, String ts) {


    }

    public static String genPercentileTagSql(String table1, String table2, int quantile, Map<String, String> keysMap, String ts) {
        StringBuffer sql = new StringBuffer();
        sql.append("select ");
        for (String e : keysMap.keySet()) {
            sql.append(table1 + "." + e + ",");
        }
        sql.append(table1 + "." + ts + ",\n");
        sql.append("case\n");

        for (int i = 0; i < quantile; i++) {
            if (i == 0) {
                sql.append(String.format("when %s.%s <= percentile_%s then %d\n", table1, ts, i, i+1));
            }

            sql.append(String.format("when %s.%s > percentile_%s and %s.%s <= percentile_%d then %d\n", table1, ts, i, table1, ts, i+1, i+1));
            if (i == quantile) {
                sql.append(String.format("when %s.%s > percentile_%s then %d\n", table1, ts, i+1, i+1));
            }
        }
        sql.append("end as tag\n");
        sql.append(String.format("from %s left join %s on ", table1, table2));
        List<String> conditions = new ArrayList<>();
        for (Map.Entry<String, String> e : keysMap.entrySet()) {
            String cond = String.format("%s.%s = %s.%s", table1, e.getKey(), table2, e.getValue());
            conditions.add(cond);
        }
        sql.append(StringUtils.join(conditions, " and "));
        sql.append(";");
        return sql.toString();
    }

    public static void main(String[] args) {
        String table1 = "mainTable";
        String table2 = "info_table";
        String ts = "bonus";
        Map<String, String> keys = new HashMap<>();
        keys.put("employee_name", "employee_name");
        keys.put("department", "department");
//        System.out.println(genPercentileSql(table1, table2, 4, keys, ts));
    }
}
