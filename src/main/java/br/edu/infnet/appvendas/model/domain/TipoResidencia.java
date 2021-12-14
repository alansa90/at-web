package br.edu.infnet.appvendas.model.domain;

public enum TipoResidencia {
    PADRAO("Padrao"),
    CASA_DE_VILA("Casa de Vila"),
    FLAT("Flat"),
    KITNET("Kitnet"),
    LOFT("Loft"),
    STUDIO("Studio"),
    DUPLEX("Duplex"),
    TRIPLEX("Triplex"),
    COBERTURA("Cobertura"),
    FAZENDA("Fazenda"),
    LOTE("Lote");

    private String descricao;

    TipoResidencia(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
