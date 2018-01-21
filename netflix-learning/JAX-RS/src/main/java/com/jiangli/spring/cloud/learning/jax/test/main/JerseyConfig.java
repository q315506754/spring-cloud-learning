package com.jiangli.spring.cloud.learning.jax.test.main;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(MyEndpoint.class);
    }

}