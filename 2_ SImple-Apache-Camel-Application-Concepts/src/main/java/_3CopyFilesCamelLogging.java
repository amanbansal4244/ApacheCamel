import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * This program talks about, how to do logging through Apache Camel.
 */
public class _3CopyFilesCamelLogging {

	public static void main(String[] args) {
		CamelContext context= new DefaultCamelContext();

		try{
			context.addRoutes(new RouteBuilder() {
				@Override
				public void configure() throws Exception {
					from("file:data/input?noop=true")
					// this is how we set log in apache camel. and logging what happens between from to to.
					.to("log:?level=INFO&showBody=true&showHeaders=true")  
					.to("file:data/output");


				}
			});

			context.start();
			Thread.sleep(5000);
			context.stop();

		}catch(Exception e){
			System.out.println("Inside Exception : " + e);
		}

	}
}