package com.pq.information.utils;

/**
 *
 * @author liken
 * @date 15/3/14
 */
public class InformationResult<T> {

    private T data;

    private String status = "00000";

    private String message = "成功";


    public InformationResult(){
    }

    public InformationResult(T data, String status, String message){
        this.data = data;
        this.status = status;
        this.message = message;
    }

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    /**
     * 通用成功结果对象
     * @return
     */
    public static <T> InformationResult<T> success(T value){
        InformationResult<T> res = new InformationResult<T>();
        res.setData(value);
        return res;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
