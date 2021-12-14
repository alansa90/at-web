package br.edu.infnet.appvendas.model.repository;

import java.util.List;

import br.edu.infnet.appvendas.model.domain.Venda;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface VendaRepository extends CrudRepository<Venda, Integer> {

	@Transactional
	public Venda save (Venda venda);

	@Query("from Venda v where v.usuario.id = :id")
	public List<Venda> findAll(Integer id, Sort by);
}