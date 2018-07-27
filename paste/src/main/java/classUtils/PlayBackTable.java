package classUtils;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @program: paste
 * @description: 示例类
 * @author: MagnetoWang
 * @create: 2018-07-27 18:53
 **/
public class PlayBackTable {
    //数据库表自行维护
    //日志显示的内容
    //36个字段
    @JSONField(ordinal=1)
    private Long id;//自增长类型
    @JSONField(ordinal=2)
    private String pt;//字符串格式的时间
    @JSONField(ordinal=3)
    private Integer operation_type;//行为说明类型
    @JSONField(ordinal=4)
    private Long  operation_timestamp;
    @JSONField(ordinal=5)
    private Long click_timestamp;
    @JSONField(ordinal=6)
    private String click_fb_expo_id;
    @JSONField(ordinal=7)
    private String click_housecode;//暂时加入字段
    @JSONField(ordinal=8)
    private Integer total;
    @JSONField(ordinal=9)
    private String search_docs;
    @JSONField(ordinal=10)
    private String fb_query_id;
    @JSONField(ordinal=11)
    private String fb_service_id;
    @JSONField(ordinal=12)
    private String search_index;
    @JSONField(ordinal=13)
    private  String qfs;
    @JSONField(ordinal=14)
    private  String requestFunctionScores;
    @JSONField(ordinal=15)
    private String queryOperator;
    @JSONField(ordinal=16)
    private String requestId;
    @JSONField(ordinal=17)
    private String route;//暂时加入字段
    @JSONField(ordinal=18)
    private String search_query;
    @JSONField(ordinal=19)
    private  String strategyId;
    @JSONField(ordinal=20)
    private String fls;
    @JSONField(ordinal=21)
    private String aggregations;
    @JSONField(ordinal=22)
    private Integer returnRelativeScore;//返回的是false=0; true=1
    @JSONField(ordinal=23)
    private Integer size;
    @JSONField(ordinal=24)
    private String cityIds;
    @JSONField(ordinal=25)
    private Integer page;
    @JSONField(ordinal=26)
    private String queryMinimumShouldMatch;
    @JSONField(ordinal=27)
    private Integer queryFuzziness;//字符串还是整数。有待考虑  -1
    @JSONField(ordinal = 28)
    private String sortedQueryMinimumShouldMatch;
    @JSONField(ordinal=29)
    private String sorts;
    @JSONField(ordinal = 30)
    private String filters;
    @JSONField(ordinal=31)
    private String ucid;
    @JSONField(ordinal = 32)
    private String cost;//int 改为 string
    @JSONField(ordinal = 33)
    private String fb_ab_test_flag;
    @JSONField(ordinal=34)
    private String uuid;
    @JSONField(ordinal=35)
    private Long dig_timestamp;
    @JSONField(ordinal = 36)
    private String client;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPt() {
        return pt;
    }

    public void setPt(String pt) {
        this.pt = pt;
    }

    public Integer getOperation_type() {
        return operation_type;
    }

    public void setOperation_type(Integer operation_type) {
        this.operation_type = operation_type;
    }

    public Long getOperation_timestamp() {
        return operation_timestamp;
    }

    public void setOperation_timestamp(Long operation_timestamp) {
        this.operation_timestamp = operation_timestamp;
    }
    public Long getClick_timestamp() {
        return click_timestamp;
    }

    public void setClick_timestamp(Long click_timestamp) {
        this.click_timestamp = click_timestamp;
    }

    public String getClick_fb_expo_id() {
        return click_fb_expo_id;
    }

    public void setClick_fb_expo_id(String click_fb_expo_id) {
        this.click_fb_expo_id = click_fb_expo_id;
    }

    public String getClick_housecode() {
        return click_housecode;
    }

    public void setClick_housecode(String click_housecode) {
        this.click_housecode = click_housecode;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getSearch_docs() {
        return search_docs;
    }

    public void setSearch_docs(String search_docs) {
        this.search_docs = search_docs;
    }

    public String getFb_query_id() {
        return fb_query_id;
    }

    public void setFb_query_id(String fb_query_id) {
        this.fb_query_id = fb_query_id;
    }

    public String getFb_service_id() {
        return fb_service_id;
    }

    public void setFb_service_id(String fb_service_id) {
        this.fb_service_id = fb_service_id;
    }

    public String getSearch_index() {
        return search_index;
    }

    public void setSearch_index(String search_index) {
        this.search_index = search_index;
    }

    public String getQfs() {
        return qfs;
    }

    public void setQfs(String qfs) {
        this.qfs = qfs;
    }

    public String getRequestFunctionScores() {
        return requestFunctionScores;
    }

    public void setRequestFunctionScores(String requestFunctionScores) {
        this.requestFunctionScores = requestFunctionScores;
    }

    public String getQueryOperator() {
        return queryOperator;
    }

    public void setQueryOperator(String queryOperator) {
        this.queryOperator = queryOperator;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getSearch_query() {
        return search_query;
    }

    public void setSearch_query(String search_query) {
        this.search_query = search_query;
    }

    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    public String getFls() {
        return fls;
    }

    public void setFls(String fls) {
        this.fls = fls;
    }

    public String getAggregations() {
        return aggregations;
    }

    public void setAggregations(String aggregations) {
        this.aggregations = aggregations;
    }

    public int getReturnRelativeScore() {
        return returnRelativeScore;
    }

    public void setReturnRelativeScore(int returnRelativeScore) {
        this.returnRelativeScore = returnRelativeScore;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getCityIds() {
        return cityIds;
    }

    public void setCityIds(String cityIds) {
        this.cityIds = cityIds;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getQueryMinimumShouldMatch() {
        return queryMinimumShouldMatch;
    }

    public void setQueryMinimumShouldMatch(String queryMinimumShouldMatch) {
        this.queryMinimumShouldMatch = queryMinimumShouldMatch;
    }

    public int getQueryFuzziness() {
        return queryFuzziness;
    }

    public void setQueryFuzziness(int queryFuzziness) {
        this.queryFuzziness = queryFuzziness;
    }

    public String getSortedQueryMinimumShouldMatch() {
        return sortedQueryMinimumShouldMatch;
    }

    public void setSortedQueryMinimumShouldMatch(String sortedQueryMinimumShouldMatch) {
        this.sortedQueryMinimumShouldMatch = sortedQueryMinimumShouldMatch;
    }

    public String getSorts() {
        return sorts;
    }

    public void setSorts(String sorts) {
        this.sorts = sorts;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public String getUcid() {
        return ucid;
    }

    public void setUcid(String ucid) {
        this.ucid = ucid;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getFb_ab_test_flag() {
        return fb_ab_test_flag;
    }

    public void setFb_ab_test_flag(String fb_ab_test_flag) {
        this.fb_ab_test_flag = fb_ab_test_flag;
    }

    public Long getDig_timestamp() {
        return dig_timestamp;
    }

    public void setDig_timestamp(Long dig_timestamp) {
        this.dig_timestamp = dig_timestamp;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
