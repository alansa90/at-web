package br.edu.infnet.appvendas.controller;

import br.edu.infnet.appvendas.model.domain.Comercio;
import br.edu.infnet.appvendas.model.domain.Usuario;
import br.edu.infnet.appvendas.model.service.ComercioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ComercioController {

    @Autowired
    private ComercioService comercioService;

    @GetMapping(value = "/comercio")
    private String telaCadastro() { return "comercio/cadastro"; }

    @GetMapping(value = "/comercios")
    private String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("listaComercios", comercioService.obterLista(usuario));

        return "comercio/lista";
    }

    @PostMapping(value = "/comercio/incluir")
    private String incluir(Model model, Comercio comercio, @SessionAttribute("user") Usuario usuario) {

        comercio.setUsuario(usuario);

        comercioService.incluir(comercio);

        model.addAttribute("descricao", comercio.getDescricao());

        return telaLista(model, usuario);
    }

    @GetMapping(value = "/comercio/{id}/excluir")
    private String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario){
        try {
            comercioService.excluir(id);
        } catch (Exception e) {
            model.addAttribute("msg", "Impossível realizar a exclusao desta propriedade!!!");
        }

        return this.telaLista(model, usuario);
    }

}
