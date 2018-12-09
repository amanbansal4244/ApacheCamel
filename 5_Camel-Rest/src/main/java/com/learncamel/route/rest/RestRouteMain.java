package com.learncamel.route.rest;
import org.apache.camel.CamelContext;
//import com.learncamel.routes.jdbc.InsertProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import com.learncamel.processor.CamelDirectExampleProcessor;

/**
 * Created by z001qgd on 7/11/17.
 */
public class RestRouteMain  {

	public static void main(String[] args) {
		CamelContext context= new DefaultCamelContext();

		try{
			context.addRoutes(new RouteBuilder() {
				public void configure() throws Exception {

					from("direct:restCall")
					.to("log:?level=INFO&showBody=true")
					.setHeader(Exchange.HTTP_METHOD, constant("GET"))
					.setHeader(Exchange.HTTP_URI, simple("http://restcountries.eu/rest/v2/alpha/USA"))
					//.process(new RestRouteProcessor())
					.to("http://restcountries.eu/rest/v2/alpha/USA").convertBodyTo(String.class)
                    .log("The REST COUNTRIES api response is ${body}");
					//.process(new RestRouteProcessor())
					//.to("log:?level=INFO&showBody=true");
				}

			});

			context.start(); // we have to start the CamelContext.
			Thread.sleep(5000);
			context.stop();

		}catch(Exception e){
			System.out.println("Inside Exception : " + e);
		}

	}
}