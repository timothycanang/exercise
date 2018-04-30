package com.exercise.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration

@ComponentScan(basePackages={
        "com.exercise.customer",
})

@EntityScan(basePackages = {
        "com.fervent"
})


@Import({
        SwaggerConfig.class
})

@PropertySource("classpath:application.properties")
public class applicationConfig {

}

