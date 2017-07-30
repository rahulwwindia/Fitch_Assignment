package com.ms.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.ms.model.Message;

/**
 * <h1>Test Utility</h1> TestUtility use to test the messaging web service.
 * 
 * @author Rahul Mahajan
 * @version 1.0
 * @since 07-28-2017
 */
public class TestUtility {

	final static Logger logger = Logger.getLogger(TestUtility.class);

	/**
	 * Consume restful web service and add the message in the queue.
	 *
	 * @param message
	 *            the message
	 */
	public static void addMessageClient(Message message) {

		try {
			logger.info("Consuming add message restful webservice");
			URL url = new URL("http://localhost:8080/messagingservice/rest/message/addMessage");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			Gson gson = new Gson();
			String input = gson.toJson(message);

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() !=200) {
				logger.error("Failed : HTTP error code : " + conn.getResponseCode(),
						new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode()));
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;

			while ((output = br.readLine()) != null) {
				logger.info("Response :" + output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			logger.error("Invalid URL to request webservice", e);

		} catch (IOException e) {

			logger.error("Sorry, something went wrong!", e);

		}
	}

	/**
	 * Consume restful webservice to get the message from queue by message type
	 *
	 * @param messageType
	 *            the message type
	 */
	public static void getMessageClinet(String messageType) {
		URL url;
		try {
			url = new URL("http://localhost:8080/messagingservice/rest/message/getMessage/" + messageType);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			if (conn.getResponseCode() != 200) {
				logger.error("Failed : HTTP error code : " + conn.getResponseCode(),
						new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode()));
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			while ((output = br.readLine()) != null) {
				logger.info("Response :" + output);
			}
			conn.disconnect();
		} catch (IOException e) {
			logger.error("Sorry, something went wrong!", e);
		}
	}

}
