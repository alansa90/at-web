package br.edu.infnet.appvendas.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "TPropriedade")
@Inheritance(strategy = InheritanceType.JOINED)
public class Propriedade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_propriedade")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
    private Integer numero;
    private float areaTotal;
    private double valorPropriedade;
    private String descricao;
    private Situacao situacao;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_venda")
    private Venda venda;

    public Propriedade () {

    }

    public Propriedade(Integer numero, float areaTotal, double valorPropriedade, String descricao, Situacao situacao) {
        this.numero = numero;
        this.areaTotal = areaTotal;
        this.valorPropriedade = valorPropriedade;
        this.descricao = descricao;
        this.situacao = situacao;
    }

    public Venda getVenda() {
        return venda;
    }

    public Usuario getUsuario() {
        return usuario;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public float getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(float areaTotal) {
        this.areaTotal = areaTotal;
    }

    public double getValorPropriedade() {
        return valorPropriedade;
    }

    public void setValorPropriedade(double valorPropriedade) {
        this.valorPropriedade = valorPropriedade;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

}
