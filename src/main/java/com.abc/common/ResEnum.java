package com.abc.common;

public enum ResEnum {

    SUCCESSS(200, "success"),
    SUCCESS_USER_EXIST(201, "user exist success"),
    ERROR_USER_EXIST(501, "user exist error"),
    ERROR(500, "error"),
    ERROR_PARAMS_IN_DELBATCH (501,"param can't be null") ,
    SUCCESSS_DEL_BATCH (202,"delete batch success") ;
    private int status;
    private String msg;

    //构造器
    ResEnum(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    //get方法
    public int getStatus() {
        return status;
    }

    //get方法
    public String getMsg() {
        return msg;
    }

}
