package com.example.demo.exceptionHandling;

public class ReceiverAlreadyRegisteredException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReceiverAlreadyRegisteredException() {
		 super("Receiver is already exist with email or mobile number!");
	}
}
