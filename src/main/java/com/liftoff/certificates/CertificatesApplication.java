package com.liftoff.certificates;

import com.liftoff.certificates.resources.*;
import com.liftoff.certificates.utils.JPAUtil;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by vijay.hathimare on 1/26/18.
 */
public class CertificatesApplication extends Application<CertificatesConfiguration> {


    @Override
    public void initialize(Bootstrap<CertificatesConfiguration> bootstrap) {

    }

    @Override
    public void run(CertificatesConfiguration certificatesConfiguration, Environment environment)
            throws Exception {
        JPAUtil.createEntityManagerFactory(certificatesConfiguration.getDatabase());
        environment.jersey().register(new UserResource());
        environment.jersey().register(new CourseResource());
        environment.jersey().register(new QuestionResource());
        environment.jersey().register(new AnswerResource());
        environment.jersey().register(new CertificateResource());
    }

    public static void main(String[] args) throws Exception {
        new CertificatesApplication().run(args);
    }
}
