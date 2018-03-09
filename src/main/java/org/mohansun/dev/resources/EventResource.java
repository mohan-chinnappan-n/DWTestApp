
package org.mohansun.dev.resources;
import org.mohansun.dev.api.Saying;
import com.codahale.metrics.annotation.Timed;

import org.mohansun.dev.api.Event;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

import java.util.List;
import java.util.Date;
import java.util.Collections;

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

@Path("/events")
@Produces(MediaType.APPLICATION_JSON)
  public class EventResource {
    public EventResource() {
    }


  @GET
  public List<Event> allEvents() {
          Event e = new Event();
          e.setDate(new Date());
          e.setName("Birthday");
          e.setId(1L);
          e.setDescription("Please be on time!");
          e.setLocation("221B Baker Street");
          return Collections.singletonList(e);
  }

}
