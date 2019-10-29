package classUtils;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author wangzixian
 * @Description 用反射和模板动态创建对象
 * @Date 2019/10/21 15:58
 **/
public class base {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        reflection stringRef = new reflection();
//        Integer i = stringRef.createObject(Integer.TYPE);
//        System.out.println(i);

        // hashmap 类型不支持type方式创建，但是可以用class方式
        Map<String, String> map = stringRef.createObject(HashMap.class);
        Map<String, String> map1 = reflection.createObject(HashMap.class);
//        map.put(1,2);
        System.out.println(map);

        // 自定义的Map测试模板
        MapReflection testMap = new MapReflection(10, "12");
        testMap.map.put(121, "fff");
        System.out.println(testMap.toString());
        MapReflection testMap1 = new MapReflection("fff", 12d);
        testMap1.map.put(121, "fff");
        testMap1.map.put(121.05f, "float");
        testMap1.map.put("zifuchuan", 222);
        System.out.println(testMap1.toString());
        System.out.println(testMap1.map.getClass());
        System.out.println(testMap1.map.get(121));
        System.out.println(testMap1.map.get(121.05f));

        // string 确定好就不能用float其他类型
        Map<String, Object> map2 = new HashMap<>();
//        map2.put(12f, "hhhh");
        Map map3 = new HashMap();
        map3.put(12f, "hhhh");
        Iterator<Map.Entry<Object, Object>> entrys = map3.entrySet().iterator();
        while (entrys.hasNext()) {
            Map.Entry<Object, Object> en = entrys.next();
            map2.put(String.valueOf(en.getKey()), en.getValue());
        }
        System.out.println(map2);
    }
}

class reflection {
    private <M> M createModel() {

        try {
            Type superClass = getClass().getGenericSuperclass();
            Type type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
            Class<?> clazz = getRawType(type);
            return (M) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // type不能直接实例化对象，通过type获取class的类型，然后实例化对象
    public static Class<?> getRawType(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            Type componentType = ((GenericArrayType) type).getGenericComponentType();
            return Array.newInstance(getRawType(componentType), 0).getClass();
        } else if (type instanceof TypeVariable) {
            return Object.class;
        } else if (type instanceof WildcardType) {
            return getRawType(((WildcardType) type).getUpperBounds()[0]);
        } else {
            String className = type == null ? "null" : type.getClass().getName();
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + className);
        }
    }

    public static <M> M createObject(Class<M> clazz) throws IllegalAccessException, InstantiationException {
        return (M)clazz.newInstance();
    }


    public <M> M createObject(Type type) throws IllegalAccessException, InstantiationException {
        Class<?> clazz = (Class)type;

        return (M)(clazz).newInstance();
    }
}

/**
 * 动态创建kv的类型
 * @param <K>
 * @param <V>
 */
class MapReflection<K, V> {
    public Map<K, V> map;
    public MapReflection(K key, V value) {
        map = new HashMap<>();
        map.put(key, value);
    }

    @Override
    public String toString() {
        return map.toString();
    }
}