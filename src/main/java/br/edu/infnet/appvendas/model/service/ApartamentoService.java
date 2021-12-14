package br.edu.infnet.appvendas.model.service;

import java.util.List;

import br.edu.infnet.appvendas.model.domain.Apartamento;
import br.edu.infnet.appvendas.model.repository.ApartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvendas.model.domain.Usuario;

@Service
public class ApartamentoService {

	@Autowired
	private ApartamentoRepository apartamentoRepository;
	
	public void incluir(Apartamento apartamento) {
		apartamentoRepository.save(apartamento);
	}
	
	public void excluir(Integer id) {
		apartamentoRepository.deleteById(id);
	}
	
	public Apartamento obterPorId(Integer id) {
		return apartamentoRepository.findById(id).orElse(null);
	}
	
	public List<Apartamento> obterLista(Usuario usuario){
		return apartamentoRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "descricao"));
	}

	public Integer obterQtde() {
		return (int) apartamentoRepository.count();
	}
}
