package br.unesp.evento.model;

public enum AreaFormacao {

    EXATAS("Exatas"),
    BIOLOGICAS("Biológicas"),
    HUMANAS("Humanas"),
    APLICADAS("Aplicadas");

    private final String label;

    AreaFormacao(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
