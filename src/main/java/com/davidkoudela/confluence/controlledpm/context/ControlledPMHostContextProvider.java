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
public class ControlledPMHostContextProvider extends AbstractBlueprintContextProvider {
    @Override
    protected BlueprintContext updateBlueprintContext(BlueprintContext blueprintContext) {
        for (ControlledPMContextParameter parameter : ControlledPMContextBuilder.buildContext()) {
            blueprintContext.put(parameter.getIdentifier(), parameter.getValue());
        }
        return blueprintContext;
    }

}
