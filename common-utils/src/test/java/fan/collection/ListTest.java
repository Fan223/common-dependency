package fan.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
        Assertions.assertTrue(ListUtil.isBlank(list));

        list.add("1");
        Assertions.assertFalse(ListUtil.isBlank(list));
    }

    @Test
    void transTest() {
        List<String> strings = ListUtil.transToList(String.class, "111", "222", "fff");
        List<String> stringList = new ArrayList<>();
        stringList.add("111");
        stringList.add("222");
        stringList.add("fff");
        Assertions.assertEquals(stringList, strings);

        List<Double> doubles = ListUtil.transToList(Double.class, 1.2, 3.2, 45.0);
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1.2);
        doubleList.add(3.2);
        doubleList.add(45.0);
        Assertions.assertEquals(doubleList, doubles);
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
