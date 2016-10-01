package com.davidkoudela.confluence.controlledpm.cloud.connect;

import javax.activation.DataSource;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.*;
import javax.xml.ws.http.HTTPBinding;
import java.io.StringReader;

/**
 * Description: Web Service
 *              Right now it is for testing purposes
 * Copyright (C) 2016 David Koudela
 *
 * @author dkoudela
 * @since 2016-09-30
 */
@WebServiceProvider
@ServiceMode(value = Service.Mode.MESSAGE)
public class ControlledPMWebServer implements Provider<SOAPMessage> {
    public SOAPMessage invoke(SOAPMessage request) {
        //StreamSource streamSource = new StreamSource(new StringReader("<p>Hello There!</p>"));
        //return streamSource;
        try {
            MessageFactory mf = MessageFactory.newInstance();
            SOAPMessage response = mf.createMessage();
            response.setContentDescription("text/plain");
            SOAPBody respBody = response.getSOAPBody();
            respBody.addTextNode("<p>Hello There!</p>");
            response.saveChanges();
            return response;
        } catch (SOAPException e) {
            e.printStackTrace();
        }
        return null;
    }
}
