package com.ms.model;

import java.util.Comparator;

/**
 * <h1>Message Comparator</h1> MessageComparator use to store the messages in a
 * queue on the basis of priority. comparator compare the priority of two object
 * and put the minimum priority message on the head of the queue. Also it is
 * uses timestamp to manage FIFO order for similar priority messages.
 * 
 * @author Rahul Mahajan
 * @version 1.0
 * @since 07-28-2017
 */
public class MessageComparator implements Comparator<Message> {
	/**
	 * Compare two Message objects on the basis of priority, If the priority for
	 * both the messages same, it uses timestamp to manage the FIFO order.
	 * 
	 * @param o1
	 *            message
	 * @param o2
	 *            message
	 * @return int
	 */
	@Override
	public int compare(Message o1, Message o2) {
		if (o1.getMessagePriority() == o2.getMessagePriority())
			return (int) (o1.getTimestamp() - o2.getTimestamp());
		else
			return o1.getMessagePriority() - o2.getMessagePriority();
	}

}
