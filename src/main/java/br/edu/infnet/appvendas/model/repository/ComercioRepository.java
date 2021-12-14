package br.edu.infnet.appvendas.model.repository;

import br.edu.infnet.appvendas.model.domain.Comercio;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComercioRepository extends CrudRepository<Comercio, Integer> {

    @Query("from Comercio c where c.usuario.id =:id")
    public List<Comercio> findAll(Integer id, Sort by);
}
