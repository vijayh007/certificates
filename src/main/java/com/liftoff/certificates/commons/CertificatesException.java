package com.liftoff.certificates.commons;

/**
 * Created by vijay.hathimare on 1/27/18.
 */
public class CertificatesException extends RuntimeException {
    private CertificatesErrorCodes errorCode;
    private static final long serialVersionUID = -3853689944157298314L;

    public CertificatesException(CertificatesErrorCodes errorCode) {
        super(errorCode.getErrorString());
        this.errorCode = errorCode;
    }

    public CertificatesException(String s) {
        super(s);
    }

    public CertificatesException(int errorCode, String msg) {
        super(msg);
        if (errorCode >= 300 && errorCode <= 399) {
            this.errorCode = CertificatesErrorCodes.REDIRECTION_ERROR;
        } else if (errorCode >= 400 && errorCode <= 499) {
            this.errorCode = CertificatesErrorCodes.BAD_REQUEST_ERROR;
        } else if (errorCode >= 500 && errorCode <= 599) {
            this.errorCode = CertificatesErrorCodes.SERVER_ERROR;
        }
    }


    public CertificatesException(CertificatesErrorCodes errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public CertificatesException(CertificatesErrorCodes errorCode, String msg, Throwable cause) {
        super(msg, cause);
        this.errorCode = errorCode;
    }

    public CertificatesException(CertificatesErrorCodes errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public CertificatesErrorCodes getErrorCode() {
        return errorCode;
    }

    public Integer getStatusCode() {
        return this.errorCode.getStatusCode();
    }

}
