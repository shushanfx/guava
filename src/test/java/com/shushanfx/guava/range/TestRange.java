package com.shushanfx.guava.range;

import com.google.common.collect.Range;
import junit.framework.TestCase;
import static com.shushanfx.test.util.TestUtils.*;

/**
 * Created by dengjianxin on 2014/9/18.
 */
public class TestRange extends TestCase {
    public void testRange(){
        Range.closed("left", "right"); //�ֵ�����"left"��"right"֮����ַ�����������
        Range.lessThan(4.0); //�ϸ�С��4.0��doubleֵ

    }
}
