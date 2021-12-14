package br.edu.infnet.appvendas.model.repository;

import java.util.List;

import br.edu.infnet.appvendas.model.domain.Propriedade;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropriedadeRepository extends CrudRepository<Propriedade, Integer> {

	@Query("from Propriedade p where p.usuario.id =:id")
	public List<Propriedade> findAll(Integer id, Sort by);
}