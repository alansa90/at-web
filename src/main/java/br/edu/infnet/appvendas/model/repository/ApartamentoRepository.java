package br.edu.infnet.appvendas.model.repository;

import java.util.List;

import br.edu.infnet.appvendas.model.domain.Apartamento;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartamentoRepository extends CrudRepository<Apartamento, Integer> {

	@Query("from Apartamento a where a.usuario.id =:id")
	public List<Apartamento> findAll(Integer id, Sort by);
}