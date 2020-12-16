package com.abc.common;

public class Res<T> {
    private int status;
    private String msg;
    private T data;

    //构造器1
    private Res(int status, String msg, T date) {
        this.status = status;
        this.msg = msg;
        this.data = date;
    }

    //构造器2
    private Res(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    //get方法
    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    //方法重写
    @Override
    //返回字符串
    public String toString() {
        return "Res{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    //success

    public static <T> Res<T> success(ResEnum re, T data) {
        return new Res<T>(re.getStatus(), re.getMsg(), data);
    }

    public static Res success(ResEnum re) {
        return new Res(re.getStatus(), re.getMsg());
    }

    public static Res success() {
        return new Res(ResEnum.SUCCESSS.getStatus(), ResEnum.SUCCESSS.getMsg());
    }

    //error
    public static <T> Res<T> error(ResEnum re, T data) {
        return new Res<T>(re.getStatus(), re.getMsg(), data);
    }

    public static Res error(ResEnum re) {
        return new Res(re.getStatus(), re.getMsg());
    }

    public static Res error() {
        return new Res(ResEnum.ERROR.getStatus(), ResEnum.ERROR.getMsg());
    }

}
