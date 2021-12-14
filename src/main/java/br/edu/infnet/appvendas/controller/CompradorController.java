package br.edu.infnet.appvendas.controller;

import br.edu.infnet.appvendas.model.domain.Comprador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appvendas.model.domain.Usuario;
import br.edu.infnet.appvendas.model.service.CompradorService;

@Controller
public class CompradorController {
	
	@Autowired
	private CompradorService compradorService;

	@GetMapping(value = "/comprador")
	public String telaCadastro() {
		return "comprador/cadastro";
	}
	
	@GetMapping(value = "/compradores")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("listaCompradores", compradorService.obterLista(usuario));
		
		return "comprador/lista";
	}

	@PostMapping(value = "/comprador/incluir")
	public String incluir(Model model, Comprador comprador, @SessionAttribute("user") Usuario usuario) {

		comprador.setUsuario(usuario);
		
		compradorService.incluir(comprador);

		model.addAttribute("nome", comprador.getNome());

		return telaLista(model, usuario);
	}
	
	@GetMapping(value = "/comprador/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		try {
			compradorService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msg", "Impossível realizar a exclusão deste comprador!!!");
		}

		return this.telaLista(model, usuario);
	}

}