package com.shushanfx.test.util;

/**
 * Created by dengjianxin on 2014/9/18.
 */
public final class TestUtils {
    public static void test(String name, TestItem item){
        System.out.println("#=============" + name + " start =================");
        if(item!=null){
            item.test();
        }
        System.out.println("#=============" + name + " end =================\n");
    }

    public static void printTest(String statement, Object obj){
        System.out.print(statement);
        System.out.print(" -> ");
        System.out.println(obj);
    }
    public static void printTest(String statement){
        System.out.println(statement);
    }
}
