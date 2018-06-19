package execFiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/** 
*
* @ClassName : readCityName.java
* @author : Magneto_Wang
* @date  2018��6��15�� ����2:36:37
* @Description  ִ�в�ѯ�ļ�
*
*/
public class readCityName {
	public static void main(String[] args) {
		String filename="src/main/java/fileUtils/query.txt";
//		src/main/java/fileUtils/
		List<String> cityName = new LinkedList<String>();
		cityName=readFileByLines(filename,cityName);
	       Map<String,String> daBean=new HashMap<>();
	        daBean.put("cityId","320300");
	        daBean.put("channelId","ershoufang");
	        
	        daBean.put("spellcheck","false");
	        List<Map<String, String>> cityResult=new LinkedList<>();
		for(String e:cityName){
			
			System.out.println(e);
			daBean.put("query",e);
			Map<String, String> cityType;
			
			cityType=getMap(daBean);
			cityType.put("value", e);
			cityResult.add(cityType);		
			}
		for(Map<String,String> e:cityResult){
			System.out.println(e.get("value")+" "+e.get("type")+" "+e.get("name"));
		}
		writeFileByLines("src/main/java/execFiles/result.txt",cityResult);
		
	}
//	public static Map<String, String> getJSON(Map<String,String> daBean){
//
//        postURL getResponse=new postURL();
//        String url="http://api.search.lianjia.com/1040001?id=2&version=1";
//        String daBean2string= JSON.toJSONString(daBean);
//        String result = getResponse.postQuery(url,daBean2string);
//        System.out.println("result");
//        JSONObject json = JSONObject.parseObject(result);
//        System.out.println(json);
//        System.out.println(json.getJSONArray("results"));
//        System.out.println(json.getJSONArray("results").get(0));
//        Object features =json.getJSONArray("results").get(0);
//
//        System.out.println(((JSONObject)json.getJSONArray("results").get(0)).getJSONArray("features").get(0));
//
//        features = ((JSONObject)json.getJSONArray("results").get(0)).getJSONArray("features").get(0);
//        System.out.println(((JSONObject)features).get("type"));
//        System.out.println(((JSONObject)features).get("name"));
//        
//        return (JSONObject)features;
//    }
	public static Map<String, String> getMap(Map<String,String> daBean){

		Map<String, String> cityType=new HashMap<>();
		cityType.put("type", "KEYWORD");
		cityType.put("name", "KEYWORD");
//      System.out.println(((JSONObject)features).get("type"));
//        System.out.println(((JSONObject)features).get("name"));
        
        return cityType;
    }
	public static List<String> readFileByLines(String fileName,List<String> cityName) {  
        File file = new File(fileName);  
        
        BufferedReader reader = null;  
        try {  
//            System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");  
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"gbk") );  
            String tempString = null;  
            int line = 1;  
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����  
            while ((tempString = reader.readLine()) != null) {  
                // ��ʾ�к�  
//                System.out.println("line " + line + ": " + tempString);  
                cityName.add(tempString);
                line++;  
            }  
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
        return cityName;
    }  
//	http://www.cnblogs.com/kongxianghao/articles/6879446.html
	public static void writeFileByLines(String fileName,List<Map<String, String>> cityResult) {  
        File file = new File(fileName);  
        
        BufferedWriter writer = null;  
        try {  
//            System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");  
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"utf-8"));
            for(Map<String, String> e :cityResult){
            	String tempString = e.get("value")+" "+e.get("type")+" "+e.get("name");
            	
            	writer.write(tempString);
            	writer.write("\n");
            }      
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
        	try {
				writer.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
        }  
        
    }  


}
