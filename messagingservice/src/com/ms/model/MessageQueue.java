package com.ms.model;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
/**
 * Initial message queue with default values.
 * 
 * @author Rahul Mahajan
 * @version 1.0
 * @since 07-28-2017
 *
 */
public class MessageQueue {

	/** The message queue. */
	public static Map<String, Queue<Message>> messageQueue;
	
	static{
		messageQueue = new ConcurrentHashMap<String, Queue<Message>>();
		messageQueue.put("red", new 	PriorityQueue<Message>(10,new MessageComparator()));
		messageQueue.put("yellow", new PriorityQueue<Message>(10,new MessageComparator()));
		messageQueue.put("blue", new PriorityQueue<Message>(10,new MessageComparator()));
	}
}
