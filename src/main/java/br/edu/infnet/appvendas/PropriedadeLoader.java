package br.edu.infnet.appvendas;

import br.edu.infnet.appvendas.model.domain.*;
import br.edu.infnet.appvendas.model.service.ComercioService;
import br.edu.infnet.appvendas.model.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import br.edu.infnet.appvendas.model.service.ApartamentoService;
import br.edu.infnet.appvendas.model.service.CasaService;

@Component
@Order(3)
public class PropriedadeLoader implements ApplicationRunner {

	@Autowired
	private ApartamentoService apartamentoService;
	@Autowired
	private CasaService casaService;
	@Autowired
	private ComercioService comercioService;
	@Autowired
	private EnderecoService enderecoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		try {
			Usuario usuario = new Usuario();
			usuario.setId(1);

			Endereco endereco = new Endereco();
			endereco.setBairro("Copacabana");
			endereco.setCep("22081-025");
			endereco.setComplemento("");
			endereco.setLocalidade("Rio de Janeiro");
			endereco.setLogradouro("Rua Julio de Castilhos");
			endereco.setUf("RJ");
			Endereco endApSaved = enderecoService.save(endereco);


			Endereco enderecoCasa = new Endereco();
			enderecoCasa.setBairro("Tijuca");
			enderecoCasa.setCep("20550-030");
			enderecoCasa.setComplemento("");
			enderecoCasa.setLocalidade("Rio de Janeiro");
			enderecoCasa.setLogradouro("Rua Marquês de Valença");
			enderecoCasa.setUf("RJ");
			Endereco endCasSaved = enderecoService.save(enderecoCasa);

			Endereco enderecoComercio = new Endereco();
			enderecoComercio.setBairro("Centro");
			enderecoComercio.setCep("20231-016");
			enderecoComercio.setComplemento("");
			enderecoComercio.setLocalidade("Rio de Janeiro");
			enderecoComercio.setLogradouro("Rua Ubaldino do Amaral");
			enderecoComercio.setUf("RJ");
			Endereco endComSaved = enderecoService.save(enderecoComercio);

			Apartamento apto = new Apartamento(35, 150, 1500000, "Cobertura em copacabana a duas quadras da praia", Situacao.VENDA);
			apto.setAndar(12);
			apto.setUnidade(1203);
			apto.setNomeEdificio("Bronx");
			apto.setQuartos(4);
			apto.setVagasGaragem(2);
			apto.setAnoConstrucao(1975);
			apto.setValorCondominio(659.36);
			apto.setUsuario(usuario);
			apto.setTipoApartamento(TipoResidencia.COBERTURA);
			apto.setEndereco(endApSaved);
			apartamentoService.incluir(apto);
			
			Casa casa = new Casa(28, 80, 1180000, "Casa de vila em rua arborizada, bem localizada", Situacao.VENDA);
			casa.setAreaConstruida(69);
			casa.setQuartos(3);
			casa.setVagasGaragem(2);
			casa.setAnoConstrucao(1982);
			casa.setAndares(2);
			casa.setUsuario(usuario);
			casa.setEndereco(endCasSaved);
			casa.setTipoCasa(TipoResidencia.CASA_DE_VILA);
			casaService.incluir(casa);

			Comercio comercio = new Comercio(35, 400, 1500000, "Lojão com mezanino", Situacao.VENDA);
			comercio.setAndar(2);
			comercio.setNomeEdificio("Maria Domenica");
			comercio.setVagasGaragem(4);
			comercio.setAnoConstrucao(1970);
			comercio.setValorCondominio(1200.53);
			comercio.setTipoComercio(TipoComercio.LOJA);
			comercio.setUsuario(usuario);
			comercio.setEndereco(endComSaved);
			comercioService.incluir(comercio);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
