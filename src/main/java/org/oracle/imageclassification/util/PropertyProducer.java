package org.oracle.imageclassification.util;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@ApplicationScoped
public class PropertyProducer {
    private Properties properties;
    @Property
    @Produces
    public String produceString(final InjectionPoint ip) {
        String key = getKey(ip);
        String value = null;
        if(this.properties.containsKey(key)){
            value = this.properties.getProperty(key);
        }
        String valueFromSystemProps = System.getProperty(key);
        if(StringUtils.isNotBlank(valueFromSystemProps)){
            value = valueFromSystemProps;
        }
        
        return value;
        
    }
    
    
    @Property
    @Produces
    public int produceInt(final InjectionPoint ip) {
      return NumberUtils.toInt(produceString(ip));
        
    }
    
    @Property
    @Produces
    public boolean produceBoolean(final InjectionPoint ip) {
      return BooleanUtils.toBoolean(produceString(ip));
        
    }
    
    private String getKey(final InjectionPoint ip) {
        return (ip.getAnnotated()
                  .isAnnotationPresent(Property.class) && 
                !ip.getAnnotated()
                   .getAnnotation(Property.class).
                    value().isEmpty()) ? ip.getAnnotated()
                                           .getAnnotation(Property.class)
                                           .value() 
                                       : ip.getMember()
                                           .getName();
    }
    @PostConstruct
    public void init() {
        this.properties = new Properties();
        final InputStream stream = PropertyProducer.class
                                      .getResourceAsStream("/application.properties");
        if (stream != null) {
            try {
                this.properties.load(stream);
            } catch (final IOException e) {
                throw new RuntimeException("Configuration could not be loaded!");
            }
        }
       
    }
}
