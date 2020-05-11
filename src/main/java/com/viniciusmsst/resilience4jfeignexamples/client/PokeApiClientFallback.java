package com.viniciusmsst.resilience4jfeignexamples.client;

import com.viniciusmsst.resilience4jfeignexamples.entity.Pokemon;
import java.util.Optional;

public class PokeApiClientFallback implements PokeApiClient {
  private Exception cause;

  public PokeApiClientFallback(Exception cause) {
    this.cause = cause;
  }

  public Optional<Pokemon> findPokemonByName(String name) {
    System.out.println(cause.getMessage());
    return Optional.empty();
  }
}
