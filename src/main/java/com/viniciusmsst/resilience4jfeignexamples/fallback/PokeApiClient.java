package com.viniciusmsst.resilience4jfeignexamples.fallback;

import com.viniciusmsst.resilience4jfeignexamples.fallback.entity.Pokemon;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@FeignClient(value = "pokeapi", url = "https://pokeapi.co")
public interface PokeApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v2/pokemon/{name}", consumes = "application/json")
    Optional<Pokemon> findPokemonByName(@PathVariable("name") String name, @RequestHeader("User-Agent") String token);
}
