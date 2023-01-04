package fan.utils.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 字符串测试类
 *
 * @author Fan
 * @since 2023/1/3 16:44
 */
class StringTest {

    @Test
    void nullTest() {
        Assertions.assertTrue(StringUtil.isBlank(null));
        Assertions.assertTrue(StringUtil.isBlank(""));
        Assertions.assertTrue(StringUtil.isBlank("  "));
        Assertions.assertFalse(StringUtil.isBlank("  1 "));
        Assertions.assertFalse(StringUtil.isBlank("  \t "));

        Assertions.assertTrue(StringUtil.isBlank(new StringBuffer("  ")));
        Assertions.assertTrue(StringUtil.isBlank(new StringBuilder("  ")));
    }

    @Test
    void nonNullTest() {
        Assertions.assertFalse(StringUtil.isNotBlank(null));
        Assertions.assertFalse(StringUtil.isNotBlank(""));
        Assertions.assertFalse(StringUtil.isNotBlank("  "));
        Assertions.assertFalse(StringUtil.isNotBlank("  \t "));
        Assertions.assertTrue(StringUtil.isNotBlank("  1 "));

        Assertions.assertFalse(StringUtil.isNotBlank(new StringBuffer("  ")));
        Assertions.assertFalse(StringUtil.isNotBlank(new StringBuilder("  ")));
    }
}
