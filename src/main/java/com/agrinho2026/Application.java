package com.agrinho2026;

import com.agrinho2026.data.FlashcardDatabase;
import com.agrinho2026.model.FlashcardDeck;
import com.agrinho2026.ui.ConsoleUI;

/**
 * Classe principal da aplicação Agrinho 2026 Flashcards
 * Inicializa o sistema de estudo com flashcards
 */
public class Application {

    public static void main(String[] args) {
        // Carregar os flashcards do banco de dados
        FlashcardDeck deck = FlashcardDatabase.carregarFlashcardsAgrinho2026();

        // Criar a interface de usuário
        ConsoleUI ui = new ConsoleUI(deck);

        // Iniciar o menu principal
        ui.exibirMenuPrincipal();
    }
}
