package com.shushanfx.guava.primitive;

import com.google.common.primitives.Ints;
import com.shushanfx.test.util.TestItem;
import junit.framework.TestCase;

import java.util.List;

import static com.shushanfx.test.util.TestUtils.*;

/**
 * Created by dengjianxin on 2014/9/18.
 */
public class TestPrimitive extends TestCase {
    public void testInts(){
        test("testInts", new TestItem() {
            @Override
            public void test() {
                List<Integer> list = Ints.asList(1, 2, 3, 4, 5);
                printTest("List<Integer> list = Ints.asList(1, 2, 3, 4, 5);", list);
                int[] b = Ints.concat(new int[]{1, 2}, new int[]{3, 4});
                printTest("int[] b = Ints.concat(new int[]{1, 2}, new int[]{3, 4});", b);
                printTest("Ints.contains(b, 2);", Ints.contains(b, 2));
                printTest("Ints.contains(b, 5);", Ints.contains(b, 5));

                printTest("Ints.indexOf(b, 1);", Ints.indexOf(b, 1));
                printTest("Ints.join(\"-\", b);", Ints.join("-", b));

            }
        });
    }
}
