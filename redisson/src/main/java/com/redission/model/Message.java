package com.redission.model;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author hchen10
 */
public class Message<T> implements Model<T> {

    public static final int SUCCESS_CODE = 200;
    public static final int FAIL_CODE = 500;
    /**
     * 响应码
     * @since 1.0
     */
    private int code = 200;
    /**
     * 响应实体
     * @since 1.0
     */
    private T obj;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 消息列表
     */
    private List<?> msgList;
    /**
     * 是否成功
     */
    private Boolean success;
    /**
     * 错误信息
     */
    private List<Map<String, Object>> errors = new ArrayList<>();
    /**
     * 额外信息
     */
    private ExtraInfo extraInfo;

    public Message() {
    }

    public Message(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> Message<T> success() {
        return message("请求成功");
    }

    public static <T> Message<T> message(String message) {
        return success(null, message);
    }

    public static <T> Message<T> success(T obj) {
        return success(obj, "");
    }

    public static <T> Message<T> success(T obj, String message) {
        Message<T> msg = new Message<>();
        msg.setObj(obj);
        msg.setMessage(message);
        msg.setCode(SUCCESS_CODE);
        msg.setSuccess(true);
        return msg;
    }

    public static <T> Message<T> error(int code, String message, T obj) {
        Message<T> msg = new Message<>();
        msg.setCode(code);
        msg.setMessage(message);
        msg.setSuccess(false);
        msg.setObj(obj);
        return msg;
    }


    public static <T> Message<T> error(String message) {
        return error(FAIL_CODE,  message);
    }

    public static <T> Message<T> error(int code, String message) {
        return error(code, message, null);
    }

    public int getCode() {
        return code;
    }

    public Message<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public T getObj() {
        return obj;
    }

    public Message<T> setObj(T obj) {
        this.obj = obj;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Message<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public List<?> getMsgList() {
        return msgList;
    }

    public Message<T> setMsgList(List<?> msgList) {
        this.msgList = msgList;
        return this;
    }

    public boolean isSuccess() {
        this.setSuccess(null == this.success ? this.getCode() == 200 || this.getCode() == 0 : this.success);
        return this.success;
    }

    public Message<T> addErrors(String id, String msg) {
        Map<String, Object> field = new HashMap<>(4);
        field.put("id", id);
        field.put("msg", msg);
        this.getErrors().add(field);
        if (this.code == SUCCESS_CODE || this.code == 0) {
            this.setCode(590);
        }
        return this;
    }

    public List<Map<String, Object>> getErrors() {
        return errors;
    }

    public Message<T> setErrors(List<Map<String, Object>> errors) {
        this.errors = errors;
        return this;
    }

    public Message<T> setSuccess(Boolean success) {
        this.success = success;
        if (success) {
            if (this.code != SUCCESS_CODE && this.code != 0) {
                this.setCode(0);
            }
        } else if (this.code == SUCCESS_CODE || this.code == 0) {
            this.setCode(-1);
        }

        return this;
    }

    public ExtraInfo getExtraInfo() {
        return extraInfo;
    }

    public Message<T> setExtraInfo(ExtraInfo extraInfo) {
        this.extraInfo = extraInfo;
        return this;
    }

    public Message<T> setTotalCount(long totalCount) {
        if(this.extraInfo == null){
            this.extraInfo = new ExtraInfo();
        }
        this.extraInfo.setTotalCount(totalCount);
        return this;
    }

    @Override
    public String toString() {
        return "Message{" +
                "code=" + code +
                ", obj=" + obj +
                ", message='" + message + '\'' +
                ", msgList=" + msgList +
                ", success=" + success +
                ", errors=" + errors +
                ", extraInfo=" + extraInfo +
                '}';
    }
}
