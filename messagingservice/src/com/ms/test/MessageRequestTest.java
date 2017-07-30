package com.ms.test;

import org.junit.Ignore;
import org.junit.Test;

import com.ms.model.Message;

/**
 * <h1>Message Request Test</h1> MessageRequestTest class has all the testcases
 * to test the messaging services restful webservice.
 * 
 * @author Rahul Mahajan
 * @version 1.0
 * @since 07-28-2017
 */
public class MessageRequestTest {


	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	@Test
	//@Ignore
	public void getMessage() {
		TestUtility.getMessageClinet("red");
	}

	/**
	 * Adds the message.
	 */
	@Test
	//@Ignore
	public void addMessage() {
		Message message = new Message("Red is the ultimate cure for sadness.", "red", 1);
		TestUtility.addMessageClient(message);
	}

	/**
	 * Consume produce multi thread messages,test the application in multi
	 * thread for same priority This test check response message should poll in
	 * FIFO order.
	 */
	@Test
	@Ignore
	public void consumeProduceMultiThreadMessages() {

		Thread thread1 = new Thread(new ProduceMessages(1));
		Thread thread3 = new Thread(new ProduceMessages(1));
		Thread thread2 = new Thread(new ConsumeMessages("red"));
		// thread1.start();
		thread2.start();
		// thread3.start();

		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Consume produce priority thread test, to test the application same time
	 * with multiple thread for different priority.
	 */
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
