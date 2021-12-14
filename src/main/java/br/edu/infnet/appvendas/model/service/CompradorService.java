package br.edu.infnet.appvendas.model.service;

import java.util.List;

import br.edu.infnet.appvendas.model.domain.Comprador;
import br.edu.infnet.appvendas.model.repository.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvendas.model.domain.Usuario;

@Service
public class CompradorService {
	
	@Autowired
	private CompradorRepository compradorRepository;

	public List<Comprador> obterLista(){
				
		return (List<Comprador>)compradorRepository.findAll();
	}
	
	public List<Comprador> obterLista(Usuario usuario){
		
		return compradorRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
	}

	public void incluir(Comprador solicitante){

		compradorRepository.save(solicitante);
	}
	
	public void excluir(Integer id) {
		compradorRepository.deleteById(id);
	}

	public Integer obterQtde() {
		return (int) compradorRepository.count();
	}
}
