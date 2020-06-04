/**
 * ColorQueueService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.jboss.samples.webservices;

public interface ColorQueueService extends javax.xml.rpc.Service {
    public java.lang.String getColorQueuePortAddress();

    public org.jboss.samples.webservices.ColorQueue getColorQueuePort() throws javax.xml.rpc.ServiceException;

    public org.jboss.samples.webservices.ColorQueue getColorQueuePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
