package com.learncamel.route.rest;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by z001qgd on 7/11/17.
 */
public class RestRoute2 extends RouteBuilder {

    public void configure() throws Exception {

        from("direct:restCall")
                .to("log:?level=INFO&showBody=true")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .setHeader(Exchange.HTTP_URI, simple("https://restcountries.eu/rest/v2/alpha/USA"))
                .to("https://restcountries.eu/rest/v2/alpha/USA")
                .to("log:?level=INFO&showBody=true");


    }
}