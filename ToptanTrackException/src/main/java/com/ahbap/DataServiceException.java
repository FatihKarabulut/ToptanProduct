package com.ahbap;

public class DataServiceException extends RuntimeException
{

    public DataServiceException()
    {}
    public DataServiceException(String msg){
        super(msg);
    }
    public DataServiceException(String msg, Throwable cause){
        super(msg,cause);
    }
    public DataServiceException(Throwable cause){
        super(cause);
    }
    @Override
    public String toString() {
        return "DataServiceException{" + "msg=" + getMessage() + '}';
    }
}
