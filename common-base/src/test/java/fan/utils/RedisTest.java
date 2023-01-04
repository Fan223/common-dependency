package fan.utils;

import org.junit.jupiter.api.Test;

/**
 * Redis 测试类
 *
 * @author zhaojunjie
 * @since 2023/1/4 16:53
 */
class RedisTest {

    @Test
    void StringTest() {
        RedisUtil.set("test", "test111");

        Object o = RedisUtil.get("test");
        System.out.println(o);
    }
}
