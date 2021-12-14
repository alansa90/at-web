package br.edu.infnet.appvendas.controller;

import br.edu.infnet.appvendas.model.domain.Casa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appvendas.model.domain.Usuario;
import br.edu.infnet.appvendas.model.service.CasaService;

import java.rmi.server.ExportException;

@Controller
public class CasaController {
	
	@Autowired
	private CasaService casaService;

	@GetMapping(value = "/casa")
	public String telaCadastro() {
		return "casa/cadastro";
	}
	
	@GetMapping(value = "/casas")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("listaCasas", casaService.obterLista(usuario));
		
		return "casa/lista";
	}

	@PostMapping(value = "/casa/incluir")
	public String incluir(Model model, Casa casa, @SessionAttribute("user") Usuario usuario) {
		
		casa.setUsuario(usuario);
		
		casaService.incluir(casa);

		model.addAttribute("descricao", casa.getDescricao());

		return telaLista(model, usuario);
	}
	
	@GetMapping(value = "/casa/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		try {
			casaService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msg", "Impossível realizar a exclusao desta casa!!!");
		}

		return this.telaLista(model, usuario);
	}

}