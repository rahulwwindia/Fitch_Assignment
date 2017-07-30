package com.ms.model;
/**
*<h1>Message</h1>
* @author Rahul Mahajan
* @version 1.0
* @since 07-28-2017
*/
public class Message {

	
	/** The message description. */
	private String messageDescription;
	
	/** The message type. */
	private String messageType;
	
	/** The message priority. */
	private int messagePriority;
	
	/** The timestamp. */
	private long timestamp;

	/**
	 * Instantiates a new message.
	 *
	 * @param messageDescription the message description
	 * @param messageType the message type
	 * @param messagePriority the message priority
	 */
	public Message(String messageDescription, String messageType, int messagePriority) {

		this.messageDescription = messageDescription;
		this.messageType = messageType;
		this.messagePriority = messagePriority;
	}

	/**
	 * Gets the message description.
	 *
	 * @return the message description
	 */
	public String getMessageDescription() {
		return messageDescription;
	}

	/**
	 * Sets the message description.
	 *
	 * @param messageDescription the new message description
	 */
	public void setMessageDescription(String messageDescription) {
		this.messageDescription = messageDescription;
	}

	/**
	 * Gets the message type.
	 *
	 * @return the message type
	 */
	public String getMessageType() {
		return messageType;
	}

	/**
	 * Sets the message type.
	 *
	 * @param messageType the new message type
	 */
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	/**
	 * Gets the message priority.
	 *
	 * @return the message priority
	 */
	public int getMessagePriority() {
		return messagePriority;
	}

	/**
	 * Sets the message priority.
	 *
	 * @param messagePriority the new message priority
	 */
	public void setMessagePriority(int messagePriority) {
		this.messagePriority = messagePriority;
	}

	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp the new timestamp
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((messageDescription == null) ? 0 : messageDescription.hashCode());
		result = prime * result + messagePriority;
		result = prime * result + ((messageType == null) ? 0 : messageType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (messageDescription == null) {
			if (other.messageDescription != null)
				return false;
		} else if (!messageDescription.equals(other.messageDescription))
			return false;
		if (messagePriority != other.messagePriority)
			return false;
		if (messageType == null) {
			if (other.messageType != null)
				return false;
		} else if (!messageType.equals(other.messageType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Message [messageDescription=" + messageDescription + ", messageType=" + messageType
				+ ", messagePriority=" + messagePriority + ", timestamp=" + timestamp + "]";
	}

}
