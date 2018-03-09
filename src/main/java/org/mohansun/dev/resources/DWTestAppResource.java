
package org.mohansun.dev.resources;
import org.mohansun.dev.api.Saying;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

//Jersey resources are the meat-and-potatoes of a Dropwizard application.
// Each resource class is associated with a URI template. For our application,
// we need a resource which returns new Saying instances from the URI /hello-world,
// so our resource class looks like this:


/*

HelloWorldResource has two annotations:
   @Path and @Produces. @Path("/hello-world") tells Jersey that this resource is accessible at the URI /hello-world,
  @Produces(MediaType.APPLICATION_JSON) lets Jersey’s content negotiation code know that
     this resource produces representations which are application/json.


     Resource classes are used by multiple threads concurrently.
     In general, we recommend that resources be stateless/immutable, but it’s important to keep the context in mind.


*/

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
  public class DWTestAppResource {
    private final String template;
    private final String defaultName;
    /*
      An AtomicLong provides us with a cheap, thread-safe way of generating unique(ish) IDs.
    */
    private final AtomicLong counter;

    /*
     HelloWorldResource takes two parameters for construction:
       the template it uses to produce the saying and
       the defaultName used when the user declines to tell us their name.

    */

    public DWTestAppResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

   /*

   #sayHello(Optional<String>) is the meat of this class,
    and it’s a fairly simple method.
    The @QueryParam("name") annotation tells Jersey to map the name parameter from the query string
        to the name parameter in the method.
     If the client sends a request to /hello-world?name=Dougie,
        sayHello will be called with Optional.of("Dougie");
         if there is no name parameter in the query string, sayHello will be called with Optional.absent()

   */

    @GET
    @Timed
    // @Timed: Dropwizard automatically records the duration and rate of its invocations as a Metrics Timer.
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.orElse(defaultName));
        // we increment the counter
        return new Saying(counter.incrementAndGet(), value);

        //Once sayHello has returned, Jersey takes the Saying instance and
        // looks for a provider class which can write Saying instances as application/json.

        // Dropwizard has one such provider built in which allows for producing and consuming Java objects as JSON objects.
        //  The provider writes out the JSON and the client receives a 200 OK response with a content type of application/json.

    }
}
