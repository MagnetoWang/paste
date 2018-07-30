package stringUtils;
import com.alibaba.fastjson.JSONObject;

/**
 * @program: playback
 * @description: markdown关于表格的一系列操作。出于markdown表格分析，我觉得大小应该可以提前确定下来，
 * 并且修改表大小，没有修改表内容频繁。所以采取数组形式
 * 按照markdown格式习惯编写。没有第0行的说法
 * @author: MagnetoWang
 * @create: 2018-07-30 12:21
 **/
public class MarkdownTable {
    //    private List<List<String>> table=new LinkedList<>();
    private StringBuilder[][] table;
    private int row;
    private int column;
    private String line="| - | - | - | - | - |";
    public MarkdownTable(){

    }
    /**
     * 默认第一行作为标题
     * @param row
     * @param column
     */
    public MarkdownTable(int row,int column){
        this.row=row;
        this.column=column;
        table=new StringBuilder[row][column];
    }

    /**
     * row和column边界检查
     * @param row
     * @param column
     * @return
     */
    private boolean checkRowAndColumn(int row,int column){
        if(row>=1&&row<=this.row&&column>=1&&column<=this.column){
            return true;
        }
        return false;
    }
    public  StringBuilder[][] createTable(int row,int column){
        if(!checkRowAndColumn(row,column)){
            System.out.println("row or column is illegal!!!!");
            return null;
        }
        this.row=row;
        this.column=column;
        this.table=new StringBuilder[row][column];
        return this.table;
    }
    public void writeForm(String context,int row,int column){
        if(!checkRowAndColumn(row,column)){
            System.out.println("row or column is illegal!!!!");
            return;
        }
    }

    public void writeRow(String[] context,int row){
        if(!checkRowAndColumn(row,column)){
            System.out.println("row or column is illegal!!!!");
            return;
        }
        row--;
        StringBuilder[][] stringBuilder=this.table;
        int i=0;
        for(String e:context){

            if(stringBuilder[row][i]!=null&&stringBuilder.length>0){
                stringBuilder[row][i].delete(0,stringBuilder[row][i].length());

            }
            stringBuilder[row][i]=new StringBuilder(e);
            i++;

        }
    }

    public void writecolumn(String[] context,int column){
        if(!checkRowAndColumn(row,column)){
            System.out.println("row or column is illegal!!!!");
            return;
        }
        StringBuilder[][] stringBuilder=this.table;
        int i=0;
        for(String e:context){
            i++;
            stringBuilder[i][column].delete(0,stringBuilder[i][column].length());
            stringBuilder[i][column].append(e);
        }
    }

    public void printTable(){
        for(int i=0;i<table.length;i++){
            System.out.printf("|");
            for(int j=0;j<table[i].length;j++){
                System.out.printf(table[i][j]+"|");
            }
            System.out.println();

            if(i==0){
                System.out.println(line);
            }
        }

    }

    /**
     * 这是一个样例，目前做的还不够抽象
     * @param jsonObject
     */
    public  void printJsonToMarkdown(JSONObject jsonObject){
        int i=0;
        int column=7;
        int row=jsonObject.size()+1;
        String[] strings=new String[column];

        String[] PLAYBACK_DOC={"序号","字段","描述","类型","大小","备注","来源"};
        MarkdownTable table=new MarkdownTable(row,PLAYBACK_DOC.length);
        table.writeRow(PLAYBACK_DOC,1);
        for (String e : jsonObject.keySet()) {
            i++;
            strings[0]=String.valueOf(i);
            strings[1]=e;
            strings[2]="";
            strings[3]=jsonObject.get(e).getClass().getName().split("\\.")[2];
            strings[4]="";//getSizeOf(jsonObject.get(e).getClass().getName().split("\\.")[2]).toString();
            strings[5]="";
            strings[6]="";
            table.writeRow(strings,i+1);
        }
        table.printTable();

    }
    public static void main(String[] args) {
        String string="{\"id\":1532839566,\"pt\":\"2018-07-29\",\"operation_type\":-1,\"operation_timestamp\":1532839566000,\"click_timestamp\":1532839566000,\"click_fb_expo_id\":\"null\",\"click_housecode\":\"null\",\"total\":20857,\"search_docs\":\"[{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"0\\\",\\\"fb_expo_id\\\":\\\"75931859307511808\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"1\\\",\\\"fb_expo_id\\\":\\\"75931859307511809\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"2\\\",\\\"fb_expo_id\\\":\\\"75931859307511810\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"3\\\",\\\"fb_expo_id\\\":\\\"75931859307511811\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"4\\\",\\\"fb_expo_id\\\":\\\"75931859307511812\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"5\\\",\\\"fb_expo_id\\\":\\\"75931859307511813\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"6\\\",\\\"fb_expo_id\\\":\\\"75931859307511814\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"7\\\",\\\"fb_expo_id\\\":\\\"75931859307511815\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"8\\\",\\\"fb_expo_id\\\":\\\"75931859307511816\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"9\\\",\\\"fb_expo_id\\\":\\\"75931859307511817\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"10\\\",\\\"fb_expo_id\\\":\\\"75931859307511818\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"11\\\",\\\"fb_expo_id\\\":\\\"75931859307511819\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"12\\\",\\\"fb_expo_id\\\":\\\"75931859307511820\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"13\\\",\\\"fb_expo_id\\\":\\\"75931859307511821\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"14\\\",\\\"fb_expo_id\\\":\\\"75931859307511822\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"15\\\",\\\"fb_expo_id\\\":\\\"75931859307511823\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"16\\\",\\\"fb_expo_id\\\":\\\"75931859307511824\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"17\\\",\\\"fb_expo_id\\\":\\\"75931859307511825\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"18\\\",\\\"fb_expo_id\\\":\\\"75931859307511826\\\"}},{\\\"strategy_info\\\":{\\\"fb_item_location\\\":\\\"19\\\",\\\"fb_expo_id\\\":\\\"75931859307511827\\\"}}]\",\"fb_query_id\":\"75931859299131392\",\"fb_service_id\":\"1011710017\",\"search_index\":\"1011710017\",\"qfs\":\"[\\\"title\\\",\\\"houseCode\\\",\\\"resblockName\\\"]\",\"requestFunctionScores\":\"[{\\\"filter\\\":{\\\"and\\\":[{\\\"or\\\":[{\\\"field\\\":\\\"tags\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"is_vr\\\"}]}]},\\\"weight\\\":1000.0}]\",\"queryOperator\":\"OR\",\"requestId\":\"null\",\"route\":\"null\",\"search_query\":\"null\",\"strategyId\":\"0\",\"fls\":\"[\\\"houseCode\\\"]\",\"aggregations\":\"[]\",\"returnRelativeScore\":0,\"size\":20,\"cityIds\":\"[\\\"440100\\\"]\",\"page\":0,\"queryMinimumShouldMatch\":\"-25%\",\"queryFuzziness\":-1,\"sortedQueryMinimumShouldMatch\":\"1\",\"sorts\":\"[{\\\"field\\\":\\\"_score\\\",\\\"order\\\":\\\"desc\\\"},{\\\"field\\\":\\\"houseQ\\\",\\\"order\\\":\\\"desc\\\"},{\\\"field\\\":\\\"_uid\\\",\\\"order\\\":\\\"asc\\\"}]\",\"filters\":\"{\\\"and\\\":[{\\\"or\\\":[{\\\"field\\\":\\\"appid\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"104\\\"}]},{\\\"or\\\":[{\\\"field\\\":\\\"cityId\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"440100\\\"}]},{\\\"or\\\":[{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107500000001\\\"},{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107500000002\\\"},{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107500000003\\\"},{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107500000004\\\"},{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107500000005\\\"},{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107500000009\\\"},{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107500000010\\\"},{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107500000012\\\"},{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107500000013\\\"},{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107500000014\\\"},{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107500000015\\\"},{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107500000017\\\"},{\\\"field\\\":\\\"houseType\\\",\\\"action\\\":\\\"match\\\",\\\"value\\\":\\\"107599999998\\\"}]}]}\",\"ucid\":\"0\",\"cost\":\"2\",\"fb_ab_test_flag\":\"null\",\"uuid\":\"97a1f18b2108969c6d9c0efb109eac51\",\"dig_timestamp\":1532839566000,\"client\":\"app\",\"summary\":\"有过滤,排序行为\"}\n";
        String string2="{\"operation_timestamp\":1532838025620,\"operation_type\":7,\"operation_value\":\"[{\\\"field\\\":\\\"_score\\\",\\\"order\\\":\\\"desc\\\"},{\\\"field\\\":\\\"houseQ\\\",\\\"order\\\":\\\"desc\\\"},{\\\"field\\\":\\\"_uid\\\",\\\"order\\\":\\\"asc\\\"}]\",\"pt\":\"2018-07-29\",\"fb_query_id\":\"75925395213963264\"}\n";
        String string3="{\"operation_timestamp\":1532839113530,\"operation_type\":7,\"operation_value\":\"null\",\"pt\":\"2018-07-29\",\"fb_query_id\":\"75929963279740928\"}\n";

        MarkdownTable markdownTable=new MarkdownTable();
        markdownTable.printJsonToMarkdown(JSONObject.parseObject(string3));
    }

}
