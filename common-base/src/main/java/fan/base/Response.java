package fan.base;

import lombok.Builder;
import lombok.Getter;
import org.springframework.context.annotation.Conditional;

/**
 * 统一响应结果返回类
 *
 * @author Fan
 * @since 2023/1/3 15:20
 */
@Builder
@Getter
public class Response {

    /**
     * 响应码
     */
    private int code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * 成功响应
     *
     * @param code    响应码
     * @param message 返回信息
     * @param data    返回数据
     * @return {@link Response}
     * @author Fan
     * @since 2023/1/3 15:28
     */
    public static Response success(int code, String message, Object data) {
        return Response.builder().code(code).message(message).data(data).build();
    }

    /**
     * 成功响应, 响应码默认 200
     *
     * @param message 返回信息
     * @param data    返回数据
     * @return {@link Response}
     * @author Fan
     * @since 2023/1/3 15:31
     */
    public static Response success(String message, Object data) {
        return Response.builder().code(200).message(message).data(data).build();
    }

    /**
     * 成功响应, 响应码默认 200, 返回信息默认 "操作成功"
     *
     * @param data 返回数据
     * @return {@link Response}
     * @author Fan
     * @since 2023/1/3 15:31
     */
    public static Response success(Object data) {
        return Response.builder().code(200).message("操作成功").data(data).build();
    }

    /**
     * 失败响应
     *
     * @param code    响应码
     * @param message 返回信息
     * @param data    返回数据
     * @return {@link Response}
     * @author Fan
     * @since 2023/1/3 15:32
     */
    public static Response fail(int code, String message, Object data) {
        return Response.builder().code(code).message(message).data(data).build();
    }

    /**
     * 失败响应, 响应码默认 500
     *
     * @param message 返回信息
     * @param data    返回数据
     * @return {@link Response}
     * @author Fan
     * @since 2023/1/3 15:32
     */
    public static Response fail(String message, Object data) {
        return Response.builder().code(500).message(message).data(data).build();
    }

    /**
     * 失败响应, 响应码默认 500, 返回信息默认 "操作失败"
     *
     * @param data 返回数据
     * @return {@link Response}
     * @author Fan
     * @since 2023/1/3 15:32
     */
    public static Response fail(Object data) {
        return Response.builder().code(500).message("操作失败").data(data).build();
    }
}
