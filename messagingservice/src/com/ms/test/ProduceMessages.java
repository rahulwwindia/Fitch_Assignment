package com.ms.test;

import com.ms.model.Message;

public class ProduceMessages implements Runnable {

	private int messagePriority;

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
