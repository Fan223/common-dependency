package fan.utils.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 数组测试类
 *
 * @author Fan
 * @since 2023/1/4 11:08
 */
class ArrayTest {

    @Test
    void nullTest() {
        String[] strings1 = new String[0];
        String[] strings2 = new String[2];

        Assertions.assertTrue(ArrayUtil.isEmpty(strings1));
        Assertions.assertFalse(ArrayUtil.isEmpty(strings2));

        Assertions.assertFalse(ArrayUtil.isNotEmpty(strings1));
        Assertions.assertTrue(ArrayUtil.isNotEmpty(strings2));
    }
}
