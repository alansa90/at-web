package br.edu.infnet.appvendas.model.service;

import java.util.List;

import br.edu.infnet.appvendas.model.domain.Casa;
import br.edu.infnet.appvendas.model.repository.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvendas.model.domain.Usuario;

@Service
public class CasaService {

	@Autowired
	private CasaRepository casaRepository;
	
	public void incluir(Casa casa) {
		casaRepository.save(casa);
	}
	
	public void excluir(Integer id) {
		casaRepository.deleteById(id);
	}
	
	public Casa obterPorId(Integer id) {
		return casaRepository.findById(id).orElse(null);
	}
	
	public List<Casa> obterLista(Usuario usuario){
		return casaRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "descricao"));
	}

	public Integer obterQtde() {
		return (int) casaRepository.count();
	}
}
