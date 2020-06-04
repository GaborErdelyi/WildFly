package org.jboss.samples.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService()
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ColorQueue {

	@WebMethod()
	public Boolean sendColor(String color) {

		/* Send message to the "colorQueue" topic */
		return MessageSender.sendMessage("color", color, "queue/colorQueue");
	}
}
