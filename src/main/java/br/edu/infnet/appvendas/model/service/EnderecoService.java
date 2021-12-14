package br.edu.infnet.appvendas.model.service;

import br.edu.infnet.appvendas.model.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvendas.clients.IEnderecoClient;
import br.edu.infnet.appvendas.model.domain.Endereco;

@Service
public class EnderecoService {
	
	@Autowired
	private IEnderecoClient enderecoClient;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public Endereco obterEnderecoPorCep(String cep) {
		
		return enderecoClient.buscarCep(cep);
	}

	public Endereco save(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
}
