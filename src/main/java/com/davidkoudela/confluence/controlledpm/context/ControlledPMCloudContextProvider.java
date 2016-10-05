package com.davidkoudela.confluence.controlledpm.context;

import com.google.gson.GsonBuilder;

import java.util.List;

/**
 * Description: Providing context information for the Cloud ControlledPM blueprints.
 *              Right now it is for testing purposes
 * Copyright (C) 2016 David Koudela
 *
 * @author dkoudela
 * @since 2016-10-05
 * Created by dkoudela on 05 Oct 16.
 */
public class ControlledPMCloudContextProvider {
    public static String retriveContext() {
        List<ControlledPMContextParameter> parameters = ControlledPMContextBuilder.buildContext();
        GsonBuilder gsonBuilder = new GsonBuilder();
        String json = gsonBuilder.disableHtmlEscaping().create().toJson(parameters);
        return json;
    }
}
