package top.shixinzhang.springmvc.model;

import top.shixinzhang.springmvc.util.ConstantUtil;

/**
 * Created by zhangshixin on 19/4/6.
 */
public class CommonModel {
    private int code;
    private String msg;
    private Object data;

    public void setSuccess() {
        setCode(ConstantUtil.CODE_SUCCESS);
        setMsg(ConstantUtil.MSG_SUCCESS);
    }

    public void setFail() {
        setCode(ConstantUtil.CODE_FAIL);
        setMsg(ConstantUtil.MSG_FAIL);
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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
