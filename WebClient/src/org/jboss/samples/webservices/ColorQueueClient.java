package org.jboss.samples.webservices;

import java.util.Random;

public class ColorQueueClient {

	public static void main(String[] args) throws Exception {
		System.setProperty("org.apache.commons.logging.LogFactory", "org.apache.commons.logging.impl.LogFactoryImpl");
		
		ColorQueueService cqs = new ColorQueueServiceLocator();
		ColorQueue cq = cqs.getColorQueuePort();
	
		/* Generate and send color */
		for (int i = 0; i < 100; i++) {
			Random rand = new Random();
			int num = rand.nextInt(3);
			
			String color = "";

			switch (num) {
				
				case 0:
					color = "RED";
					break;
					
				case 1:
					color = "BLUE";
					break;
					
				case 2:
					color = "GREEN";
					break;
			}
			
			/* Send color to the queue */
			if (!cq.sendColor(color)) {
				System.out.println("Message was not sent, retrying...");
				
				if (i > 0) {
					i--;
				}	
			}	
			
			/* Sleep 200 ms */
			Thread.sleep(200);
		}
	}
}
