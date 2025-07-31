package app.conf;

import app.conf.resource.HelloResource;
import app.conf.service.GreetingService;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.core.Application;
import io.dropwizard.core.Configuration;
import io.dropwizard.core.setup.Environment;

public class MyApp extends Application<Configuration>{
    public static void main(String[] args) throws Exception {
        new MyApp().run(args);
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        Injector injector = Guice.createInjector(new AppModule());
        HelloResource helloResource = injector.getInstance(HelloResource.class);

        //------without guice
//        GreetingService greetingService = new GreetingService();
//        HelloResource helloResource = new HelloResource(greetingService);

        environment.jersey().register(helloResource);
    }
}
