package com.kroly.centre.fastJson;

/**
 * @ClassName Person
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-06-04 20:14
 **/
public class Person {
    public static void main(String[] args) {
       String str = "[{\"name\":\"张三\",\"age\":\"1\"},{\"name\":\"李四\",\"age\":\"4\"}]";
        System.out.println("[".equals(str.substring(0,1)));

    }
}
