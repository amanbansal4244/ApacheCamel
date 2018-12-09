import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.route.rest.RestRoute;
import com.learncamel.route.rest.RestRouteMain;

/**
 * Created by z001qgd on 7/13/17.
 */
public class RestRouteTest extends CamelTestSupport {


    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RestRoute();
    }

    @Test
    public void restCall(){

      String response =   template.requestBody("direct:restCall","USA",String.class);
        System.out.println("response : " + response);
        assertNotNull(response);
    }

}