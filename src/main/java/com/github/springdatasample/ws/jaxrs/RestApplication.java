package com.github.springdatasample.ws.jaxrs;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

@ApplicationPath("/rest")
public class RestApplication extends Application {

    // ======================================
    // =             Attributes             =
    // ======================================

    private final Set<Class<?>> classes;

    // ======================================
    // =            Constructors            =
    // ======================================

    public RestApplication() {
      HashSet<Class<?>> c = new HashSet<>();
      c.add(JaxRsDealResource.class);

      c.add(JacksonJsonProvider.class);

      classes = Collections.unmodifiableSet(c);
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    @Override
    public Set<Class<?>> getClasses() {
      return classes;
    }
}
