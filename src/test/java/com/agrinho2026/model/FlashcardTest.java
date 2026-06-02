package com.agrinho2026.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testes unitários para a classe Flashcard
 */
public class FlashcardTest {
    
    private Flashcard flashcard;

    @Before
    public void setUp() {
        flashcard = new Flashcard(1, 
                "O que é sustentabilidade?",
                "É o desenvolvimento que atende às necessidades do presente...",
                "Sustentabilidade",
                2);
    }

    @Test
    public void testCriarFlashcard() {
        assertNotNull(flashcard);
        assertEquals(1, flashcard.getId());
        assertEquals("Sustentabilidade", flashcard.getCategoria());
        assertEquals(2, flashcard.getDificuldade());
    }

    @Test
    public void testRegistrarAcerto() {
        assertEquals(0, flashcard.getAcertos());
        flashcard.registrarAcerto();
        assertEquals(1, flashcard.getAcertos());
    }

    @Test
    public void testRegistrarErro() {
        assertEquals(0, flashcard.getErros());
        flashcard.registrarErro();
        assertEquals(1, flashcard.getErros());
    }

    @Test
    public void testCalcularTaxaAcerto() {
        assertEquals(0, flashcard.getTaxaAcerto(), 0.01);
        
        flashcard.registrarAcerto();
        flashcard.registrarAcerto();
        flashcard.registrarErro();
        
        assertEquals(66.67, flashcard.getTaxaAcerto(), 1);
    }

    @Test
    public void testEqualsComMesmoId() {
        Flashcard outro = new Flashcard(1, "Outra pergunta", "Outra resposta", "Outra categoria", 3);
        assertEquals(flashcard, outro);
    }

    @Test
    public void testEqualsComIdDiferente() {
        Flashcard outro = new Flashcard(2, 
                "O que é sustentabilidade?",
                "É o desenvolvimento que atende às necessidades do presente...",
                "Sustentabilidade",
                2);
        assertNotEquals(flashcard, outro);
    }

    @Test
    public void testHashCode() {
        Flashcard outro = new Flashcard(1, "Qualquer coisa", "Qualquer coisa", "Qualquer coisa", 1);
        assertEquals(flashcard.hashCode(), outro.hashCode());
    }
}
