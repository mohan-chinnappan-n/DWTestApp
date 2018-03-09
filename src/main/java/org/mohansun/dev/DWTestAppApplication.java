package org.mohansun.dev;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


import org.mohansun.dev.resources.DWTestAppResource;
import org.mohansun.dev.health.TemplateHealthCheck;

import org.mohansun.dev.resources.EventResource;


/*
  Combined with your project’s Configuration subclass,
               its Application subclass
          forms the core of your Dropwizard application

*/
public class DWTestAppApplication extends Application<DWTestAppConfiguration> {

    // this will be our application’s entry point


    public static void main(final String[] args) throws Exception {
        new DWTestAppApplication().run(args);
    }

    @Override
    public String getName() {
        return "DWTestApp";
    }

    // An initialize method is used to configure aspects
    // of the application required before the application is run,
    // like bundles, configuration source providers, etc
    @Override
    public void initialize(final Bootstrap<DWTestAppConfiguration> bootstrap) {
        // TODO: application initialization
    }

    /*
       add the new resource class.
       In its run method we can read the template and default name from the DWTestAppConfiguration instance,
        create a new DWTestAppResource instance, and then add it to the application’s Jersey environment:

    */

    @Override
    public void run(final DWTestAppConfiguration configuration,
                    final Environment environment) {
          final DWTestAppResource resource = new DWTestAppResource( configuration.getTemplate(), configuration.getDefaultName() );
          DateFormat eventDateFormat = new SimpleDateFormat(configuration.getDateFormat());

          final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
          environment.healthChecks().register("template", healthCheck);
          // When our application starts, we create a new instance of our resource class with the parameters from
          // the configuration file and hand it off to the Environment, which acts like a registry of all the things your application can do.
          environment.jersey().register(resource);

          EventResource eventResource = new EventResource();
          environment.jersey().register(eventResource);



}

}
