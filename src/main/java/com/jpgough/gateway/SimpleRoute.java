package com.jpgough.gateway;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        //Simple Routing to the Attendees Service
        from("jetty:http://0.0.0.0:8082/attendees?matchOnUriPrefix=true")
                .to("http4://attendees:8080?bridgeEndpoint=true&throwExceptionOnFailure=true");

        //Simple Routing to the User Details Service
        from("jetty:http://0.0.0.0:8082/users?matchOnUriPrefix=true")
                .to("http4://user-details:8081?bridgeEndpoint=true&throwExceptionOnFailure=true");
    }

}
