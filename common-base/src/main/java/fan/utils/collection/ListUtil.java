package fan.utils.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * List 工具类
 *
 * @author Fan
 * @since 2023/1/3 16:29
 */
public class ListUtil {

    /**
     * 该类均为静态方法, 不需要实例化, 而 Java 为每个类添加了一个隐式公共构造函数, 因此, 应至少定义一个非公共构造函数
     *
     * @author Fan
     * @since 2023/1/3 16:37
     */
    private ListUtil() {
    }

    /**
     * 判断 List 是否为空
     *
     * @param list 列表
     * @return {@link boolean}
     * @author Fan
     * @since 2023/1/3 16:37
     */
    public static boolean isEmpty(List<?> list) {
        return null == list || list.isEmpty();
    }

    /**
     * 判断 List 是否不为空
     *
     * @param list 列表
     * @return {@link boolean}
     * @author Fan
     * @since 2023/1/3 16:37
     */
    public static boolean isNotEmpty(List<?> list) {
        return !isEmpty(list);
    }

    /**
     * 将 Object 类型的 List 数据转换为 List 类型
     *
     * @param clazz  转换的泛型类型
     * @param object List 数据
     * @return {@link List<T>}
     * @author Fan
     * @since 2023/1/3 17:08
     */
    public static <T> List<T> castToList(Class<T> clazz, Object object) {
        List<T> list = new ArrayList<>();

        if (object instanceof List<?>) {
            for (Object obj : (List<?>) object) {
                list.add(clazz.cast(obj));
            }
        }

        return list;
    }

    /**
     * 将多个元素转为指定泛型的 List
     *
     * @param clazz 泛型类型
     * @param elements 多个元素
     * @return {@link List<T>}
     * @author zhaojunjie
     * @since 2023/1/6 11:38
     */
    public static <T> List<T> transToList(Class<T> clazz, Object... elements) {
        List<T> list = new ArrayList<>();

        for (Object element : elements) {
            list.add(clazz.cast(element));
        }

        return list;
    }
}
