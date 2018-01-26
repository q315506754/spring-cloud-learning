package com.jiangli.spring.cloud.learning.jax.test.main;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/hello2")
public class MyEndpoint2 {

    public MyEndpoint2() {
        System.out.println("EndpointEndpointEndpointEndpointEndpointEndpointEndpoint");
    }

    /**
     * http://localhost:8080/hello2
     * @return
     */
    @GET
    public String message() {
        return "Hello2";
    }

}