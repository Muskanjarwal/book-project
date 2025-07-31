package app.conf.resource;

import app.conf.service.GreetingService;
import com.google.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello")
public class HelloResource {

    private final GreetingService greetingService;

    @Inject
    public HelloResource(GreetingService greetingService){
        this.greetingService=greetingService;
    }

    @GET
    public String sayHello(){
        return greetingService.greet();
    }
}
