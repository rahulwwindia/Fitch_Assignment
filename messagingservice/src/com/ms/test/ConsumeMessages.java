package com.ms.test;

public class ConsumeMessages implements Runnable{
	
	private String messageType;
	
	
	

	public ConsumeMessages(String messageType) {
		this.messageType = messageType;
	}




	@Override
	public void run() {
	 for(int i=0; i<5; i++){
		TestUtility.getMessageClinet(messageType);
	 }
	}

}
