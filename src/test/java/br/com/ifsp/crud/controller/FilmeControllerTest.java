package br.com.ifsp.crud.controller;

import br.com.ifsp.crud.entities.*;
import br.com.ifsp.crud.repository.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.web.client.*;
import org.springframework.http.*;
import org.springframework.web.client.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FilmeControllerTest {
    @Autowired
    private FilmeRepository repository;

    @Autowired
    private FilmeController controller;

    @Test
    public void salvaFilmeComSucesso() {

        Filme filme = new Filme();
        filme.setTitulo("O Senhor dos Anéis");
        filme.setDiretor("Peter Jackson");
        filme.setGenero("Fantasia");
        filme.setDuracao("1h59");

        ResponseEntity<Object> response = controller.salvaFilmeNoBanco(filme);

        assertEquals(response.getStatusCode(), HttpStatus.CREATED);

    }

    @Test
    public void retornaFilmesComSucesso() {

        Filme filme = new Filme();
        filme.setTitulo("O Senhor dos Anéis");
        filme.setDiretor("Peter Jackson");
        filme.setGenero("Fantasia");
        filme.setDuracao("1h59");

        controller.salvaFilmeNoBanco(filme);

        List<Filme> lista = controller.retornaTodosFilmesNoBanco();

        assertEquals(lista.get(0), filme);

    }

    @Test
    public void retornaFilmeUnicoComSucesso() {

        Filme filme = new Filme();
        filme.setTitulo("O Senhor dos Anéis");
        filme.setDiretor("Peter Jackson");
        filme.setGenero("Fantasia");
        filme.setDuracao("1h59");

        controller.salvaFilmeNoBanco(filme);

        Optional<Filme> filmeBanco = controller.retornaFilmePorId(filme.getID());

        assertEquals(filmeBanco.get(),filme);

    }

    @Test
    public void atualizaFilmeComSucesso() {

        Filme filme = new Filme();
        filme.setTitulo("O Senhor dos Anéis");
        filme.setDiretor("Peter Jackson");
        filme.setGenero("Fantasia");
        filme.setDuracao("1h59");

        controller.salvaFilmeNoBanco(filme);

        filme.setDuracao("3h00");

        controller.atualizaFilmePorId(filme.getID(), filme);

        Optional<Filme> filmeBanco = controller.retornaFilmePorId(filme.getID());

        assertEquals(filmeBanco.get(),filme);

    }

    @Test
    public void deletaFilmeComSucesso() {

        Filme filme = new Filme();
        filme.setTitulo("O Senhor dos Anéis");
        filme.setDiretor("Peter Jackson");
        filme.setGenero("Fantasia");
        filme.setDuracao("1h59");

        controller.salvaFilmeNoBanco(filme);

       ResponseEntity<Object> response = controller.deletaFilmeNoBanco(filme.getID());

        assertEquals(response.getStatusCode(), HttpStatus.OK);

    }

}