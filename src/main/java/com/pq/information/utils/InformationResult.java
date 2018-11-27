package com.pq.information.utils;


import com.pq.common.exception.CommonErrors;
import com.pq.common.exception.ErrorCode;

/**
 * 结果对象
 * @author liutao
 */
public class InformationResult {
    public InformationResult(){}

    public InformationResult(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    private ErrorCode errorCode = CommonErrors.SUCCESS;


    private Object data;

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrCode(){
        return errorCode.getErrorCode();
    }


    public String getErrMsg(){
        return errorCode.getErrorMsg();
    }

    public Object getData() {
        return data;
    }
    
    public void setData(Object data) {
        this.data = data;
    }
}