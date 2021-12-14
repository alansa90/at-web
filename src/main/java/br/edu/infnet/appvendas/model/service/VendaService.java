package br.edu.infnet.appvendas.model.service;

import java.util.List;

import br.edu.infnet.appvendas.model.domain.Venda;
import br.edu.infnet.appvendas.model.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvendas.model.domain.Usuario;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository vendaRepository;

	public List<Venda> obterLista(){
				
		return (List<Venda>)vendaRepository.findAll();
	}
	
	public List<Venda> obterLista(Usuario usuario){
		
		return (List<Venda>)vendaRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "descricao"));
	}

	public void incluir(Venda venda){

		Venda v = vendaRepository.save(venda);
	}
	
	public void excluir(Integer id) {
		vendaRepository.deleteById(id);
	}
}
