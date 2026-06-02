package com.agrinho2026.model;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Classe que gerencia um baralho de flashcards
 * Fornece métodos para adicionar, remover, filtrar e estudar flashcards
 */
public class FlashcardDeck {
    private List<Flashcard> flashcards;
    private String nomeDeck;
    private String descricao;

    public FlashcardDeck(String nomeDeck, String descricao) {
        this.nomeDeck = nomeDeck;
        this.descricao = descricao;
        this.flashcards = new ArrayList<>();
    }

    // Métodos de gerenciamento de flashcards
    public void adicionarFlashcard(Flashcard flashcard) {
        if (flashcard != null) {
            flashcards.add(flashcard);
        }
    }

    public void removerFlashcard(int id) {
        flashcards.removeIf(f -> f.getId() == id);
    }

    public Flashcard obterFlashcard(int id) {
        return flashcards.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Flashcard> obterTodos() {
        return new ArrayList<>(flashcards);
    }

    public List<Flashcard> obterPorCategoria(String categoria) {
        return flashcards.stream()
                .filter(f -> f.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
    }

    public List<Flashcard> obterPorDificuldade(int dificuldade) {
        return flashcards.stream()
                .filter(f -> f.getDificuldade() == dificuldade)
                .collect(Collectors.toList());
    }

    public List<String> obterCategorias() {
        return flashcards.stream()
                .map(Flashcard::getCategoria)
                .distinct()
                .collect(Collectors.toList());
    }

    // Métodos de estudo
    public Flashcard obterFlashcardAleatorio() {
        if (flashcards.isEmpty()) return null;
        Random random = new Random();
        return flashcards.get(random.nextInt(flashcards.size()));
    }

    public Flashcard obterFlashcardAleatorioPoCategoria(String categoria) {
        List<Flashcard> porCategoria = obterPorCategoria(categoria);
        if (porCategoria.isEmpty()) return null;
        Random random = new Random();
        return porCategoria.get(random.nextInt(porCategoria.size()));
    }

    public List<Flashcard> obterFlashcardsQueNecessitamRevista() {
        return flashcards.stream()
                .filter(f -> f.getErros() > f.getAcertos())
                .sorted(Comparator.comparingInt(Flashcard::getErros).reversed())
                .collect(Collectors.toList());
    }

    // Métodos de estatísticas
    public int getTotalFlashcards() {
        return flashcards.size();
    }

    public double getTaxaAcertoGeral() {
        if (flashcards.isEmpty()) return 0;
        return flashcards.stream()
                .mapToDouble(Flashcard::getTaxaAcerto)
                .average()
                .orElse(0);
    }

    public int getTotalAcertos() {
        return flashcards.stream().mapToInt(Flashcard::getAcertos).sum();
    }

    public int getTotalErros() {
        return flashcards.stream().mapToInt(Flashcard::getErros).sum();
    }

    // Getters e Setters
    public String getNomeDeck() {
        return nomeDeck;
    }

    public void setNomeDeck(String nomeDeck) {
        this.nomeDeck = nomeDeck;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void limpar() {
        flashcards.clear();
    }

    @Override
    public String toString() {
        return "FlashcardDeck{" +
                "nomeDeck='" + nomeDeck + '\'' +
                ", totalFlashcards=" + getTotalFlashcards() +
                ", acertos=" + getTotalAcertos() +
                ", erros=" + getTotalErros() +
                '}';
    }
}
