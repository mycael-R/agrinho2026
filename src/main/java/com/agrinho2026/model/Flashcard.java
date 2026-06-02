package com.agrinho2026.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe que representa um flashcard de estudo
 * Contém uma pergunta e uma resposta sobre educação ambiental
 */
public class Flashcard implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String pergunta;
    private String resposta;
    private String categoria;
    private int dificuldade; // 1-5
    private int acertos;
    private int erros;

    // Construtores
    public Flashcard() {
        this.acertos = 0;
        this.erros = 0;
    }

    public Flashcard(int id, String pergunta, String resposta, String categoria, int dificuldade) {
        this.id = id;
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.categoria = categoria;
        this.dificuldade = dificuldade;
        this.acertos = 0;
        this.erros = 0;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    public int getAcertos() {
        return acertos;
    }

    public void setAcertos(int acertos) {
        this.acertos = acertos;
    }

    public int getErros() {
        return erros;
    }

    public void setErros(int erros) {
        this.erros = erros;
    }

    // Métodos de negócio
    public void registrarAcerto() {
        this.acertos++;
    }

    public void registrarErro() {
        this.erros++;
    }

    public double getTaxaAcerto() {
        int total = acertos + erros;
        if (total == 0) return 0;
        return (double) acertos / total * 100;
    }

    @Override
    public String toString() {
        return "Flashcard{" +
                "id=" + id +
                ", pergunta='" + pergunta + '\'' +
                ", categoria='" + categoria + '\'' +
                ", dificuldade=" + dificuldade +
                ", acertos=" + acertos +
                ", erros=" + erros +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flashcard that = (Flashcard) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
