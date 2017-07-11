package org.chm.boot.redis.entity;

/**
 * Created by charming on 2017/7/5.
 */
public class ResponseModal {
    private int code;
    private boolean flag;
    private String result;
    private String name;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String isResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ResponseModal(int code, boolean flag, String result, String name) {
        this.code = code;
        this.flag = flag;
        this.result = result;
        this.name = name;
    }
}
