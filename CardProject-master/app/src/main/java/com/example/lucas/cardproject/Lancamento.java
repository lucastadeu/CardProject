package com.example.lucas.cardproject;

import java.io.Serializable;

/**
 * Created by tawan on 04/12/2016.
 */

public class Lancamento implements Serializable{

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private String lugar, valor, data;

}
