package com.learncamel.route.process;

import com.learncamel.processor.CamelFileExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

/**
 * Requirement :
 * 	Change the file content , to : like
 *  from 123,dilip,12JAN2017 to 123:dilip:12JAN2017
 */
public class CamelModifyFileProcessorRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .process(new CamelFileExampleProcessor())
                .log("Received Message is ${body} and Headers are ${headers}")
                .to("file:data/output?fileName=output.txt")
                .to("mock:output");
    }
}
