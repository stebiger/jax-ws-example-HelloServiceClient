package de.brainoverload;


import de.brainoverload.webservices.helloservice.Hello;
import de.brainoverload.webservices.helloservice.HelloService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.xml.ws.WebServiceRef;

/**
 * Created by stefan on 29.01.17.
 */
@Named
@RequestScoped
public class HelloServiceClient {

    @WebServiceRef(wsdlLocation = "http://localhost:8080/HelloService/HelloService?wsdl")
    private HelloService service;

    public String callHello() {
        Hello helloPort = service.getHelloPort();
        return helloPort.sayHello(" JSF2 View!");
    }

    public String callWSSayHello(String name) {
        Hello helloPort = service.getHelloPort();
        return helloPort.sayHello(name);
    }
}
