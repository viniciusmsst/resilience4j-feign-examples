package com.viniciusmsst.resilience4jfeignexamples.fallback.controller;

import com.viniciusmsst.resilience4jfeignexamples.fallback.client.pokeapi.PokeApiClient;
import com.viniciusmsst.resilience4jfeignexamples.fallback.entity.Pokemon;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/fallback/pokemon")
public class FallbackController {
    private final PokeApiClient pokeApiClient;

    public FallbackController(PokeApiClient pokeApiClient) {
        this.pokeApiClient = pokeApiClient;
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<Pokemon> findPokemonByName(@PathVariable("name") String name) {
        Optional<Pokemon> pokemon = pokeApiClient.findPokemonByName(name);
        if (pokemon.isPresent()) {
            return ResponseEntity.ok(pokemon.get());
        } else {
            return ResponseEntity.badRequest().body(new Pokemon());
        }
    }

    @GetMapping(path = "/name")
    public String test() {
        return "happy";
    }
}