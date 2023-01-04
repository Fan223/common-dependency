package fan.utils.collection;

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
     * 判断字符串是否为空白, 包括 null, 空串, 空白符
     *
     * @param charSequence 字符串结构
     * @return {@link boolean}
     * @author Fan
     * @since 2023/1/3 16:22
     */
    public static boolean isBlank(CharSequence charSequence) {
        if (null == charSequence || 0 == charSequence.length()) {
            return true;
        }

        for (int i = 0; i < charSequence.length(); i++) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串是否不为空白
     *
     * @param charSequence 字符串结构
     * @return {@link boolean}
     * @author Fan
     * @since 2023/1/3 15:59
     */
    public static boolean isNotBlank(CharSequence charSequence) {
        return !isBlank(charSequence);
    }
}
