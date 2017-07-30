package com.ms.test;

import com.ms.model.Message;
/**
 * <h1>Produce Messages</h1> This class used by test-cases to produce messages
 * This thread is created to test add message functionality for multi
 * threaded environment.
 * 
 * @author Rahul Mahajan
 * @version 1.0
 * @since 07-28-2017
 */
public class ProduceMessages implements Runnable {

	/** The message priority. */
	private int messagePriority;

	/**
	 * Instantiates a new produce messages.
	 *
	 * @param messagePriority the message priority
	 */
	public ProduceMessages(int messagePriority) {
		this.messagePriority = messagePriority;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			Message message = new Message("I love red color_added_" + i + "___" + Thread.currentThread().getName(),
					"red", this.messagePriority);
			TestUtility.addMessageClient(message);
		}
	}

}
