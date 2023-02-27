package br.com.ifsp.crud.controller;

import br.com.ifsp.crud.entities.*;
import br.com.ifsp.crud.repository.*;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class FilmeController {

    @Autowired
    private FilmeRepository repository;

    @PostMapping(value = "/api/v1/insert")
    public ResponseEntity<Object> salvaFilmeNoBanco(@RequestBody @Valid Filme filme) {

        repository.save(filme);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping(value = "/api/v1/filmes")
    public List<Filme> retornaTodosFilmesNoBanco() {

        return repository.findAll();

    }

    @GetMapping(value = "/api/v1/filmes/{id}")
    public Optional<Filme> retornaFilmePorId(@PathVariable Long id) {
        return repository.findById(id);

    }

    @PutMapping(value = "/api/v1/filmes/update/{id}")
    public ResponseEntity<Object> atualizaFilmePorId(@PathVariable Long id, @RequestBody Filme filmeNovo) {

        Optional<Filme> filmeBanco = repository.findById(id);

        Filme filmeExistente = filmeBanco.get();

        filmeExistente.setDiretor(filmeNovo.getDiretor());
        filmeExistente.setGenero(filmeNovo.getGenero());
        filmeExistente.setDuracao(filmeNovo.getDuracao());
        filmeExistente.setTitulo(filmeNovo.getTitulo());

         repository.save(filmeExistente);

         return new ResponseEntity<>(filmeExistente, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/v1/filmes/delete/{id}")
    public ResponseEntity<Object> deletaFilmeNoBanco(@PathVariable Long id) {

        Optional<Filme> filme = repository.findById(id);

        repository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

