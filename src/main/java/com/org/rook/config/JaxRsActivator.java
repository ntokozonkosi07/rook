package com.org.rook.config;

import io.swagger.jaxrs.config.BeanConfig;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/restapi")
public class JaxRsActivator extends Application {
    
    public JaxRsActivator(){        
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setBasePath("/rook/restapi");
        beanConfig.setResourcePackage("com.org.rook.api");
        beanConfig.setSchemes(new String[]{"http", "https"});
        beanConfig.setScan(true);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        
        resources.add(com.org.rook.api.AccidentRs.class);
        resources.add(com.org.rook.api.HijackingRs.class);
        resources.add(com.org.rook.config.CORSFilter.class);

        return resources;
    }
    
}
