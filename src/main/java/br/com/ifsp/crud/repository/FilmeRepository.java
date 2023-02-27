package br.com.ifsp.crud.repository;

import br.com.ifsp.crud.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
