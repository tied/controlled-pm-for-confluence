package com.davidkoudela.confluence.controlledpm.cloud.connect;

import javax.xml.ws.Endpoint;
import javax.xml.ws.http.HTTPBinding;

/**
 * Description: Cloud Connect Service
 *              Right now it is for testing purposes
 * Copyright (C) 2016 David Koudela
 *
 * @author dkoudela
 * @since 2016-09-16
 */
public class ControlledPMCloudConnectService {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World!");
        String address = "http://127.0.0.1:8080/";
        Endpoint.create(HTTPBinding.HTTP_BINDING, new ControlledPMWebServer()).publish(address);

        System.out.println("Service running at " + address);
        System.out.println("Type [CTRL]+[C] to quit!");

        Thread.sleep(Long.MAX_VALUE);
    }
}
