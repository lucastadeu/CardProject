package com.example.lucas.cardproject;

/**
 * Created by lucas on 26/10/2016.
 */

public class InvoicesData{
    private String nomeEstabelecimento;
    private Integer valor;
    private String horario;

    @Override
    public String toString() {
        return "Estabelecimento: " + nomeEstabelecimento + " Valor: R$" +
                valor + " - " + horario;
    }

    public InvoicesData(){

    }

    public InvoicesData(String nomeEstabelecimento, Integer valor, String horario){
        super();
        this.nomeEstabelecimento = nomeEstabelecimento;
        this.valor = valor;
        this.horario = horario;
    }

    public String getNomeEstabelecimento() {

        return nomeEstabelecimento;
    }

    public void setNomeEstabelecimento(String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }

    public Integer getValor() {

        return valor;
    }

    public void setValor(Integer valor) {

        this.valor = valor;
    }

    public String getHorario() {

        return horario;
    }

    public void setHorario(String horario) {

        this.horario = horario;
    }
}
