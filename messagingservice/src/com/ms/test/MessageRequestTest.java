package com.ms.test;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.ms.model.Message;

public class MessageRequestTest {

	final static Logger logger = Logger.getLogger(MessageRequestTest.class);
	
	@Test
	@Ignore
	public void getMessage() {
		logger.info("get message rest service called ");
		TestUtility.getMessageClinet("red");
	}

	@Test
	@Ignore
	public void addMessage() {
		logger.info("get message rest service called ");
		Message message = new Message("Red is the ultimate cure for sadness.", "red", 1);
		TestUtility.addMessageClient(message);
	}

	@Test
	@Ignore
	public void consumeProduceMultiThreadMessages() {

		Thread thread1 = new Thread(new ProduceMessages(1));
		Thread thread3 = new Thread(new ProduceMessages(1));
		Thread thread2 = new Thread(new ConsumeMessages("red"));
		//thread1.start();
		thread2.start();
		//thread3.start();

		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			logger.error("Sorry, thread got interrupted!", e);
		}
	}

	
	@Test
	@Ignore
	public void consumeProducePriorityThreadTest() {

		Thread thread1 = new Thread(new ProduceMessages(1));
		Thread thread3 = new Thread(new ProduceMessages(2));
		Thread thread2 = new Thread(new ConsumeMessages("red"));
		thread1.start();
		thread2.start();
		thread3.start();

		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
