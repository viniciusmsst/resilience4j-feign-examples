package com.viniciusmsst.resilience4jfeignexamples.client;

import com.viniciusmsst.resilience4jfeignexamples.entity.Pokemon;
import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
    value = "pokeapi",
    url = "https://pokeapi.co",
    configuration = PokeApiClientConfiguration.class)
public interface PokeApiClient {

  @RequestMapping(
      method = RequestMethod.GET,
      value = "/api/v2/pokemon/{name}",
      consumes = "application/json")
  Optional<Pokemon> findPokemonByName(@PathVariable("name") String name);
}
