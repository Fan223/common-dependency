package fan.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * 日志工具类
 *
 * @author Fan
 * @since 2023/1/4 10:52
 */
@Slf4j
public class LogUtil {

    /**
     * 该类均为静态方法, 不需要实例化, 而 Java 为每个类添加了一个隐式公共构造函数, 因此, 应至少定义一个非公共构造函数
     *
     * @author Fan
     * @since 2023/1/4 15:29
     */
    private LogUtil() {
    }

    /**
     * 打印 info 日志
     *
     * @param infoMsg info信息
     * @author Fan
     * @since 2023/1/4 10:56
     */
    public static void info(String infoMsg) {
        log.info(infoMsg);
    }

    /**
     * 打印 warn 日志
     *
     * @param warnMsg warn信息
     * @author Fan
     * @since 2023/1/4 10:56
     */
    public static void warn(String warnMsg) {
        log.warn(warnMsg);
    }

    /**
     * 打印 error 日志
     *
     * @param errorMsg error信息
     * @author Fan
     * @since 2023/1/4 10:56
     */
    public static void error(String errorMsg) {
        log.error(errorMsg);
    }
}
