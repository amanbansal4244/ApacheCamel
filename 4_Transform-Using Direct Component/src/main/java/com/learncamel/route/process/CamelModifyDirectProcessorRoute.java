package com.learncamel.route.process;

import org.apache.camel.builder.RouteBuilder;

import com.learncamel.processor.CamelDirectExampleProcessor;

/**
 * Created by z001qgd on 6/10/17.
 */
public class CamelModifyDirectProcessorRoute extends RouteBuilder {


	public void configure() throws Exception {

		from("process:processorInput")
		/*In previous example, we have 'file' component and our processor were designed in such a way to read the file and process it
		 * but here, 'direct' component is going to receive input as a String directly.
		 * 
		 */
		.process(new CamelDirectExampleProcessor())
		.log("Received Message is ${body} and Headers are ${headers}")
		//.to("file:data/output?fileName=output.txt");
		.to("mock:output");
	}
}	
