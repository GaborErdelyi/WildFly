/**
 * ColorQueueServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.jboss.samples.webservices;

public class ColorQueueServiceLocator extends org.apache.axis.client.Service implements org.jboss.samples.webservices.ColorQueueService {

    public ColorQueueServiceLocator() {
    }


    public ColorQueueServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ColorQueueServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ColorQueuePort
    private java.lang.String ColorQueuePort_address = "http://localhost:8080/WebServiceSoap/ColorQueue";

    public java.lang.String getColorQueuePortAddress() {
        return ColorQueuePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ColorQueuePortWSDDServiceName = "ColorQueuePort";

    public java.lang.String getColorQueuePortWSDDServiceName() {
        return ColorQueuePortWSDDServiceName;
    }

    public void setColorQueuePortWSDDServiceName(java.lang.String name) {
        ColorQueuePortWSDDServiceName = name;
    }

    public org.jboss.samples.webservices.ColorQueue getColorQueuePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ColorQueuePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getColorQueuePort(endpoint);
    }

    public org.jboss.samples.webservices.ColorQueue getColorQueuePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.jboss.samples.webservices.ColorQueueServiceSoapBindingStub _stub = new org.jboss.samples.webservices.ColorQueueServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getColorQueuePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setColorQueuePortEndpointAddress(java.lang.String address) {
        ColorQueuePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.jboss.samples.webservices.ColorQueue.class.isAssignableFrom(serviceEndpointInterface)) {
                org.jboss.samples.webservices.ColorQueueServiceSoapBindingStub _stub = new org.jboss.samples.webservices.ColorQueueServiceSoapBindingStub(new java.net.URL(ColorQueuePort_address), this);
                _stub.setPortName(getColorQueuePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ColorQueuePort".equals(inputPortName)) {
            return getColorQueuePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservices.samples.jboss.org/", "ColorQueueService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservices.samples.jboss.org/", "ColorQueuePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ColorQueuePort".equals(portName)) {
            setColorQueuePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
