package com.viniciusmsst.resilience4jfeignexamples.fallback.client.pokeapi;

import feign.Feign;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;

public class PokeApiClientConfiguration {

    @Bean
    public Feign.Builder feignBuilder() {
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallbackFactory(PokeApiClientFallback::new)
                .build();
        return Resilience4jFeign.builder(decorators).requestInterceptor(new PokeApiRequestInterceptor());
    }
}
