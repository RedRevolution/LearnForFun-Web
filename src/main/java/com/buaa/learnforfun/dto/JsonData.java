package com.buaa.learnforfun.dto;



import java.util.HashMap;
import java.util.Map;

/**
 * @创建人 chengyin
 * @创建时间 2018/7/25
 * @描述
 */

public class JsonData {

    private boolean ret;

    private Integer code;

    private String msg;

    private Object data;

    public JsonData(boolean ret) {
        this.ret = ret;
    }

    public static JsonData success() {
        JsonData jsonData = new JsonData(true);
        return jsonData;
    }

    public static JsonData success(Object object) {
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        jsonData.code = 0;
        return jsonData;
    }

    public static JsonData success(Object object, String msg) {
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        jsonData.code = 0;
        jsonData.msg = msg;
        return jsonData;
    }

    public static JsonData fail(String msg) {
        JsonData jsonData = new JsonData(false);
        jsonData.msg = msg;
        jsonData.code = -1;
        return jsonData;
    }

    public static JsonData noToken(String msg) {
        JsonData jsonData = new JsonData(false);
        jsonData.msg = msg;
        jsonData.code = 1;
        return jsonData;
    }

    public Map<String,Object> toMap(){
        HashMap<String,Object> result = new HashMap<>();
        result.put("ret",ret);
        result.put("msg",msg);
        result.put("code",code);
        result.put("data",data);
        return result;
    }

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
