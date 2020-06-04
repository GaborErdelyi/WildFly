package org.jboss.samples.webservices;

public class ColorQueueProxy implements org.jboss.samples.webservices.ColorQueue {
  private String _endpoint = null;
  private org.jboss.samples.webservices.ColorQueue colorQueue = null;
  
  public ColorQueueProxy() {
    _initColorQueueProxy();
  }
  
  public ColorQueueProxy(String endpoint) {
    _endpoint = endpoint;
    _initColorQueueProxy();
  }
  
  private void _initColorQueueProxy() {
    try {
      colorQueue = (new org.jboss.samples.webservices.ColorQueueServiceLocator()).getColorQueuePort();
      if (colorQueue != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)colorQueue)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)colorQueue)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (colorQueue != null)
      ((javax.xml.rpc.Stub)colorQueue)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.jboss.samples.webservices.ColorQueue getColorQueue() {
    if (colorQueue == null)
      _initColorQueueProxy();
    return colorQueue;
  }
  
  public boolean sendColor(java.lang.String arg0) throws java.rmi.RemoteException{
    if (colorQueue == null)
      _initColorQueueProxy();
    return colorQueue.sendColor(arg0);
  }
  
  
}