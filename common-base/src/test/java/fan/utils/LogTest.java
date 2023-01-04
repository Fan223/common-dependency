package fan.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 日志测试
 *
 * @author Fan
 * @since 2023/1/4 10:58
 */
class LogTest {

    @Test
    void logTest() {
        Assertions.assertDoesNotThrow(() -> LogUtil.info("info"));
        Assertions.assertDoesNotThrow(() -> LogUtil.warn("warn"));
        Assertions.assertDoesNotThrow(() -> LogUtil.error("error"));
    }
}
