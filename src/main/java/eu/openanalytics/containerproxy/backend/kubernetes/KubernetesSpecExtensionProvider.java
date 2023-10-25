/**
 * ContainerProxy
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
package eu.openanalytics.containerproxy.backend.kubernetes;

import eu.openanalytics.containerproxy.spec.IProxySpecProvider;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "proxy")
public class KubernetesSpecExtensionProvider {// extends AbstractSpecExtensionProvider<KubernetesSpecExtension> {

    private List<KubernetesSpecExtension1> specs;

    @Autowired
    private IProxySpecProvider proxySpecProvider;

    @PostConstruct
    public void postInit() {
        if (specs != null) {
            specs.forEach(specExtension -> {
                System.err.println(specExtension.getId());
                proxySpecProvider.getSpec(specExtension.getId()).addSpecExtension(specExtension);
            });
        }
    }

    public void setSpecs(List<KubernetesSpecExtension1> specs) {
        this.specs = specs;
    }

    public List<KubernetesSpecExtension1> getSpecs() {
        return specs;
    }
}
