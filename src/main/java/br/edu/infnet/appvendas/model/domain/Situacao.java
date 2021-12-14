package br.edu.infnet.appvendas.model.domain;

public enum Situacao {
    VENDA("venda"),
    VENDIDO("vendido");

    private String descricao;

    Situacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
