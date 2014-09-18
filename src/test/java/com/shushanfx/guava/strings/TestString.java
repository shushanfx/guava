package com.shushanfx.guava.strings;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.shushanfx.test.util.TestItem;
import junit.framework.TestCase;
import static com.shushanfx.test.util.TestUtils.*;

/**
 * Created by dengjianxin on 2014/9/18.
 */
public class TestString extends TestCase{
    public void testJoiner(){
        test("testJoiner", new TestItem() {
            @Override
            public void test() {
                printTest("// 连接器 Joiner");
                Joiner joiner = Joiner.on("; ").skipNulls();
                printTest("              Joiner joiner = Joiner.on(\"; \").skipNulls();\n" +
                                "                joiner.join(\"Harry\", null, \"Ron\", \"Hermione\");",
                        joiner.join("Harry", null, "Ron", "Hermione"));


            }
        });
    }

    public void testSpitter(){
        test("testSpitter", new TestItem(){
            @Override
            public void test() {
                printTest("// 连接器 Joiner");
                printTest("Splitter.on(',')\n" +
                        "        .trimResults()\n" +
                        "        .omitEmptyStrings()\n" +
                        "        .split(\"foo,bar,,   qux\");",
                        Splitter.on(',')
                                .trimResults()
                                .omitEmptyStrings()
                                .split("foo,bar,,   qux"));
            }
        });
    }

    public void testCharMatcher(){
        test("testCharMatcher", new TestItem() {
            @Override
            public void test() {
                String noControl = CharMatcher.JAVA_ISO_CONTROL.removeFrom("bcd\b\t"); //移除control字符
                String theDigits = CharMatcher.DIGIT.retainFrom("123abc"); //只保留数字字符
                String spaced = CharMatcher.WHITESPACE.trimAndCollapseFrom("   a    b   ", ' '); //去除两端的空格，并把中间的连续空格替换成单个空格
                String noDigits = CharMatcher.JAVA_DIGIT.replaceFrom("123abc", "*"); //用*号替换所有数字
                String lowerAndDigit = CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom("abc123ABC"); // 只保留数字和小写字母
                printTest("String noControl = CharMatcher.JAVA_ISO_CONTROL.removeFrom(\"\"); //移除control字符");
                printTest("", noControl);
                printTest("String theDigits = CharMatcher.DIGIT.retainFrom(\"123abc\"); //只保留数字字符");
                printTest("", theDigits);
                printTest("String spaced = CharMatcher.WHITESPACE.trimAndCollapseFrom(\"   a    b   \", ' '); //去除两端的空格，并把中间的连续空格替换成单个空格");
                printTest("", spaced);
                printTest("String noDigits = CharMatcher.JAVA_DIGIT.replaceFrom(\"123abc\", \"*\"); //用*号替换所有数字");
                printTest("", noDigits);
                printTest("String lowerAndDigit = CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom(\"abc123ABC\"); // 只保留数字和小写字母");
                printTest("", lowerAndDigit);
            }
        });
    }

    public void testCaseFormat(){
        test("testCaseFormat", new TestItem() {
            @Override
            public void test() {
                printTest("CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, \"CONSTANT_NAME\");",
                        CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME"));
                printTest("CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, \"lowerCamel\");",
                        CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, "lowerCamel"));
            }
        });
    }
}
