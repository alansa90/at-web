package br.edu.infnet.appvendas.model.repository;

import java.util.List;

import br.edu.infnet.appvendas.model.domain.Casa;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasaRepository extends CrudRepository<Casa, Integer> {

	@Query("from Casa c where c.usuario.id =:id")
	public List<Casa> findAll(Integer id, Sort by);
}