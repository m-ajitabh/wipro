package com.aj.wipro.global;

public enum MessageTypes {

	LoginSuccess("LoginSuccessAlert"),
	SuccessOrderMessage("Your order has been placed successfully");


	public final String messageType;
	MessageTypes(String messageType) {
		this.messageType = messageType;
	}

	public String getMessage() {
		return this.messageType;
	}

}
