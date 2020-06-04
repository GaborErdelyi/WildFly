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

@MessageDriven(name = "MessageDrivenBeanStatistics", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/colorStatistics") })
@TransactionManagement(value = TransactionManagementType.CONTAINER)
@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
public class MessageDrivenBeanStatistics implements MessageListener {

	public void onMessage(Message message) {
		
		try {
			
			String text = ((TextMessage)message).getText();
			System.out.println(text);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}