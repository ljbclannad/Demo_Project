package com.example.demo.mybaits.bean.entity;


public class CoreMessage {

    private long id;
    private String messageType;
    private String message;
    private Integer status;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
