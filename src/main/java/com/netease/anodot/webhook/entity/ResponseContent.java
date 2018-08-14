package com.netease.anodot.webhook.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created on 2018/8/10 14:23.
 *
 * @author Stanley Huang
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseContent<T> {

    private boolean success;
    private T data;
    private String message;
    private int errcode;

    public ResponseContent(
            @JsonProperty("success") boolean success,
            @JsonProperty("data") T data,
            @JsonProperty("message") String message) {
        this.success = success;
        this.data = data;
        this.message = message;
        this.errcode = 0;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }
}
