package com.pq.information.exception;


import com.pq.common.exception.BaseException;
import com.pq.common.exception.ErrorCode;

/**
 * @author liutao
 */
public class InformationException extends BaseException {

    public InformationException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public InformationException(ErrorCode errorCode) {
        super(errorCode);
    }


    /**
     * 抛UserException异常
     * @param errorCode
     */
    public static void raise(ErrorCode errorCode){
        throw new InformationException(errorCode);
    }


    /**
     * 抛UserException异常
     * @param errorCode
     * @param cause 异常
     */
    public static void raise(ErrorCode errorCode, Throwable cause){
        throw new InformationException(errorCode, cause);
    }
}
