package com.davidkoudela.confluence.controlledpm.context;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description: Common Context Builder
 *              Right now it is for testing purposes
 * Copyright (C) 2016 David Koudela
 *
 * @author dkoudela
 * @since 2016-10-05
 */
public class ControlledPMContextBuilder {
    public static List<ControlledPMContextParameter> buildContext() {
        List<ControlledPMContextParameter> parameters = new ArrayList<ControlledPMContextParameter>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        ControlledPMContextParameter controlledPMContextParameter = new ControlledPMContextParameter();
        controlledPMContextParameter.setIdentifier("currentDate");
        controlledPMContextParameter.setValue("<time datetime=\"" + dateFormat.format(date) + "\" />");
        controlledPMContextParameter.setRepresentation("storage");
        parameters.add(controlledPMContextParameter);
        return parameters;
    }
}
