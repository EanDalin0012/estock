package com.estock.api.common.exception;

public class CustomException extends Throwable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String messageCode;
    private String message;

    public CustomException(String messageCode, String message) {
        this.messageCode = messageCode;
        this.message = message;
    }
    
    public CustomException(String messageCode) {
        this.messageCode = messageCode;
    }

    public CustomException(String messageCode, Throwable throwable) {
        super(throwable);
        this.messageCode = messageCode;
    }

    public CustomException(String messageCode, String message, Throwable throwable) {
        super(throwable);
        this.messageCode = messageCode;
        this.message = message;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String messageCode) {
        this.messageCode = messageCode;
    }
}
