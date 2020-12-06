package com.tao.demo.common;

import lombok.Data;

@Data
public class ReturnMessage {
    private boolean success;
    private String code;
    private String msg;

    public static ReturnMessage success() {
        ReturnMessage r = new ReturnMessage();
        r.setSuccess(true);
        r.setCode("200");
        r.setMsg("success");
        return r;
    }

    public static ReturnMessage error(String msg) {
        ReturnMessage r = new ReturnMessage();
        r.setSuccess(false);
        r.setCode("500");
        r.setMsg(msg);
        return r;
    }
}
