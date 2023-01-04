package fan.collection;

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
    }

    @Test
    void nonNullTest() {
        Assertions.assertFalse(StringUtil.isNotBlank(null));
        Assertions.assertFalse(StringUtil.isNotBlank(""));
        Assertions.assertFalse(StringUtil.isNotBlank("  "));
        Assertions.assertTrue(StringUtil.isNotBlank("  1 "));
    }
}
