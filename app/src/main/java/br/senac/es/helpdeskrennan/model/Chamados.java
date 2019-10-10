/*
* Aqui fica o modelo de chamados, cada variável tem que ser de acordo com o banco de dados.
* Foi estanciando e encapsulados  as variáveis:  int id;  Date dataAbertura; String descricao;String status;String solucao;
    * e todas foi realizado o processo de Get e Set para que possamos realizar consultas nas mesmas, também instanciamos o
    * construtor com todos os parametros e também vázio para que possamos iniciar um novo objeto da classe Chamados. Também
    * foi feito o processo de Tostring para que todos os atributos fossem possíveis de serem lidos e entendidos por pessoas
.* */

package br.senac.es.helpdeskrennan.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Chamados {
    @SerializedName("id")
    @Expose
   private int id;
    private Date dataAbertura;
    private String descricao;
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
        return descricao;
    }

    public void setDecricao(String decricao) {
        this.descricao = decricao;
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
        this.descricao = decricao;
        this.status = status;
        this.solucao = solucao;
    }

    public Chamados (){

    }


    @Override
    public String toString() {
        return "Chamados{" +
                "id=" + id +
                ", dataAbertura=" + dataAbertura +
                ", decricao='" + descricao + '\'' +
                ", status='" + status + '\'' +
                ", solucao='" + solucao + '\'' +
                '}';
    }
}
