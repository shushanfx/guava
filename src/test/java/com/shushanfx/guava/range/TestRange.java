package com.shushanfx.guava.range;

import com.google.common.collect.Range;
import junit.framework.TestCase;
import static com.shushanfx.test.util.TestUtils.*;

/**
 * Created by dengjianxin on 2014/9/18.
 */
public class TestRange extends TestCase {
    public void testRange(){
        Range.closed("left", "right"); //字典序在"left"和"right"之间的字符串，闭区间
        Range.lessThan(4.0); //严格小于4.0的double值

    }
}
