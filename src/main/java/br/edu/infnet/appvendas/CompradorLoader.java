package br.edu.infnet.appvendas;

import br.edu.infnet.appvendas.model.domain.Comprador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvendas.model.domain.Usuario;
import br.edu.infnet.appvendas.model.service.CompradorService;

@Component
@Order(2)
public class CompradorLoader implements ApplicationRunner {

	@Autowired
	private CompradorService compradorService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);

		Comprador comprador = new Comprador("Zezinho das Neves", "123456789-10", "zezinho@neves.com");
		comprador.setUsuario(usuario);
		
		compradorService.incluir(comprador);
	}

}
