package com.liftoff.certificates.commons;

/**
 * Created by vijay.hathimare on 1/27/18.
 */
public enum CertificatesErrorCodes {

    REDIRECTION_ERROR("REDIRECTION_ERROR:F-9000-01", "Redirection Error", 300),
    BAD_REQUEST_ERROR("BAD_REQUEST_ERROR:F-9000-01", "Bad Request Error", 400),
    SERVER_ERROR("SERVER_ERROR:F-9000-01", "Server Error", 500),
    USERID_IS_INVALID("USERID_IS_INVALID:F-1024-01", "user id is null or blank", 200);


    //CPP ERROR CODES end
    private String errorCode;
    private String errorString;
    private Integer statusCode;

    CertificatesErrorCodes(String errorCode, String errorString, Integer statusCode) {
        this.errorCode = errorCode;
        this.errorString = errorString;
        this.statusCode = statusCode;
    }
    public String getErrorString() {
        return errorString;
    }

    public String getErrorCode() {
        return errorCode;
    }
    public Integer getStatusCode() {
        return statusCode;
    }
}
