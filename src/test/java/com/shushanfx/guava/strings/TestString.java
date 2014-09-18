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
                printTest("// ������ Joiner");
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
                printTest("// ������ Joiner");
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
                String noControl = CharMatcher.JAVA_ISO_CONTROL.removeFrom("bcd\b\t"); //�Ƴ�control�ַ�
                String theDigits = CharMatcher.DIGIT.retainFrom("123abc"); //ֻ���������ַ�
                String spaced = CharMatcher.WHITESPACE.trimAndCollapseFrom("   a    b   ", ' '); //ȥ�����˵Ŀո񣬲����м�������ո��滻�ɵ����ո�
                String noDigits = CharMatcher.JAVA_DIGIT.replaceFrom("123abc", "*"); //��*���滻��������
                String lowerAndDigit = CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom("abc123ABC"); // ֻ�������ֺ�Сд��ĸ
                printTest("String noControl = CharMatcher.JAVA_ISO_CONTROL.removeFrom(\"\"); //�Ƴ�control�ַ�");
                printTest("", noControl);
                printTest("String theDigits = CharMatcher.DIGIT.retainFrom(\"123abc\"); //ֻ���������ַ�");
                printTest("", theDigits);
                printTest("String spaced = CharMatcher.WHITESPACE.trimAndCollapseFrom(\"   a    b   \", ' '); //ȥ�����˵Ŀո񣬲����м�������ո��滻�ɵ����ո�");
                printTest("", spaced);
                printTest("String noDigits = CharMatcher.JAVA_DIGIT.replaceFrom(\"123abc\", \"*\"); //��*���滻��������");
                printTest("", noDigits);
                printTest("String lowerAndDigit = CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom(\"abc123ABC\"); // ֻ�������ֺ�Сд��ĸ");
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
