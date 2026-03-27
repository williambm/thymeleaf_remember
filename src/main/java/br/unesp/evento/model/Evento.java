package br.unesp.evento.model;

public class Evento {
    private final String nome = "Semana Acadêmica de Tecnologia";
    private final String descricao = "Evento universitário com palestras, workshops e minicursos voltados à comunidade acadêmica.";
    private final String data = "31/07/2026";
    private final String local = "Reitoria - prédio praça da república.";
    private final int vagas = 150;

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData() {
        return data;
    }

    public String getLocal() {
        return local;
    }

    public int getVagas() {
        return vagas;
    }
}