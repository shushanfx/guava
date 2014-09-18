package com.shushanfx.guava.collection;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.shushanfx.test.util.TestItem;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.shushanfx.test.util.TestUtils.*;

/**
 * Created by dengjianxin on 2014/9/18.
 */
public class TestCollections extends TestCase {
    public void testLists(){
        test("testLists", new TestItem() {
            @Override
            public void test() {
                List<String> list = Lists.newArrayList();
                list.add("Item 1");
                list.add("Item 2");
                printTest("Lists.newArrayList()", list);
                List<String> list1 = new ArrayList<String>();
                list1.add("Item 1");
                list1.add("Item 2");

                List<String> list2 = Lists.newArrayListWithCapacity(10);
                List<Integer> list4 = Ints.asList(1,2,3,4);
                printTest("Ints.asList(1,2,3,4)", list4);

            }
        });
    }

    public void testSets(){
        test("testSets", new TestItem() {
            @Override
            public void test() {
                Set<Integer> set1 = Sets.newHashSet(1, 2, 3, 4);
                printTest("Set<Integer> set1 = Sets.newHashSet(1, 2, 3, 4);");

                Set<Integer> set2 = Sets.newHashSet(3, 4, 5);
                printTest("Set<Integer> set2 = Sets.newHashSet(3, 4, 5);");
                Sets.SetView<Integer> set3 = Sets.union(set1, set2);
                printTest("//集合的union，除此之外，还包括intersection，difference，symmetricDifference");
                printTest("Sets.SetView<Integer> set3 = Sets.union(set1, set2);", set3);

                Set<Integer> set4 = Sets.newHashSet();
                set3.copyInto(set4);
                printTest("Set<Integer> set4 = Sets.newHashSet();\n set3.copyInto(set4);", set4);
                printTest("//不可变结合\nset3.immutableCopy();", set3.immutableCopy());
            }
        });
    }
}
