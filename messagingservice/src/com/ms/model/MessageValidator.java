package com.ms.model;

import java.util.Arrays;

/**
 * <h1>Message Validator</h1> Validate the requested message on the basis of
 * below criteria 
 * message type (valid values: ['red', 'yellow', 'blue']) 
 * message priority (valid values: [1, 2, 3])
 * 
 * @author Rahul Mahajan
 * @version 1.0
 * @since 07-28-2017
 *
 */
public class MessageValidator {

	public static String[] MESSAGE_TYPE = { "red", "yellow", "blue" };
	public static Integer[] MESSAGE_PRIORITY = { 1, 2, 3 };

	/**
	 * Check for valid message.
	 * @param message
	 * @return boolean
	 */
	public static boolean isValidMessage(Message message) {
		if (message != null) {
			if (Arrays.asList(MESSAGE_TYPE).contains(message.getMessageType())
					&& Arrays.asList(MESSAGE_PRIORITY).contains(message.getMessagePriority())) {
				return true;
			}
		}
		return false;
	}
}
