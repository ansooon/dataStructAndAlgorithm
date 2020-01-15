package java8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhongshanhuang
 * @company caih
 * @email zhongshanhuang@caih.com
 * @create 2020-01-15 11:35
 */


public class StreamDemo {
    //Stream通用语法:创建Stream + 转换Stream + 聚合， 例如： nums.stream().filter(num -> num != null).count();

    //1，转换
    //1-1, distinct
    //1-2, filter
    //1-3, map
    //1-4, flatMap
    //1-5, peek
    //1-6, limit
    //1-7, skip
    //2, 聚合
    //2-1, collect
    //2-2, sum
    //2-3, count
    //2-4, max/min

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, null, 3, 4, null, 6));
        Stream.distinct(nums);
        Stream.filter(nums);
        Stream.map(nums);
        Stream.collect2Map(nums);
        Stream.collect2Set(nums);
    }
}

class Stream {

    //1, distinct
    public static void distinct(List<Integer> nums) {
        List<Integer> collect = nums.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);
    }

    //2, filter
    public static void filter(List<Integer> nums) {
        List<Integer> collect = nums.stream().filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println(collect);

    }

    //3, map
    public static void map(List<Integer> nums) {
        Set<String> collect = nums.stream().map(String::valueOf).collect(Collectors.toSet());
        System.out.println(collect);  //[1, 3, null, 4, 6]
    }

    //4-1. collect.toMap ,注意，如果不去重，则当新增的key-value相同时会报错
    public static void collect2Map(List<Integer> nums){
        Map<String, Double> collect = nums.stream().map(String::valueOf).distinct().collect(Collectors.toMap(s -> s, s -> Math.random()));
        System.out.println(collect);
    }

    //4-2. collect.toSet
    public static void collect2Set(List<Integer> nums){
        Set<String> collect = nums.stream().map(String::valueOf).collect(Collectors.toSet());
        System.out.println(collect);

    }

    //4-3. collect.toList
    public static void collect2List(List<Integer> nums){
        List<String> collect = nums.stream().map(String::valueOf).collect(Collectors.toList());
        System.out.println(collect);

    }
}