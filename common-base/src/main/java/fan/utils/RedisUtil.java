package fan.utils;

import fan.utils.collection.ArrayUtil;
import fan.utils.collection.ListUtil;
import fan.utils.collection.StringUtil;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Redis 工具类
 *
 * @author Fan
 * @since 2023/1/4 11:02
 */
public class RedisUtil {

    /**
     * 该类均为静态方法, 不需要实例化, 而 Java 为每个类添加了一个隐式公共构造函数, 因此, 应至少定义一个非公共构造函数
     *
     * @author Fan
     * @since 2023/1/4 15:29
     */
    private RedisUtil() {
    }

    private static RedisTemplate<String, Object> redisTemplate;

    @Resource
    public static void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        RedisUtil.redisTemplate = redisTemplate;
    }

    /**
     * 设置过期时间
     *
     * @param key    Key
     * @param expire 过期时间, 单位秒
     * @return {@link boolean}
     * @author zhaojunjie
     * @since 2023/1/4 17:06
     */
    public static boolean expire(String key, long expire) {
        try {
            if (expire > 0) {
                return Boolean.TRUE.equals(redisTemplate.expire(key, expire, TimeUnit.SECONDS));
            } else {
                LogUtil.error("过期时间小于0");
                return false;
            }
        } catch (Exception e) {
            LogUtil.error("过期时间设置失败" + e.getMessage());
            return false;
        }
    }

    /**
     * 删除多个缓存
     *
     * @param keys 多个Key
     * @author Fan
     * @since 2023/1/4 14:55
     */
    public static boolean del(String... keys) {
        try {
            if (ArrayUtil.isEmpty(keys)) {
                LogUtil.error("Key 为空");
                return false;
            }

            redisTemplate.delete(Arrays.asList(keys));
            return true;
        } catch (Exception e) {
            LogUtil.error("删除多个缓存失败" + e.getMessage());
            return false;
        }
    }

    /**
     * 批量删除缓存
     *
     * @param keys Key列表
     * @author Fan
     * @since 2023/1/4 14:57
     */
    public static boolean del(List<String> keys) {
        try {
            if (ListUtil.isEmpty(keys)) {
                LogUtil.error("Key 为空");
                return false;

            }

            redisTemplate.delete(keys);
            return true;
        } catch (Exception e) {
            LogUtil.error("批量删除缓存失败" + e.getMessage());
            return false;
        }
    }

    /**
     * 判断 Key 是否存在
     *
     * @param key Key
     * @return {@link boolean}
     * @author Fan
     * @since 2023/1/4 14:59
     */
    public static boolean hasKey(String key) {
        try {
            return StringUtil.isNotBlank(key) && Boolean.TRUE.equals(redisTemplate.hasKey(key));
        } catch (Exception e) {
            LogUtil.error("判断Key是否存在失败" + e.getMessage());
            return false;
        }
    }

    /**
     * String 类型 设置缓存
     *
     * @param key   Key
     * @param value 值
     * @return {@link boolean}
     * @author Fan
     * @since 2023/1/4 15:09
     */
    public static boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            LogUtil.error("String类型 设置缓存失败" + e.getMessage());
            return false;
        }
    }

    /**
     * String 类型, 设置缓存, 带过期时间
     *
     * @param key    Key
     * @param value  值
     * @param expire 过期时间, 单位秒
     * @return {@link boolean}
     * @author Fan
     * @since 2023/1/4 15:12
     */
    public static boolean set(String key, Object value, long expire) {
        try {
            if (expire > 0) {
                redisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
                return true;
            } else {
                LogUtil.error("过期时间小于0");
                return false;
            }
        } catch (Exception e) {
            LogUtil.error("String类型 设置过期缓存失败" + e.getMessage());
            return false;
        }
    }

    /**
     * String 类型, 获取缓存
     *
     * @param key Key
     * @return {@link Object}
     * @author Fan
     * @since 2023/1/4 15:13
     */
    public static Object get(String key) {
        try {
            return redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            LogUtil.error("String类型, 获取缓存失败" + e.getMessage());
            return null;
        }
    }

    /**
     * Hash 类型, 设置缓存
     *
     * @param key     Key
     * @param hashKey HashKey
     * @param value   值
     * @return {@link boolean}
     * @author Fan
     * @since 2023/1/4 15:14
     */
    public static boolean hashSet(String key, String hashKey, Object value) {
        try {
            redisTemplate.opsForHash().put(key, hashKey, value);
            return true;
        } catch (Exception e) {
            LogUtil.error("Hash类型 设置缓存失败" + e.getMessage());
            return false;
        }
    }

    /**
     * Hash 类型, 设置缓存, 带过期时间
     *
     * @param key     Key
     * @param hashKey HashKey
     * @param value   值
     * @param expire  过期时间
     * @return {@link boolean}
     * @author Fan
     * @since 2023/1/4 15:15
     */
    public static boolean hashSet(String key, String hashKey, Object value, long expire) {
        try {
            boolean hashSet = hashSet(key, hashKey, value);
            boolean exp = expire(key, expire);

            return hashSet && exp;
        } catch (Exception e) {
            LogUtil.error("Hash类型 设置过期缓存失败" + e.getMessage());
            return false;
        }
    }

    /**
     * Hash 类型, 获取缓存
     *
     * @param key     Key
     * @param hashKey HashKey
     * @return {@link Object}
     * @author Fan
     * @since 2023/1/4 15:19
     */
    public static Object hashGet(String key, String hashKey) {
        try {
            return redisTemplate.opsForHash().get(key, hashKey);
        } catch (Exception e) {
            LogUtil.error("Hash类型, 获取缓存失败" + e.getMessage());
            return null;
        }
    }

    /**
     * Hash 类型, 删除缓存
     *
     * @param key     Key
     * @param hashKey HashKey
     * @author Fan
     * @since 2023/1/4 15:20
     */
    public static boolean hashDel(String key, Object... hashKey) {
        try {
            if (StringUtil.isBlank(key) || ArrayUtil.isEmpty(hashKey)) {
                LogUtil.error("Key 或 HashKey 为空");
                return false;
            }

            redisTemplate.opsForHash().delete(key, hashKey);
            return true;
        } catch (Exception e) {
            LogUtil.error("Hash类型, 删除缓存失败" + e.getMessage());
            return false;
        }
    }
}
