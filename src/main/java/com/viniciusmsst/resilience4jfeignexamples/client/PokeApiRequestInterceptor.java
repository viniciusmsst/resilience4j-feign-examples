package com.viniciusmsst.resilience4jfeignexamples.client;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import java.util.UUID;

public class PokeApiRequestInterceptor implements RequestInterceptor {
  @Override
  public void apply(RequestTemplate requestTemplate) {
    requestTemplate.header("User-Agent", UUID.randomUUID().toString());
  }
}
