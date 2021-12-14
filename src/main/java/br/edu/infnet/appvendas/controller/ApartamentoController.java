package br.edu.infnet.appvendas.controller;

import br.edu.infnet.appvendas.model.domain.Apartamento;
import br.edu.infnet.appvendas.model.domain.Endereco;
import br.edu.infnet.appvendas.model.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appvendas.model.domain.Usuario;
import br.edu.infnet.appvendas.model.service.ApartamentoService;

@Controller
public class ApartamentoController {
	
	@Autowired
	private ApartamentoService apartamentoService;
	@Autowired
	private EnderecoService enderecoService;

	@GetMapping(value = "/apartamento")
	public String telaCadastro() {
		return "apartamento/cadastro";
	}
	
	@GetMapping(value = "/apartamentos")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("listaApartamentos", apartamentoService.obterLista(usuario));
		
		return "apartamento/lista";
	}

	@PostMapping(value = "/apartamento/incluir")
	public String incluir(Model model, Apartamento apartamento, Endereco endereco, @SessionAttribute("user") Usuario usuario) {
		Endereco endSaved = enderecoService.save(endereco);
		apartamento.setEndereco(endSaved);

		apartamento.setUsuario(usuario);
		
		apartamentoService.incluir(apartamento);

		model.addAttribute("descricao", apartamento.getDescricao());

		return telaLista(model, usuario);
	}
	
	@GetMapping(value = "/apartamento/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		try {
			apartamentoService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msg", "Impossível realizar a exclusao deste apartamento!!!");
		}

		return this.telaLista(model, usuario);
	}

}