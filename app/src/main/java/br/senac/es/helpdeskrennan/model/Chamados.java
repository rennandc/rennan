package br.senac.es.helpdeskrennan.model;

import java.util.Date;

public class Chamados {
   private int id;
    private Date dataAbertura;
    private String decricao;
    private String status;
    private String solucao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDecricao() {
        return decricao;
    }

    public void setDecricao(String decricao) {
        this.decricao = decricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public Chamados(int id, Date dataAbertura, String decricao, String status, String solucao) {
        this.id = id;
        this.dataAbertura = dataAbertura;
        this.decricao = decricao;
        this.status = status;
        this.solucao = solucao;
    }


    @Override
    public String toString() {
        return "Chamados" +
                " dataAbertura=" + dataAbertura +
                ", decricao='" + decricao + '\'' +
                ", status='" + status;
    }
}
