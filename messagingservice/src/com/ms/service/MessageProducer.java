package com.ms.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;
import com.ms.model.Constants;
import com.ms.model.Message;
import com.ms.model.MessageValidator;

/**
 * <h1>Message Producer</h1> Message produc
 * @author Rahul Mahajan
 * @version 1.0
 * @since 07-28-2017
 */
@Path("/message")
public class MessageProducer {
	
	/**
	 * Adds the message.
	 *
	 * @param data the data
	 * @return the response
	 */
	@POST
	@Path("/addMessage")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMessage(String data){
			Gson  gson = new Gson();  
			Status status = null;
			Response response = null;
			Message message= gson.fromJson(data, Message.class);
			if(MessageValidator.isValidMessage(message)){
				String responseMessage= MessagingServiceSystem.getInstance().addMessage(message);
				status = Status.OK;
				response =Response.status(status).entity(responseMessage).build();
			}
			else{
				status = Status.NOT_ACCEPTABLE;
				response =Response.status(status).entity(Constants.INVALID_REQUEST).build();
			}
			
			return response;
	}
	
	/**
	 * Retrieve the message by message type.
	 *
	 * @param messageType the message type
	 * @return the string
	 */
	@GET
	@Path("/getMessage/{messageType}")
	@Produces(MediaType.TEXT_PLAIN)
	public String pollMessage(@PathParam("messageType") String messageType){
		
		Message responseMessage= MessagingServiceSystem.getInstance().pollMessageByType(messageType);
		if(responseMessage!=null)
			return "Message :"+responseMessage.getMessageDescription()+"  Added In Queue on Time:"+responseMessage.getTimestamp();
		else
			return "Message is not available in queue for requested message type";
	}
 
}
