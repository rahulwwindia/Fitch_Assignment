package com.ms.test;

/**
 * <h1>Consume Messages</h1> This class used by test-cases to consume messages
 * This thread is created to test message consume functionality for multi
 * threaded environment.
 * 
 * @author Rahul Mahajan
 * @version 1.0
 * @since 07-28-2017
 */

public class ConsumeMessages implements Runnable {

	/** The message type. */
	private String messageType;

	public ConsumeMessages(String messageType) {
		this.messageType = messageType;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			TestUtility.getMessageClinet(messageType);
		}
	}

}
