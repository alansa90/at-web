package br.edu.infnet.appvendas.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "TComercio")
public class Comercio extends Propriedade {

    private Integer andar;
    private Integer unidade;
    private String nomeEdificio;
    private Integer vagasGaragem;
    private Integer anoConstrucao;
    private double valorCondominio;
    private TipoComercio tipoComercio;

    public Comercio() {

    }

    public Comercio(Integer numero, float areaTotal, double valorPropriedade, String descricao, Situacao situacao) {
        super(numero, areaTotal, valorPropriedade, descricao, situacao);

    }

    public Integer getAndar() {
        return andar;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
    }

    public Integer getUnidade() {
        return unidade;
    }

    public void setUnidade(Integer unidade) {
        this.unidade = unidade;
    }

    public String getNomeEdificio() {
        return nomeEdificio;
    }

    public void setNomeEdificio(String nomeEdificio) {
        this.nomeEdificio = nomeEdificio;
    }

    public Integer getVagasGaragem() {
        return vagasGaragem;
    }

    public void setVagasGaragem(Integer vagasGaragem) {
        this.vagasGaragem = vagasGaragem;
    }

    public Integer getAnoConstrucao() {
        return anoConstrucao;
    }

    public void setAnoConstrucao(Integer anoConstrucao) {
        this.anoConstrucao = anoConstrucao;
    }

    public double getValorCondominio() {
        return valorCondominio;
    }

    public void setValorCondominio(double valorCondominio) {
        this.valorCondominio = valorCondominio;
    }

    public TipoComercio getTipoComercio() {
        return tipoComercio;
    }

    public void setTipoComercio(TipoComercio tipoComercio) {
        this.tipoComercio = tipoComercio;
    }


}
