package br.edu.infnet.appvendas.model.service;

import java.util.List;

import br.edu.infnet.appvendas.model.domain.Propriedade;
import br.edu.infnet.appvendas.model.repository.PropriedadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvendas.model.domain.Usuario;

@Service
public class PropriedadeService {

	@Autowired
	private PropriedadeRepository propriedadeRepository;

	public void excluir(Integer id) {
		propriedadeRepository.deleteById(id);
	}
	
	public Propriedade obterPorId(Integer id) {
		return propriedadeRepository.findById(id).orElse(null);
	}
	
	public List<Propriedade> obterLista(Usuario usuario){
		return propriedadeRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "descricao"));
	}

	public Integer obterQtde() {
		return (int) propriedadeRepository.count();
	}
}
