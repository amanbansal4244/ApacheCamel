import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * we are copying the file from one folder to another folder
 * We need to create first folder structure -> data/input and create one file 
 * Run this program : Created one file will automatically come into data/output.
 */
public class _1CopyFilesCamel {

	public static void main(String[] args) {
		// first we have to create the CamelContext object
		CamelContext context= new DefaultCamelContext();

		try{
			//Route engine can handle n numbers of routes.
			context.addRoutes(new RouteBuilder() { // we have to do this or creates new class which extends RouteBuilder() and pass class object over here.
				@Override
				public void configure() throws Exception {
					/***
					 *  file:data/input?noop=true -> called as URI.
					 * 
					 * from : this is starting end-point.
					 * 		 from uses the end-point URI, mentioned inside the method which wraps the payload and creates the Exchange.
					 * 		 and from tags knows as 'Consumer'.
					 * to : this is ending end-point.
					 * file -> is a component and a lot of components is available in markets., like REST,JDBC ,JMS,Kafka....
					 * data/input -> context path : which is actual path from where we read the file
					 * ? -> this is where we provide extra options
					 * noop=true -> meaning don't perform any operation after you coping file from it.
					 */
					from("file:data/input?noop=true")  
					.to("file:data/output"); 
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