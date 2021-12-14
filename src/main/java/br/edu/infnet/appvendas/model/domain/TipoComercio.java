package br.edu.infnet.appvendas.model.domain;

public enum TipoComercio {
    SALA_COMERCIAL("Sala Comercial"),
    LOJA("Loja"),
    CASA_COMERCIAL("Casa Comercial"),
    ANDAR("Andar"),
    PREDIO_INTEIRO("Predio inteiro"),
    GALPAO("GALPAO"),
    GARAGEM("GARAGEM");


    private String descricao;

    TipoComercio(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
