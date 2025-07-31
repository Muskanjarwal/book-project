package app.conf;

import app.conf.service.GreetingService;
import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {

    @Override
    protected void configure(){
        bind(GreetingService.class);
    }
}
