package com.atguigu.cloud.resp;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResultData<T> {

    private Integer code;
    private String massage;
    private T data;
    private long timestamp;

    private ResultData() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ResultData<T> success(T data) {
        ResultData resultData = new ResultData<>();
        resultData.setCode(ReturnCodeEnum.RC200.getCode());
        resultData.setMassage(ReturnCodeEnum.RC200.getMessage());
        resultData.setData(data);
        return resultData;
    }

    public static <T> ResultData<T> fail(Integer code, String message) {
        ResultData resultData = new ResultData<>();
        resultData.setCode(code);
        resultData.setMassage(message);
        resultData.setData(null);
        return resultData;
    }


}
