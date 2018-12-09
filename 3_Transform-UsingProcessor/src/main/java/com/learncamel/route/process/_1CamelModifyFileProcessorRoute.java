package com.learncamel.route.process;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import com.learncamel.processor.CamelFileExampleProcessor;

/**
 * REading the file and changing the , to : 
 * E.g.:
 * 	123,dilip,12JAN2017 to 123:dilip:12JAN2017
 */
public class _1CamelModifyFileProcessorRoute {

	public static void main(String[] args) {
		CamelContext context= new DefaultCamelContext();

		try{
			context.addRoutes(new RouteBuilder() {
			    public void configure() throws Exception {
			        from("file:data/input?noop=true")
			                .process(new CamelFileExampleProcessor())
			                .log("Received Message is ${body} and Headers are ${headers}")
			                .to("file:data/output?fileName=output.txt")
			                .to("mock:output");
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