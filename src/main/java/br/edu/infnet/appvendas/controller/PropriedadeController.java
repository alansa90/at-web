package br.edu.infnet.appvendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appvendas.model.domain.Usuario;
import br.edu.infnet.appvendas.model.service.PropriedadeService;

@Controller
public class PropriedadeController {
	
	@Autowired
	private PropriedadeService propriedadeService;

	@GetMapping(value = "/propriedades")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("listaPropriedades", propriedadeService.obterLista(usuario));
		
		return "propriedade/lista";
	}

	@GetMapping(value = "/propriedade/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		try {
			propriedadeService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msg", "Impossível realizar a exclusao desta propriedade!!!");
		}

		return this.telaLista(model, usuario);
	}

}