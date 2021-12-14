package br.edu.infnet.appvendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.edu.infnet.appvendas.model.domain.Endereco;
import br.edu.infnet.appvendas.model.domain.Usuario;
import br.edu.infnet.appvendas.model.service.EnderecoService;
import br.edu.infnet.appvendas.model.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EnderecoService enderecoService;

	@PostMapping(value = "/cep")
	public String buscarCep(Model model, @RequestParam String cep) {
		
		model.addAttribute("endereco", enderecoService.obterEnderecoPorCep(cep));
		
		return "usuario/cadastro";
	}

	@GetMapping(value = "/usuario")
	public String telaCadastro() {
		return "usuario/cadastro";
	}
	
	@GetMapping(value = "/usuarios")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("listaUsuarios", usuarioService.obterLista());
		
		return "usuario/lista";
	}

	@PostMapping(value = "/usuario/incluir")
	public String incluir(Model model, Usuario usuario, Endereco endereco) {
		
		usuario.setEndereco(endereco);
		
		usuarioService.incluir(usuario);

		return "index";
	}
	
	@GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		try {
			usuarioService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("mensagem", "Impossível realizar a exclusao desta propriedade!!!");
		}

		return this.telaLista(model, usuario);
	}	
}
