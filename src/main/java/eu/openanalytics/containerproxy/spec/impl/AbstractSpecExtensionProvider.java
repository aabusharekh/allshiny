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
// package eu.openanalytics.containerproxy.spec.impl;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import eu.openanalytics.containerproxy.model.spec.ISpecExtension;
// import eu.openanalytics.containerproxy.model.spec.ProxySpec;
// import eu.openanalytics.containerproxy.spec.IProxySpecProvider;

// import javax.annotation.PostConstruct;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;

// public class AbstractSpecExtensionProvider<T extends ISpecExtension> {

//     private static final Logger logger = LoggerFactory.getLogger(AbstractSpecExtensionProvider.class);

//     private List<T> specs;

//     @Autowired
//     private IProxySpecProvider proxySpecProvider;

//      @PostConstruct
//     public void postInit() {
//         if (specs != null) {
//             specs.forEach(specExtension -> {
//                 ProxySpec spec = proxySpecProvider.getSpec(specExtension.getId());
//                 if (spec != null) {
//                     spec.addSpecExtension(specExtension);
//                     logger.info("Successfully added specExtension to ProxySpec: id={}, displayName={}, description={}, logoURL={}",
//                             safeGet(spec.getId()), safeGet(spec.getDisplayName()), safeGet(spec.getDescription()), safeGet(spec.getLogoURL()));
//                 } else {
//                     logger.error("Spec is null for specExtension with ID: {}. SpecExtension details: id={}, displayName={}, description={}, logoURL={}",
//                             safeGet(specExtension.getId()), safeGet(specExtension.getDisplayName()), safeGet(specExtension.getDescription()), safeGet(specExtension.getLogoURL()));
//                 }
//             });
//         }
//     }

//     private String safeGet(String value) {
//         return value != null ? value : "null";
//     }

//     public void setSpecs(List<T> specs) {
//         this.specs = specs;
//     }

//     public List<T> getSpecs() {
//         return specs;
//     }

// }


package eu.openanalytics.containerproxy.spec.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import eu.openanalytics.containerproxy.model.spec.ISpecExtension;
import eu.openanalytics.containerproxy.model.spec.ProxySpec;
import eu.openanalytics.containerproxy.spec.IProxySpecProvider;

import javax.annotation.PostConstruct;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractSpecExtensionProvider<T extends ISpecExtension> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractSpecExtensionProvider.class);

    private List<T> specs;

    @Autowired
    private IProxySpecProvider proxySpecProvider;

    @PostConstruct
    public void postInit() {
        if (specs != null) {
            specs.forEach(specExtension -> {
                ProxySpec spec = proxySpecProvider.getSpec(specExtension.getId());
                if (spec != null) {
                    spec.addSpecExtension(specExtension);
                    logger.info("Successfully added specExtension to ProxySpec: id={}, displayName={}, description={}, logoURL={}",
                            safeGet(spec.getId()), safeGet(spec.getDisplayName()), safeGet(spec.getDescription()), safeGet(spec.getLogoURL()));
                } else {
                    logger.error("Spec is null for specExtension with ID: {}", safeGet(specExtension.getId()));
                }
            });
        }
    }

    private String safeGet(String value) {
        return value != null ? value : "null";
    }

    public void setSpecs(List<T> specs) {
        this.specs = specs;
    }

    public List<T> getSpecs() {
        return specs;
    }
}