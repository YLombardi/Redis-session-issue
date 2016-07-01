package com.geodis.rt.zenith.portal.webui;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.geodis.rt")
public class ZenithPortalWebuiApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
        return springApplicationBuilder
                .sources(ZenithPortalWebuiApplication.class);
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZenithPortalWebuiApplication.class)
                .sources(ZenithPortalWebuiApplication.class)
                .run(args);
    }

}