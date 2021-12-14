package br.edu.infnet.appvendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvendas.model.domain.Endereco;
import br.edu.infnet.appvendas.model.domain.Usuario;
import br.edu.infnet.appvendas.model.service.UsuarioService;

@Component
@Order(1)
public class
UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		Endereco endereco = new Endereco();
		endereco.setBairro("Tomas Coelho");
		endereco.setCep("20750-370");
		endereco.setComplemento("alameda");
		endereco.setLocalidade("Rio de Janeiro");
		endereco.setLogradouro("Praça");
		endereco.setUf("RJ");
		
		Usuario usuario = new Usuario();
		usuario.setEmail("alan.sa@al.infnet.edu.br");
		usuario.setNome("Alan Sa");
		usuario.setSenha("123");
		usuario.setAdmin(true);
		
		usuario.setEndereco(endereco);

		usuarioService.incluir(usuario);
	}
}