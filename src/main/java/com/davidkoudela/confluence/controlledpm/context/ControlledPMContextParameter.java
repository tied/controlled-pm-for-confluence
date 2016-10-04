package com.davidkoudela.confluence.controlledpm.context;

/**
 * Description: Context parameter for Cloud web service
 *              Right now it is for testing purposes
 * Copyright (C) 2016 David Koudela
 *
 * @author dkoudela
 * @since 2016-10-04
 */
public class ControlledPMContextParameter {
    private String identifier;
    private String value;
    private String representation;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRepresentation() {
        return representation;
    }

    public void setRepresentation(String representation) {
        this.representation = representation;
    }
}
