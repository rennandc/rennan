package br.senac.es.helpdeskrennan.model;



public class Mensagem {
    Long id;
    String texto;
    Status status;


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Mensagem(Long id, String texto, Status status) {
        this.id = id;
        this.texto = texto;
        this.status = status;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return this.texto;
    }
}
