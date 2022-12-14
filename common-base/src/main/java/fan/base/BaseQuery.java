package fan.base;

import lombok.Data;

/**
 * 基础查询参数
 *
 * @author Fan
 * @since 2023/1/4 14:49
 */
@Data
public class BaseQuery {

    /**
     * 当前页
     */
    private int currentPage;

    /**
     * 页面大小
     */
    private int pageSize;
}
