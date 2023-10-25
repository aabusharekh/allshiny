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

import eu.openanalytics.containerproxy.model.spec.ISpecExtension;
import eu.openanalytics.containerproxy.spec.expression.SpecExpressionContext;
import eu.openanalytics.containerproxy.spec.expression.SpecExpressionResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KubernetesSpecExtension1 implements ISpecExtension {

    String id;

    String kubernetesPodPatches;

    public KubernetesSpecExtension1() {
    }

    public KubernetesSpecExtension1(String id, String kubernetesPodPatches) {
        this.id = id;
        this.kubernetesPodPatches = kubernetesPodPatches;
    }

    List<String> kubernetesAdditionalManifests;

    List<String> kubernetesAdditionalPersistentManifests;

    @Override
    public KubernetesSpecExtension1 firstResolve(SpecExpressionResolver resolver, SpecExpressionContext context) {
        return this;
    }

    @Override
    public KubernetesSpecExtension1 finalResolve(SpecExpressionResolver resolver, SpecExpressionContext context) {
        this.kubernetesAdditionalManifests = this.getKubernetesAdditionalManifests().stream().map(m -> resolver.evaluateToString(m, context)).collect(Collectors.toList());
        this.kubernetesAdditionalPersistentManifests = this.getKubernetesAdditionalPersistentManifests().stream().map(m -> resolver.evaluateToString(m, context)).collect(Collectors.toList());
        this.kubernetesPodPatches = resolver.evaluateToString(kubernetesPodPatches, context);
        return this;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getKubernetesPodPatches() {
        return kubernetesPodPatches;
    }

    public List<String> getKubernetesAdditionalManifests() {
        if (this.kubernetesAdditionalManifests == null) {
            this.kubernetesAdditionalManifests = new ArrayList<>();
        }
        return kubernetesAdditionalManifests;
    }

    public List<String> getKubernetesAdditionalPersistentManifests() {
        if (this.kubernetesAdditionalPersistentManifests == null) {
            this.kubernetesAdditionalPersistentManifests = new ArrayList<>();
        }
        return kubernetesAdditionalPersistentManifests;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public void setKubernetesPodPatches(String kubernetesPodPatches) {
        this.kubernetesPodPatches = kubernetesPodPatches;
    }

    public void setKubernetesAdditionalManifests(List<String> kubernetesAdditionalManifests) {
        this.kubernetesAdditionalManifests = kubernetesAdditionalManifests;
    }

    public void setKubernetesAdditionalPersistentManifests(List<String> kubernetesAdditionalPersistentManifests) {
        this.kubernetesAdditionalPersistentManifests = kubernetesAdditionalPersistentManifests;
    }

}
