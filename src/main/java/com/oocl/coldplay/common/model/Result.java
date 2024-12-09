package com.oocl.coldplay.common.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private Boolean success;
    private String errorMsg;
    private Object data;
    private Long total;

    // 没有资源返回的成功消息返回
    public static Result ok() {
        return new Result(true, null, null, null);
    }

    // 有资料返回的成功消息返回
    public static Result ok(Object data) {
        return new Result(true, null, data, null);
    }

    // 有资料，有长度的成功消息返回
    public static Result ok(List<?> data, Long total) {
        return new Result(true, null, data, total);
    }

    public static Result ok(List<?> data) {
        return new Result(true, null, data, data.isEmpty() ? 0L : (long) data.size());
    }

    // 有信息的错误消息返回
    public static Result fail(String errorMsg) {
        return new Result(false, errorMsg, null, null);
    }
}