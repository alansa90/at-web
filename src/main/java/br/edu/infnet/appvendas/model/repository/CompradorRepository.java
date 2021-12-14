package br.edu.infnet.appvendas.model.repository;

import java.util.List;

import br.edu.infnet.appvendas.model.domain.Comprador;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompradorRepository extends CrudRepository<Comprador, Integer> {

	@Query("from Comprador c where c.usuario.id =:id")
	public List<Comprador> obterLista(Integer id, Sort sort);
}