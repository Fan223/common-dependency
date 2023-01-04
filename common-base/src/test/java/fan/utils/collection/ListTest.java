package fan.utils.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 列表测试类
 *
 * @author Fan
 * @since 2023/1/3 16:45
 */
class ListTest {

    @Test
    void nullTest() {
        List<String> list = new ArrayList<>();
        Assertions.assertTrue(ListUtil.isEmpty(list));
        Assertions.assertFalse(ListUtil.isNotEmpty(list));

        list.add("1");
        Assertions.assertFalse(ListUtil.isEmpty(list));
        Assertions.assertTrue(ListUtil.isNotEmpty(list));
    }

    @Test
    void castTest() {
        Object strings = new ArrayList<String>(){{
            this.add("ff");
            this.add("dd");
        }};
        Assertions.assertDoesNotThrow(() -> ListUtil.castToList(String.class, strings));

        Object doubles = new ArrayList<Double>(){{
            this.add(1.2);
            this.add(3.4);
        }};
        Assertions.assertDoesNotThrow(() -> ListUtil.castToList(Double.class, doubles));
    }
}
