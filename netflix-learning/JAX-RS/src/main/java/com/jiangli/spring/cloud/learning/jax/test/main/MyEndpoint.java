package com.jiangli.spring.cloud.learning.jax.test.main;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/hello")
public class MyEndpoint {

    public MyEndpoint() {
        System.out.println("EndpointEndpointEndpointEndpointEndpointEndpointEndpoint");
    }

    /**
     * http://localhost:8080/hello
     * @return
     */
    @GET
    public String message() {
        return "Hello";
    }

}