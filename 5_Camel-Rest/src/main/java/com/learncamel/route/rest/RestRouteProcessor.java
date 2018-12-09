package com.learncamel.route.rest;

import org.apache.camel.Exchange;

/**
 * Created by z001qgd on 6/10/17.
 */
public class RestRouteProcessor implements org.apache.camel.Processor {


    public void process(Exchange exchange) throws Exception {

        try{
        	System.out.println("In Processor");
            String response = (String) exchange.getIn().getBody();

            System.out.println("Response is : " + response);

            exchange.getIn().setBody(response);

        }catch (Exception e){
            System.out.println("Exception in processor is : " + e);
        }

    }
}
