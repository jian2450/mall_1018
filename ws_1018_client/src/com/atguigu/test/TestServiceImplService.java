
package com.atguigu.test;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "TestServiceImplService", targetNamespace = "http://test.atguigu.com/", wsdlLocation = "http://192.168.1.102:1234/ws?wsdl")
public class TestServiceImplService
    extends Service
{

    private final static URL TESTSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException TESTSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName TESTSERVICEIMPLSERVICE_QNAME = new QName("http://test.atguigu.com/", "TestServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.1.102:1234/ws?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TESTSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        TESTSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public TestServiceImplService() {
        super(__getWsdlLocation(), TESTSERVICEIMPLSERVICE_QNAME);
    }

    public TestServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TESTSERVICEIMPLSERVICE_QNAME, features);
    }

    public TestServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, TESTSERVICEIMPLSERVICE_QNAME);
    }

    public TestServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TESTSERVICEIMPLSERVICE_QNAME, features);
    }

    public TestServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TestServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns TestServiceImpl
     */
    @WebEndpoint(name = "TestServiceImplPort")
    public TestServiceImpl getTestServiceImplPort() {
        return super.getPort(new QName("http://test.atguigu.com/", "TestServiceImplPort"), TestServiceImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TestServiceImpl
     */
    @WebEndpoint(name = "TestServiceImplPort")
    public TestServiceImpl getTestServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://test.atguigu.com/", "TestServiceImplPort"), TestServiceImpl.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TESTSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw TESTSERVICEIMPLSERVICE_EXCEPTION;
        }
        return TESTSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
