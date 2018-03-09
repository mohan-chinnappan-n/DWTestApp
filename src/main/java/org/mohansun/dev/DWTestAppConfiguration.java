package org.mohansun.dev;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;


// The parsed configuration fields are used to build a new instance of a configuration class.

// deserialized from the YAML file
public class DWTestAppConfiguration extends Configuration {
    // TODO: implement service configuration

    // @NotEmpty:  so if the YAML configuration file has blank values for either or is missing template entirely an informative exception
    //   will be thrown,
    //   and your application won’t start.
    // This is handled by Hibernate Validator
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";


    @NotEmpty
    private String dateFormat;
    //dateFormat: yyyy-MM-dd'T'HH:mmZ

    // getters and settings
    // @JsonProperty : allows Jackson to both deserialize(read) the properties from a YAML file but also to serialize it.
    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }


    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }

    @JsonProperty
    public String getDateFormat() {
       return dateFormat;
   }

}
