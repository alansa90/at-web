package br.edu.infnet.appvendas.model.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TVenda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private Integer id;
    private LocalDateTime date;
    private String descricao;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_comprador")
    private Comprador comprador;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_propriedade")
    private List<Propriedade> propriedades;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public void setPropriedade(List<Propriedade> propriedades) {
        this.propriedades = propriedades;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }


    public List<Propriedade> getPropriedade() {
        return propriedades;
    }

    public Comprador getComprador() {
        return comprador;
    }

}
