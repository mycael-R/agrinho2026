package com.agrinho2026.data;

import com.agrinho2026.model.Flashcard;
import com.agrinho2026.model.FlashcardDeck;

/**
 * Classe que fornece dados de flashcards sobre Educação Ambiental
 * em Equilíbrio com Produção (Agrinho 2026)
 */
public class FlashcardDatabase {

    public static FlashcardDeck carregarFlashcardsAgrinho2026() {
        FlashcardDeck deck = new FlashcardDeck(
                "Agrinho 2026",
                "Educação Ambiental em Equilíbrio com Produção"
        );

        // Categoria: Sustentabilidade Ambiental
        deck.adicionarFlashcard(new Flashcard(1,
                "O que significa desenvolvimento sustentável?",
                "É o desenvolvimento que atende às necessidades do presente sem comprometer a capacidade das gerações futuras de atenderem às suas próprias necessidades.",
                "Sustentabilidade",
                2
        ));

        deck.adicionarFlashcard(new Flashcard(2,
                "Quais são os três pilares da sustentabilidade?",
                "Ambiental (preservação dos recursos naturais), Social (equidade e bem-estar) e Econômico (viabilidade financeira).",
                "Sustentabilidade",
                2
        ));

        deck.adicionarFlashcard(new Flashcard(3,
                "O que é pegada ecológica?",
                "É uma medida que calcula o quanto de área produtiva é necessária para manter o padrão de consumo de uma pessoa ou comunidade.",
                "Sustentabilidade",
                3
        ));

        // Categoria: Produção Agrícola Equilibrada
        deck.adicionarFlashcard(new Flashcard(4,
                "O que é agricultura sustentável?",
                "É um sistema de produção agrícola que busca aumentar a produtividade mantendo o equilíbrio ecológico e a viabilidade econômica.",
                "Produção Agrícola",
                2
        ));

        deck.adicionarFlashcard(new Flashcard(5,
                "Qual é a diferença entre agricultura convencional e orgânica?",
                "A agricultura convencional usa agrotóxicos e adubos químicos, enquanto a orgânica utiliza processos naturais e sem produtos químicos sintéticos.",
                "Produção Agrícola",
                3
        ));

        deck.adicionarFlashcard(new Flashcard(6,
                "O que é rotação de culturas?",
                "É uma prática agrícola que consiste em alternar diferentes culturas no mesmo terreno, melhorando a fertilidade do solo e reduzindo pragas.",
                "Produção Agrícola",
                2
        ));

        deck.adicionarFlashcard(new Flashcard(7,
                "Como a agroecologia contribui para a sustentabilidade?",
                "A agroecologia integra conhecimentos científicos e tradicionais, utiliza recursos naturais e promove a biodiversidade, melhorando a resiliência dos agroecossistemas.",
                "Produção Agrícola",
                4
        ));

        // Categoria: Impacto Ambiental da Agricultura
        deck.adicionarFlashcard(new Flashcard(8,
                "Quais são os principais impactos ambientais da agricultura intensiva?",
                "Erosão do solo, contaminação de água, desmatamento, perda de biodiversidade, emissão de gases de efeito estufa e salinização dos solos.",
                "Impacto Ambiental",
                3
        ));

        deck.adicionarFlashcard(new Flashcard(9,
                "Como o desmatamento afeta o equilíbrio ambiental?",
                "Reduz a biodiversidade, aumenta a emissão de CO2, altera o ciclo hidrológico, causa erosão do solo e prejudica comunidades que dependem da floresta.",
                "Impacto Ambiental",
                3
        ));

        deck.adicionarFlashcard(new Flashcard(10,
                "O que é contaminação de aquíferos e como a agricultura contribui?",
                "É a poluição das águas subterrâneas. A agricultura contribui através do uso excessivo de agrotóxicos e adubos que infiltram no solo.",
                "Impacto Ambiental",
                3
        ));

        // Categoria: Práticas Sustentáveis
        deck.adicionarFlashcard(new Flashcard(11,
                "O que é compostagem e qual é sua importância?",
                "É a decomposição controlada de resíduos orgânicos que gera adubo natural, reduzindo resíduos e melhorando a fertilidade do solo.",
                "Práticas Sustentáveis",
                2
        ));

        deck.adicionarFlashcard(new Flashcard(12,
                "Como a captação de água da chuva beneficia a produção agrícola?",
                "Reduz dependência de fontes de água, diminui custos de irrigação, permite produção em épocas secas e conserva recursos hídricos.",
                "Práticas Sustentáveis",
                2
        ));

        deck.adicionarFlashcard(new Flashcard(13,
                "O que é agricultura de precisão?",
                "É o uso de tecnologia (sensores, drones, GPS) para otimizar o uso de insumos, aumentar produtividade e reduzir impacto ambiental.",
                "Práticas Sustentáveis",
                3
        ));

        deck.adicionarFlashcard(new Flashcard(14,
                "Qual é o objetivo do Sistema Integrado de Produção Agroecológica (SIPA)?",
                "Integrar plantas, animais e florestamento em um único sistema que seja economicamente viável e ambientalmente sustentável.",
                "Práticas Sustentáveis",
                4
        ));

        // Categoria: Educação Ambiental
        deck.adicionarFlashcard(new Flashcard(15,
                "Qual é o objetivo principal da educação ambiental?",
                "Desenvolver consciência crítica sobre questões ambientais, promovendo mudanças de atitudes e comportamentos para uma sociedade sustentável.",
                "Educação Ambiental",
                2
        ));

        deck.adicionarFlashcard(new Flashcard(16,
                "Como a escola pode promover educação ambiental?",
                "Através de projetos ambientais, hortas escolares, disciplinas interdisciplinares, campanhas de conscientização e envolvimento da comunidade.",
                "Educação Ambiental",
                2
        ));

        deck.adicionarFlashcard(new Flashcard(17,
                "O que é a Agenda 2030 e seus Objetivos de Desenvolvimento Sustentável?",
                "É um plano de ação da ONU com 17 objetivos para erradicar a pobreza, proteger o planeta e garantir paz e prosperidade até 2030.",
                "Educação Ambiental",
                4
        ));

        // Categoria: Recursos Naturais
        deck.adicionarFlashcard(new Flashcard(18,
                "Qual é a importância da biodiversidade para a agricultura?",
                "A biodiversidade fornece polinizadores, controle natural de pragas, diversidade genética de culturas e resiliência aos agroecossistemas.",
                "Recursos Naturais",
                3
        ));

        deck.adicionarFlashcard(new Flashcard(19,
                "Como conservar o solo na produção agrícola?",
                "Através de cobertura vegetal, rotação de culturas, plantio direto, terraceamento, manutenção da matéria orgânica e redução de mecanização.",
                "Recursos Naturais",
                3
        ));

        deck.adicionarFlashcard(new Flashcard(20,
                "O que é reflorestamento e sua importância para a agricultura?",
                "É o replantio de áreas florestais que fornece proteção ao solo, regulariza ciclo hidrológico, sequestra carbono e oferece recursos para comunidades.",
                "Recursos Naturais",
                2
        ));

        return deck;
    }
}
