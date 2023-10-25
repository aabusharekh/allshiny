/**
 * ShinyProxy
 *
 * Copyright (C) 2016-2023 Open Analytics
 *
 * ===========================================================================
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Apache License as published by
 * The Apache Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Apache License for more details.
 *
 * You should have received a copy of the Apache License
 * along with this program.  If not, see <http://www.apache.org/licenses/>
 */
package eu.openanalytics.shinyproxy;

import eu.openanalytics.containerproxy.model.spec.ISpecExtension;
import eu.openanalytics.containerproxy.spec.expression.SpecExpressionContext;
import eu.openanalytics.containerproxy.spec.expression.SpecExpressionResolver;
import eu.openanalytics.containerproxy.spec.expression.SpelField;
import eu.openanalytics.shinyproxy.runtimevalues.WebsocketReconnectionMode;

import java.util.Map;

public class ShinyProxySpecExtension1 implements ISpecExtension {

    String id;

    WebsocketReconnectionMode websocketReconnectionMode;

    Boolean shinyForceFullReload;

    SpelField.Integer maxInstances;// = new SpelField.Integer();

    Boolean hideNavbarOnMainPageLink;

    Boolean alwaysShowSwitchInstance;

    Boolean trackAppUrl;

    String templateGroup;

    Map<String, String> templateProperties;

    public ShinyProxySpecExtension1() {
    }

    public ShinyProxySpecExtension1(String id, WebsocketReconnectionMode websocketReconnectionMode, Boolean shinyForceFullReload, SpelField.Integer maxInstances, Boolean hideNavbarOnMainPageLink, Boolean alwaysShowSwitchInstance, Boolean trackAppUrl, String templateGroup, Map<String, String> templateProperties) {
        this.id = id;
        this.websocketReconnectionMode = websocketReconnectionMode;
        this.shinyForceFullReload = shinyForceFullReload;
        this.maxInstances = maxInstances;
        this.hideNavbarOnMainPageLink = hideNavbarOnMainPageLink;
        this.alwaysShowSwitchInstance = alwaysShowSwitchInstance;
        this.trackAppUrl = trackAppUrl;
        this.templateGroup = templateGroup;
        this.templateProperties = templateProperties;
    }

    @Override
    public ShinyProxySpecExtension1 firstResolve(SpecExpressionResolver resolver, SpecExpressionContext context) {
        return this;
    }

    @Override
    public ShinyProxySpecExtension1 finalResolve(SpecExpressionResolver resolver, SpecExpressionContext context) {
        return this;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public WebsocketReconnectionMode getWebsocketReconnectionMode() {
        return websocketReconnectionMode;
    }

    public Boolean getShinyForceFullReload() {
        return shinyForceFullReload;
    }

    public SpelField.Integer getMaxInstances() {
        if (this.maxInstances == null) {
            this.maxInstances = new SpelField.Integer();
        }
        return maxInstances;
    }

    public Boolean getHideNavbarOnMainPageLink() {
        return hideNavbarOnMainPageLink;
    }

    public Boolean getAlwaysShowSwitchInstance() {
        return alwaysShowSwitchInstance;
    }

    public Boolean getTrackAppUrl() {
        return trackAppUrl;
    }

    public String getTemplateGroup() {
        return templateGroup;
    }

    public Map<String, String> getTemplateProperties() {
        return templateProperties;
    }

    public void setWebsocketReconnectionMode(WebsocketReconnectionMode websocketReconnectionMode) {
        this.websocketReconnectionMode = websocketReconnectionMode;
    }

    public void setShinyForceFullReload(Boolean shinyForceFullReload) {
        this.shinyForceFullReload = shinyForceFullReload;
    }

    public void setMaxInstances(SpelField.Integer maxInstances) {
        this.maxInstances = maxInstances;
    }

    public void setHideNavbarOnMainPageLink(Boolean hideNavbarOnMainPageLink) {
        this.hideNavbarOnMainPageLink = hideNavbarOnMainPageLink;
    }

    public void setAlwaysShowSwitchInstance(Boolean alwaysShowSwitchInstance) {
        this.alwaysShowSwitchInstance = alwaysShowSwitchInstance;
    }

    public void setTrackAppUrl(Boolean trackAppUrl) {
        this.trackAppUrl = trackAppUrl;
    }

    public void setTemplateGroup(String templateGroup) {
        this.templateGroup = templateGroup;
    }

    public void setTemplateProperties(Map<String, String> templateProperties) {
        this.templateProperties = templateProperties;
    }

}
