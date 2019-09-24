package utils;

import java.util.*;

/**
 * @Author wangzixian
 * @Description 查看各种数据结构的顺序
 * @Date 2019/9/24 14:01
 **/
public class DataOrder {
    public static void main(String[] args) {
        class DataPair<K, V> {
            private K key;
            private V value;
            DataPair() {

            }
            DataPair(K k, V v) {
                key = k;
                value = v;
            }
            public K getKey() {
                return key;
            }
            public V getValue() {
                return value;
            }
        }


        Map<Long, Integer> map = new TreeMap<>();
        map.put(new Long(10), 11);
        map.put(new Long(11), 11);
        map.put(new Long(9), 11);
        map.put(new Long(12), 11);
        map.put(new Long(8), 11);
        map.put(new Long(13), 11);
//        ((TreeMap<Long, Integer>) map).descendingKeySet()

//        for (Long e : ((TreeMap<Long, Integer>) map).descendingKeySet()) {
//            System.out.println(e);
//        }

        // 队列默认顺序
        Queue<Long> queue = new PriorityQueue<>();
        queue.add(10L);
        queue.add(11L);
        queue.add(9L);
        queue.add(12L);
        queue.add(4L);
        System.out.println("优先队列的默认顺序");
        while (!queue.isEmpty()) {
            Long i = queue.poll();
            System.out.println(i);
        }

        //更改优先队列默认顺序
        Comparator<Long> comparator = new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return (int)(o2 - o1);
            }
        };
        Queue<Long> queue1 = new PriorityQueue<>(comparator);
        queue1.add(10L);
        queue1.add(11L);
        queue1.add(9L);
        queue1.add(12L);
        queue1.add(4L);
        System.out.println("更改优先队列的顺序");
        while (!queue1.isEmpty()) {
            Long i = queue1.poll();
            System.out.println(i);
        }

        // 优先队列加入泛型的类
        System.out.println("优先队列加入泛型的类");
        Comparator<DataPair<Long, Integer>> comparator1 = new Comparator<DataPair<Long, Integer>>() {
            @Override
            public int compare(DataPair<Long, Integer> o1, DataPair<Long, Integer> o2) {
                return (int)(o2.getKey() - o1.getKey());
            }
        };
        Queue<DataPair<Long, Integer>> queue2 = new PriorityQueue<>(comparator1);
//        DataPair<Long, Integer> pair1 = new DataPair<>(20L, 3);
        queue2.add(new DataPair<>(10L, 3));
        queue2.add(new DataPair<>(9L, 3));
        queue2.add(new DataPair<>(11L, 3));
        queue2.add(new DataPair<>(8L, 3));
        queue2.add(new DataPair<>(12L, 3));


        System.out.println(queue2.poll().getKey());

        queue2.add(new DataPair<>(17L, 3));
        queue2.add(new DataPair<>(16L, 3));



        while (!queue2.isEmpty()) {
            DataPair i = queue2.poll();
            System.out.println(i.getKey());
//            System.out.println(i.value());
        }




    }
}
