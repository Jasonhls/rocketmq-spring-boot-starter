package org.rocketmq.starter.core.consumer;

/**
 *
 * @author He Jialin
 */

public class OperationResult<T> {

    private Boolean success;

    private String message;

    private T data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static OperationResult result(Boolean success, String message){
        OperationResult result = new OperationResult();
        result.setMessage(message);
        result.setSuccess(success);
        return result;
    }


}
