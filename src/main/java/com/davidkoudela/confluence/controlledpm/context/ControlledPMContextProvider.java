package com.davidkoudela.confluence.controlledpm.context;

import com.atlassian.confluence.plugins.createcontent.api.contextproviders.AbstractBlueprintContextProvider;
import com.atlassian.confluence.plugins.createcontent.api.contextproviders.BlueprintContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author dkoudela
 * @since 2016-03-17
 */
public class ControlledPMContextProvider extends AbstractBlueprintContextProvider {
    @Override
    protected BlueprintContext updateBlueprintContext(BlueprintContext blueprintContext) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        //blueprintContext.put("currentDate", "<time datetime=\"" + dateFormat.format(date) + "\" />");
        blueprintContext.put("currentDate", dateFormat.format(date));
        return blueprintContext;
    }
}
