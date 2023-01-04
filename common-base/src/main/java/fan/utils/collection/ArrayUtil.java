package fan.utils.collection;

/**
 * 数组工具类
 *
 * @author Fan
 * @since 2023/1/4 11:05
 */
public class ArrayUtil {

    /**
     * 该类均为静态方法, 不需要实例化, 而 Java 为每个类添加了一个隐式公共构造函数, 因此, 应至少定义一个非公共构造函数
     *
     * @author Fan
     * @since 2023/1/4 11:23
     */
    private ArrayUtil() {
    }

    /**
     * 判断数组是否为空
     *
     * @param array 数组
     * @return {@link boolean}
     * @author Fan
     * @since 2023/1/4 11:07
     */
    public static <T> boolean isEmpty(T[] array) {
        return null == array || 0 == array.length;
    }

    /**
     * 判断数组是否不为空
     *
     * @param array 数组
     * @return {@link boolean}
     * @author Fan
     * @since 2023/1/4 11:07
     */
    public static <T> boolean isNotEmpty(T[] array) {
        return !isEmpty(array);
    }
}
