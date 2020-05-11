package com.viniciusmsst.resilience4jfeignexamples.client;

import feign.Feign;
import feign.Request;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Bean;

public class PokeApiClientConfiguration {

  @Bean
  public Feign.Builder feignBuilder() {
    FeignDecorators decorators =
        FeignDecorators.builder().withFallbackFactory(PokeApiClientFallback::new).build();

    return Resilience4jFeign.builder(decorators)
        .requestInterceptor(new PokeApiRequestInterceptor())
        .options(new Request.Options(200, TimeUnit.MILLISECONDS, 200, TimeUnit.MILLISECONDS, true));
  }
}
