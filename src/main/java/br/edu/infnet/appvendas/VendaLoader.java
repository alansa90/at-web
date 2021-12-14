package br.edu.infnet.appvendas;


import br.edu.infnet.appvendas.model.domain.*;
import br.edu.infnet.appvendas.model.service.EnderecoService;
import br.edu.infnet.appvendas.model.service.PropriedadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvendas.model.service.VendaService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Order(4)
public class VendaLoader implements ApplicationRunner {
	@Autowired
	private PropriedadeService propriedadeService;

	@Autowired
	private VendaService vendaService;

    @Autowired
    private EnderecoService enderecoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {


		Comprador comprador = new Comprador();
		comprador.setId(1);

		Usuario usuario = new Usuario();
		usuario.setId(1);

		Casa casa = new Casa();
		casa.setId(2);
		casa.setSituacao(Situacao.VENDIDO);

		Apartamento ap = new Apartamento();
		ap.setId(1);
		ap.setSituacao(Situacao.VENDIDO);

		List<Propriedade> listPropriedades = new ArrayList<Propriedade>();
		listPropriedades.add(casa);
		listPropriedades.add(ap);



		Venda venda = new Venda();
		venda.setDescricao("Primeiro venda Loader");
		venda.setDate(LocalDateTime.now());
		venda.setPropriedade(listPropriedades);
		venda.setComprador(comprador);
		venda.setUsuario(usuario);
		vendaService.incluir(venda);
	}

}
