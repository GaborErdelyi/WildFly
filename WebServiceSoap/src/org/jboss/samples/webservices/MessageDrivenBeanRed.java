package org.jboss.samples.webservices;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name = "MessageDrivenBeanRed", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/colorQueue"),
		@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "color = 'RED'") })
@TransactionManagement(value = TransactionManagementType.CONTAINER)
@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
public class MessageDrivenBeanRed implements MessageListener {
	int counter = 0;

	public void onMessage(Message message) {
				
		try {

			if (++counter >= 10) {
				String color = ((TextMessage)message).getText();
				MessageSender.sendMessage("stat", "10 '" + color + "' messages has been processed", "queue/colorStatistics");
				
				counter = 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}