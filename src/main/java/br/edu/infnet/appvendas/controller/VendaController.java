package br.edu.infnet.appvendas.controller;

import br.edu.infnet.appvendas.model.domain.Propriedade;
import br.edu.infnet.appvendas.model.domain.Situacao;
import br.edu.infnet.appvendas.model.domain.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appvendas.model.domain.Usuario;
import br.edu.infnet.appvendas.model.service.VendaService;
import br.edu.infnet.appvendas.model.service.PropriedadeService;
import br.edu.infnet.appvendas.model.service.CompradorService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VendaController {
	
	@Autowired
	private VendaService vendaService;
	@Autowired
	private PropriedadeService propriedadeService;
	@Autowired
	private CompradorService compradorService;

	@GetMapping(value = "/venda")
	public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("propriedades", propriedadeService.obterLista(usuario));
		
		model.addAttribute("compradores", compradorService.obterLista(usuario));
		
		return "venda/cadastro";
	}
	
	@GetMapping(value = "/vendas")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("listaVendas", vendaService.obterLista(usuario));
		
		return "venda/lista";
	}

	@PostMapping(value = "/venda/incluir")
	public String incluir(Model model, Venda venda, @RequestParam String[] propriedadeIds, @SessionAttribute("user") Usuario usuario) {

		List<Propriedade> listaPropriedade = new ArrayList<Propriedade>();

		venda.setUsuario(usuario);

		for (String idPropriedade : propriedadeIds){

			Propriedade propriedade = propriedadeService.obterPorId(Integer.valueOf(idPropriedade));
			propriedade.setSituacao(Situacao.VENDIDO);

			listaPropriedade.add(propriedade);
		}

		venda.setPropriedade(listaPropriedade);

		vendaService.incluir(venda);

		model.addAttribute("descricao", venda.getDescricao());

		return telaLista(model, usuario);
	}
	
	@GetMapping(value = "/venda/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		try {
			vendaService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("mensagem", "Impossível realizar a exclusao desta propriedade!!!");
		}

		return this.telaLista(model, usuario);
	}

}