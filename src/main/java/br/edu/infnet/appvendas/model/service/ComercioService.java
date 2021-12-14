package br.edu.infnet.appvendas.model.service;

import br.edu.infnet.appvendas.model.domain.Comercio;
import br.edu.infnet.appvendas.model.domain.Usuario;
import br.edu.infnet.appvendas.model.repository.ComercioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComercioService {
    @Autowired
    private ComercioRepository comercioRepository;

    public void incluir(Comercio comercio) {
        comercioRepository.save(comercio);
    }

    public void excluir(Integer id) {
        comercioRepository.deleteById(id);
    }

    public Comercio obterPorId(Integer id) {
        return comercioRepository.findById(id).orElse(null);
    }

    public List<Comercio> obterLista(Usuario usuario){
        return comercioRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "descricao"));
    }

    public Integer obterQtde() {
        return (int) comercioRepository.count();
    }
}
