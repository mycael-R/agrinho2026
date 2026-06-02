package com.agrinho2026.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Testes unitários para a classe FlashcardDeck
 */
public class FlashcardDeckTest {
    
    private FlashcardDeck deck;
    private Flashcard flashcard1;
    private Flashcard flashcard2;
    private Flashcard flashcard3;

    @Before
    public void setUp() {
        deck = new FlashcardDeck("Teste", "Deck de teste");
        
        flashcard1 = new Flashcard(1, "P1", "R1", "Categoria A", 1);
        flashcard2 = new Flashcard(2, "P2", "R2", "Categoria A", 2);
        flashcard3 = new Flashcard(3, "P3", "R3", "Categoria B", 3);
        
        deck.adicionarFlashcard(flashcard1);
        deck.adicionarFlashcard(flashcard2);
        deck.adicionarFlashcard(flashcard3);
    }

    @Test
    public void testAdicionarFlashcard() {
        assertEquals(3, deck.getTotalFlashcards());
    }

    @Test
    public void testRemoverFlashcard() {
        deck.removerFlashcard(1);
        assertEquals(2, deck.getTotalFlashcards());
        assertNull(deck.obterFlashcard(1));
    }

    @Test
    public void testObterFlashcard() {
        Flashcard obtido = deck.obterFlashcard(1);
        assertEquals(flashcard1, obtido);
    }

    @Test
    public void testObterPorCategoria() {
        List<Flashcard> categoriaA = deck.obterPorCategoria("Categoria A");
        assertEquals(2, categoriaA.size());
        
        List<Flashcard> categoriaB = deck.obterPorCategoria("Categoria B");
        assertEquals(1, categoriaB.size());
    }

    @Test
    public void testObterCategorias() {
        List<String> categorias = deck.obterCategorias();
        assertEquals(2, categorias.size());
        assertTrue(categorias.contains("Categoria A"));
        assertTrue(categorias.contains("Categoria B"));
    }

    @Test
    public void testObterFlashcardAleatorio() {
        Flashcard aleatorio = deck.obterFlashcardAleatorio();
        assertNotNull(aleatorio);
        assertTrue(aleatorio.getId() >= 1 && aleatorio.getId() <= 3);
    }

    @Test
    public void testObterFlashcardsQueNecessitamRevista() {
        flashcard1.registrarAcerto();
        flashcard1.registrarErro();
        flashcard1.registrarErro();
        
        flashcard2.registrarAcerto();
        flashcard2.registrarAcerto();
        
        List<Flashcard> paraRevisar = deck.obterFlashcardsQueNecessitamRevista();
        assertTrue(paraRevisar.contains(flashcard1));
        assertFalse(paraRevisar.contains(flashcard2));
    }

    @Test
    public void testGetTotalFlashcards() {
        assertEquals(3, deck.getTotalFlashcards());
    }

    @Test
    public void testGetTotalAcertos() {
        flashcard1.registrarAcerto();
        flashcard2.registrarAcerto();
        flashcard2.registrarAcerto();
        
        assertEquals(3, deck.getTotalAcertos());
    }

    @Test
    public void testGetTotalErros() {
        flashcard1.registrarErro();
        flashcard2.registrarErro();
        
        assertEquals(2, deck.getTotalErros());
    }

    @Test
    public void testLimpar() {
        deck.limpar();
        assertEquals(0, deck.getTotalFlashcards());
    }
}
