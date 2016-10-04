package com.davidkoudela.confluence.controlledpm.context;

import com.atlassian.confluence.plugins.createcontent.api.contextproviders.AbstractBlueprintContextProvider;
import com.atlassian.confluence.plugins.createcontent.api.contextproviders.BlueprintContext;
import com.google.gson.GsonBuilder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Description: Extension of {@link AbstractBlueprintContextProvider} providing context information for the ControlledPM blueprints.
 * Copyright (C) 2015 David Koudela
 *
 * @author dkoudela
 * @since 2016-03-17
 */
public class ControlledPMContextProvider extends AbstractBlueprintContextProvider {
    @Override
    protected BlueprintContext updateBlueprintContext(BlueprintContext blueprintContext) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        blueprintContext.put("currentDate", "<time datetime=\"" + dateFormat.format(date) + "\" />");
        return blueprintContext;
    }

    public static String retriveUpdatedBlueprintContext() {
        List<ControlledPMContextParameter> parameters = new ArrayList<ControlledPMContextParameter>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        ControlledPMContextParameter controlledPMContextParameter = new ControlledPMContextParameter();
        controlledPMContextParameter.setIdentifier("currentDate");
        controlledPMContextParameter.setValue("<time datetime=\"" + dateFormat.format(date) + "\" />");
        controlledPMContextParameter.setRepresentation("storage");
        parameters.add(controlledPMContextParameter);
        GsonBuilder gsonBuilder = new GsonBuilder();
        String json = gsonBuilder.disableHtmlEscaping().create().toJson(parameters);
        return json;
    }
}
