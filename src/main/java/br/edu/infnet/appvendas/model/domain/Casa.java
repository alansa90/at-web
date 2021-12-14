package br.edu.infnet.appvendas.model.domain;

import javax.persistence.*;

@Entity
@Table(name= "TCasa")
public class Casa extends Propriedade {

    private float areaConstruida;
    private Integer quartos;
    private Integer vagasGaragem;
    private Integer anoConstrucao;
    private Integer andares;
    private TipoResidencia tipoResidencia;

    public Casa() {

    }

    public Casa(Integer numero, float areaTotal, double valorPropriedade, String descricao, Situacao situacao) {
        super(numero, areaTotal, valorPropriedade, descricao, situacao);

    }


    public float getAreaConstruida() {
        return areaConstruida;
    }

    public void setAreaConstruida(float areaConstruida) {
        this.areaConstruida = areaConstruida;
    }

    public Integer getQuartos() {
        return quartos;
    }

    public void setQuartos(Integer quartos) {
        this.quartos = quartos;
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

    public Integer getAndares() {
        return andares;
    }

    public void setAndares(Integer andares) {
        this.andares = andares;
    }

    public TipoResidencia getTipoCasa() {
        return tipoResidencia;
    }

    public void setTipoCasa(TipoResidencia tipoResidencia) {
        this.tipoResidencia = tipoResidencia;
    }

}
