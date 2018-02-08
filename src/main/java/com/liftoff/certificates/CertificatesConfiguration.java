package com.liftoff.certificates;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.liftoff.certificates.config.Database;
import io.dropwizard.Configuration;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created by vijay.hathimare on 1/26/18.
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CertificatesConfiguration extends Configuration{
    @NotNull
    @Getter
    @Setter
    @JsonProperty("database")
    private Database database;

}
