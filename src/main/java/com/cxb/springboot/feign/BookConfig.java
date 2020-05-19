package com.cxb.springboot.feign;

import com.netflix.hystrix.HystrixCommandProperties;
import feign.hystrix.HystrixFeign;
import feign.hystrix.SetterFactory;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

    @Value("${feign.client.url}")
    private String baseUrl;

    @Bean
    IBookClient nodeClient() throws InterruptedException {
        return HystrixFeign.builder()
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .setterFactory((target, method) ->
                        new SetterFactory.Default().create(target, method).
                                andCommandPropertiesDefaults(HystrixCommandProperties.defaultSetter().
                                        withExecutionTimeoutInMilliseconds(10000)))
                .target(IBookClient.class, this.baseUrl);
    }
}
