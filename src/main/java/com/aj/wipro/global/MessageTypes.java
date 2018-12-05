package com.aj.wipro.global;

public enum MessageTypes {
	
	LoginSuccess("LoginSuccessAlert"), 
	LogoutSuccess("Logged out successfully"),
	WrongMobileNumberPassword("Mobile number or password entered is incorrect."),
	InvalidMobileNumebr("Please enter a valid mobile number."),
	RegistrationSuccess("Successfully Registered"),
	EmptyCartPopupMessage("Are you sure you want to empty the cart"),
	SuccessOrderMessage("Your order has been placed successfully"),
	MegreSlotSuccessMessage("You have opted for Standard Delivery for your entire order. Please select Standard Delivery slot and continue."),
	SlotDefaultMessage("Please select delivery slot"),
	PersonalInfoUpdateMessage("User Data Updated Successfully");
	
	
	public final String messageType;
	MessageTypes(String messageType) {
		this.messageType = messageType;
	}
	
	public String getMessage() {
		return this.messageType;
	}

}
