package com.ms.service;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

import javax.swing.plaf.synth.SynthSpinnerUI;

import com.ms.model.Constants;
import com.ms.model.Message;
import com.ms.model.MessageQueue;
import com.ms.model.MessageValidator;

/**
 * <h1>Messaging Service System</h1> MessagingServiceSystem class use to produce
 * and consume messages from priority queue, it accept the message request that
 * consist of message string, type and priority. Messages consumer request will
 * retrieve the messages based on message type and priority. Message retriever
 * order will be MessageType, MessagePriority and FIFO
 * 
 * @author Rahul Mahajan
 * @version 1.0
 * @since 07-28-2017
 *
 */
public class MessagingServiceSystem {
	
	public static MessagingServiceSystem serviceInstance ;


	protected MessagingServiceSystem() {
	}
 
	public static MessagingServiceSystem getInstance() {
		if (serviceInstance == null) {
			synchronized (MessagingServiceSystem.class) {
				if (serviceInstance == null) {
					serviceInstance = new MessagingServiceSystem();
				}
			}
		}
		return serviceInstance;
	}
	
	/**
	 * Add message to the priority queue by message type.
	 * 
	 * @param message
	 * @return response message
	 */
	public String addMessage(Message message) {
		String responseString = "";
		Map<String, Queue<Message>> messageQueue = MessageQueue.messageQueue;
		if (MessageValidator.isValidMessage(message)) {
			Queue<Message> messagesByType = messageQueue.get(message.getMessageType());
			if (messagesByType != null) {
				/**
				 * set the timestamp of message object, this the the time when
				 * message got added in priority queue. This time is used to
				 * manage FIFO order in queue for same priority messages.
				 */
				synchronized (this) {
					message.setTimestamp(System.nanoTime());
					messagesByType.offer(message);

				}
				responseString = Constants.ADD_SUCCESS+ " Message :"+message.getMessageDescription() +"  Added In Queue on Time:"+message.getTimestamp();
			} else {
				responseString = Constants.QUEUE_NOT_AVAILABLE;
			}
		} else {
			responseString = Constants.INVALID_REQUEST;
		}
		return responseString;
	}

	/**
	 * Retrieve the message from priority queue based on message type,poll
	 * method of queue retrieve the head element and delete it from queue.
	 * 
	 * @param type
	 * @return message
	 */
	public Message pollMessageByType(String type) {
		Map<String,Queue<Message>> messageQueue = MessageQueue.messageQueue;
		if(type!=null && !type.isEmpty()){
			synchronized (messageQueue) {
				Queue<Message> messagesByType = messageQueue.get(type);
			if(messagesByType !=null && !messagesByType.isEmpty()){
				synchronized (this) {
					return messagesByType.poll();
				}
					
			}else{
				return null;
			}
		}
		}
		return null;
	}

}
