package com.springprojects.rabbitmqtest.sender;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

	  private final static String QUEUE_NAME = "hello";

	  public static void main(String[] argv) throws Exception {
		  
		  
		  ConnectionFactory factory = new ConnectionFactory();
		  factory.setHost("localhost");
		  try (Connection connection = factory.newConnection();
		       Channel channel = connection.createChannel()) {

			  
			  channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			  String message = "Hello World 4!";
			  channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			  System.out.println(" [x] Sent '" + message + "'");
		  }
	  }

		  
}
