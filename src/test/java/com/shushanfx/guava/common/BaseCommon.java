package com.shushanfx.guava.common;

import static org.junit.Assert.assertEquals;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.shushanfx.guava.base.ComparisonBean;
import com.shushanfx.test.util.TestItem;
import static com.shushanfx.test.util.TestUtils.*;
import org.junit.Test;

/**
 * Created by dengjianxin on 2014/9/18.
 */
public class BaseCommon {
    @Test
    public void optionalTest(){
        Optional<Integer> optional = Optional.of(5);

        assertEquals("Is is equal!", optional.isPresent(), true);
        Optional<Integer> optional1 = Optional.absent();

        assertEquals("Is is equal!", optional1.isPresent(), false);

    }

    @Test
    public void optionOrTest(){
        TestItem item = new TestItem() {
            @Override
            public void test() {
                Optional<Object> optional = Optional.absent();
                System.out.println(optional.or("test"));
            }
        };
        test("optionOrTest", item);
    }

    @Test
    public void preconditionTest(){
        test("preconditionTest", new TestItem() {
            @Override
            public void test() {
                Preconditions.checkArgument(true, "Can not be false! Or an IllegalArgumentException will be thrown.");
                Preconditions.checkNotNull("123", "Can not be null! Or an NullPointerException will be thrown.");
                Preconditions.checkElementIndex(5, 10, "【0-10】不包括10-》IndexOutOfBoundsException");
                Preconditions.checkPositionIndex(5, 5, "【0-5】包括5-》IndexOutOfBoundsException");
                Preconditions.checkPositionIndexes(1, 5, 5);
            }
        });
    }

    @Test
    public void objectsTest(){
        test("objectsTest", new TestItem() {
            @Override
            public void test() {
                printTest("Objects.equal(\"a\", \"a\")", Objects.equal("a", "a"));
                printTest("Objects.equal(null, \"a\")", Objects.equal(null, "a"));

                printTest("Objects.hashCode(123)", Objects.hashCode(123));
                printTest("Objects.toStringHelper(this).add(\"x\", 1).toString();", MoreObjects.toStringHelper(this).add("x", 1).toString());

            }
        });
    }

    @Test
    public void testComparisonChain(){
        test("testComparisonChian", new TestItem() {
            @Override
            public void test() {
                StringBuilder sb = new StringBuilder();
                sb.append("        return ComparisonChain.start()\n" +
                        "                .compare(this.level, o.level)\n" +
                        "                .compare(this.name, o.name)\n" +
                        "                .result();");
                printTest("使用ComparisonChain比较");
                ComparisonBean bean1 = new ComparisonBean("B", 1);
                ComparisonBean bean2 = new ComparisonBean("A", 2);
                printTest(sb.toString(), bean1.compareTo(bean2));
            }
        });
    }

}
