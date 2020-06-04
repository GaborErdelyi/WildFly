package org.jboss.samples.webservices;

import java.util.Hashtable;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MessageSender {
	
	public static Boolean sendMessage(String property, String msg, String topic)
	{
		InitialContext initialContext = null;
		
		try {
			/* Setup connection */
			initialContext = getInitialContext();
			QueueConnectionFactory qconFactory = (QueueConnectionFactory) initialContext
					.lookup("jms/RemoteConnectionFactory");
			QueueConnection qcon = qconFactory.createQueueConnection("user", "passwd");
			QueueSession qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = (Queue) initialContext.lookup(topic);
			QueueSender qsender = qsession.createSender(queue);
			qcon.start();

			/* Send message */
			TextMessage txtMsg = qsession.createTextMessage();
			txtMsg.setStringProperty(property, msg);
			qsender.send(txtMsg);

			/* Close connection */
			qsender.close();
			qsession.close();
			qcon.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());		
			
			return false;
		}
		
	    return true;
	}
	
	private static InitialContext getInitialContext() throws NamingException {
		Hashtable<Object, Object> env = new Hashtable<Object, Object>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		env.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:9990");
		env.put("jboss.naming.client.ejb.context", false);
		env.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		
		return new InitialContext(env);
	}
}
