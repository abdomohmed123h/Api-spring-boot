package com.example.demo.Servse.bundel;

import com.example.demo.dto.Expationdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class LocalBunddlsr {

    private static ResourceBundleMessageSource messageSource;

    @Autowired
    public LocalBunddlsr(@Qualifier("mesegg") ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public static Expationdto getExpationdto(String key) {
        return new Expationdto(
                messageSource.getMessage(key, null, new Locale("ar")), messageSource.getMessage(key, null, new Locale("en"))

        );
    }
}
