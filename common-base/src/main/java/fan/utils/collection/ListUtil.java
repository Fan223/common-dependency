package fan.utils.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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
     * 新建一个空 List
     *
     * @param isLinked 是否为 LinkedList
     * @return {@link List<T>}
     * @author zhaojunjie
     * @since 2023/1/9 9:26
     */
    public static <T> List<T> list(boolean isLinked) {
        return isLinked ? new LinkedList<>() : new ArrayList<>();
    }

    /**
     * 新建一个指定泛型的空 List
     *
     * @param isLinked 是否为 LinkedList
     * @param clazz    泛型类型
     * @return {@link List<T>}
     * @author zhaojunjie
     * @since 2023/1/9 9:31
     */
    public static <T> List<T> list(boolean isLinked, Class<T> clazz) {
        return isLinked ? new LinkedList<>() : new ArrayList<>();
    }

    /**
     * 新建一个传入多个值的 List
     *
     * @param isLinked 是否为 LinkedList
     * @param values   多个值
     * @return {@link List<T>}
     * @author zhaojunjie
     * @since 2023/1/9 9:39
     */
    @SafeVarargs
    public static <T> List<T> list(boolean isLinked, T... values) {
        if (ArrayUtil.isEmpty(values)) {
            return list(isLinked);
        }

        final List<T> arrayList = isLinked ? new LinkedList<>() : new ArrayList<>(values.length);
        Collections.addAll(arrayList, values);
        return arrayList;
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
}
