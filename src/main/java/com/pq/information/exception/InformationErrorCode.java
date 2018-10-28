package com.pq.information.exception;


import com.pq.common.exception.ErrorCode;

public class InformationErrorCode extends ErrorCode {

    private final static String PRE = "4";

    public InformationErrorCode(String errorCode, String errorMsg) {
        super(PRE+errorCode, errorMsg);
    }
}

