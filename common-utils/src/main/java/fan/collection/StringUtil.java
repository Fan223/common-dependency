package fan.collection;

/**
 * 字符串工具类
 *
 * @author Fan
 * @since 2023/1/3 16:11
 */
public class StringUtil {

    /**
     * 该类均为静态方法, 不需要实例化, 而 Java 为每个类添加了一个隐式公共构造函数, 因此, 应至少定义一个非公共构造函数
     *
     * @author Fan
     * @since 2023/1/3 16:37
     */
    private StringUtil() {
    }

    /**
     * 判断字符串是否为空, 包括 null, 空串, 空格
     *
     * @param str 字符串
     * @return {@link boolean}
     * @author Fan
     * @since 2023/1/3 16:22
     */
    public static boolean isBlank(String str) {
        return null == str || 0 == str.length() || 0 == str.trim().length();
    }

    /**
     * 判断字符串是否不为空
     *
     * @param str 字符串
     * @return {@link boolean}
     * @author Fan
     * @since 2023/1/3 15:59
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }
}
