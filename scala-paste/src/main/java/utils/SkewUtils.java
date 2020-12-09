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
//    select
//            employee_name,
//    percentile_approx(bonus, 0) as percentile_0,
//    percentile_approx(bonus, 0) as percentile_1,
//    percentile_approx(bonus, 0) as percentile_2,
//    percentile_approx(bonus, 0) as percentile_3,
//    percentile_approx(bonus, 0) as percentile_4,
//    max(bonus) as max_bonus,
//    min(bonus) as min_bonus,
//    mean(bonus) as mean_bonus,
//    sum(bonus)as sum_bonus
//    from
//            main_table
//    group by main_table.employee_name, main_table.department;

    public static String genPercentileSql(String table1, int quantile, List<String> keys, String ts) {
        StringBuffer sql = new StringBuffer();
        sql.append("select \n");
        for (String e : keys) {
            sql.append(e + ",\n");
        }
        sql.append(String.format("min(%s) as min_%s,\n", ts, ts));
        sql.append(String.format("max(%s) as max_%s,\n", ts, ts));
        sql.append(String.format("mean(%s) as mean_%s,\n", ts, ts));
        sql.append(String.format("sum(%s) as sum_%s,\n", ts, ts));
        double factor = 1.0 / new Double(quantile);
        for (int i = 0; i < quantile; i++) {
            double v = i * factor;
            sql.append(String.format("percentile_approx(%s, %s) as percentile_%s,\n", ts, v, i));
        }
        sql.append(String.format("percentile_approx(%s, 1) as percentile_%s\n", ts, quantile));
        sql.append(String.format("from \n%s\ngroup by ", table1));
        sql.append(StringUtils.join(keys, " , "));
        sql.append(";");
        System.out.println(sql);
        return sql.toString();

    }

    public static String genPercentileTagSql(String table1, String table2, int quantile, List<String> schemas, Map<String, String> keysMap, String ts) {
        StringBuffer sql = new StringBuffer();
        sql.append("select \n");
        for (String e : schemas) {
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
        sql.append("end as tag_wzx\n");
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
        String table1 = "main_table";
        String table2 = "info_table";
        List<String> schemas = new ArrayList<String>(){
            {
                add("employee_name");
                add("department");
                add("state");
                add("salary");
                add("age");
                add("bonus");
            }
        };
        String ts = "bonus";
        Map<String, String> keys = new HashMap<>();
        keys.put("employee_name", "employee_name");
        keys.put("department", "department");
//        genPercentileSql(table1, 4, new ArrayList<String>(){
//            {
//                add("employee_name");
//                add("department");
//            }
//        }, ts);
        System.out.println(genPercentileTagSql(table1, table2, 4, schemas, keys, ts));
    }
}
