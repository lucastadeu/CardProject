package com.example.lucas.cardproject;

import java.io.Serializable;

/**
 * Created by tawan on 03/12/2016.
 */

public class Cartao implements Serializable {
    private String nome;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String numero;
}
