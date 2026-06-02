package com.agrinho2026.ui;

import com.agrinho2026.model.Flashcard;
import com.agrinho2026.model.FlashcardDeck;

import java.util.List;
import java.util.Scanner;

/**
 * Interface de usuário em console para o sistema de flashcards
 * Fornece menu interativo para estudar e gerenciar flashcards
 */
public class ConsoleUI {
    private FlashcardDeck deck;
    private Scanner scanner;

    public ConsoleUI(FlashcardDeck deck) {
        this.deck = deck;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenuPrincipal() {
        boolean continuar = true;

        while (continuar) {
            limparTela();
            exibirCabecalho();
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║         MENU PRINCIPAL                 ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║ 1. Estudar Modo Aleatório              ║");
            System.out.println("║ 2. Estudar por Categoria               ║");
            System.out.println("║ 3. Estudar Flashcards que Errei        ║");
            System.out.println("║ 4. Ver Estatísticas                    ║");
            System.out.println("║ 5. Ver Todas as Categorias             ║");
            System.out.println("║ 6. Sair                                ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.print("\nEscolha uma opção: ");

            int opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    estudarModoAleatorio();
                    break;
                case 2:
                    estudarPorCategoria();
                    break;
                case 3:
                    estudarFlashcardsQueErrei();
                    break;
                case 4:
                    exibirEstatisticas();
                    break;
                case 5:
                    exibirCategorias();
                    break;
                case 6:
                    continuar = false;
                    System.out.println("\nObrigado por estudar com Agrinho 2026! 🌱");
                    break;
                default:
                    System.out.println("\n❌ Opção inválida! Tente novamente.");
                    pausa();
            }
        }

        scanner.close();
    }

    private void estudarModoAleatorio() {
        limparTela();
        exibirCabecalho();
        System.out.println("\n📚 MODO ESTUDO - ALEATÓRIO\n");

        List<Flashcard> flashcards = deck.obterTodos();
        if (flashcards.isEmpty()) {
            System.out.println("❌ Nenhum flashcard disponível!");
            pausa();
            return;
        }

        boolean continuar = true;
        int count = 0;

        while (continuar) {
            Flashcard flashcard = deck.obterFlashcardAleatorio();
            count++;

            System.out.println("\n" + "=".repeat(50));
            System.out.println("Flashcard " + count + " de " + flashcards.size());
            System.out.println("=".repeat(50));
            System.out.println("\n[" + flashcard.getCategoria() + "] " +
                    "Dificuldade: " + "⭐".repeat(flashcard.getDificuldade()));
            System.out.println("\n❓ " + flashcard.getPergunta());
            System.out.print("\nDigite sua resposta (ou pressione Enter para ver a resposta): ");
            scanner.nextLine();

            System.out.println("\n✅ RESPOSTA CORRETA:\n" + flashcard.getResposta());
            System.out.println("\nVocê acertou? (s/n): ");
            String resposta = scanner.nextLine().toLowerCase();

            if (resposta.equals("s")) {
                flashcard.registrarAcerto();
                System.out.println("\n🎉 Excelente! +1 acerto");
            } else {
                flashcard.registrarErro();
                System.out.println("\n📌 Registrado como erro. Continuar estudando!");
            }

            System.out.print("\nDeseja continuar estudando? (s/n): ");
            resposta = scanner.nextLine().toLowerCase();
            continuar = resposta.equals("s");
        }
    }

    private void estudarPorCategoria() {
        limparTela();
        exibirCabecalho();
        System.out.println("\n📂 SELECIONE UMA CATEGORIA\n");

        List<String> categorias = deck.obterCategorias();
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println((i + 1) + ". " + categorias.get(i));
        }

        System.out.print("\nEscolha uma categoria: ");
        int escolha = lerInteiro() - 1;

        if (escolha < 0 || escolha >= categorias.size()) {
            System.out.println("❌ Categoria inválida!");
            pausa();
            return;
        }

        String categoria = categorias.get(escolha);
        List<Flashcard> flashcards = deck.obterPorCategoria(categoria);

        System.out.println("\n✓ " + flashcards.size() + " flashcards encontrados em \"" + categoria + "\"");
        pausa();

        estudarListaFlashcards(flashcards, categoria);
    }

    private void estudarFlashcardsQueErrei() {
        limparTela();
        exibirCabecalho();
        System.out.println("\n🔴 FLASHCARDS QUE VOCÊ ERROU\n");

        List<Flashcard> erros = deck.obterFlashcardsQueNecessitamRevista();

        if (erros.isEmpty()) {
            System.out.println("✅ Parabéns! Você acertou tudo!");
            pausa();
            return;
        }

        System.out.println("Encontrados " + erros.size() + " flashcards para revisar:\n");
        estudarListaFlashcards(erros, "Revisão");
    }

    private void estudarListaFlashcards(List<Flashcard> flashcards, String titulo) {
        boolean continuar = true;
        int index = 0;

        while (continuar && index < flashcards.size()) {
            Flashcard flashcard = flashcards.get(index);

            System.out.println("\n" + "=".repeat(50));
            System.out.println(titulo + " - Flashcard " + (index + 1) + " de " + flashcards.size());
            System.out.println("=".repeat(50));
            System.out.println("\n[" + flashcard.getCategoria() + "] " +
                    "Dificuldade: " + "⭐".repeat(flashcard.getDificuldade()));
            System.out.println("\n❓ " + flashcard.getPergunta());
            System.out.print("\nDigite sua resposta (ou pressione Enter para ver a resposta): ");
            scanner.nextLine();

            System.out.println("\n✅ RESPOSTA CORRETA:\n" + flashcard.getResposta());
            System.out.println("\nVocê acertou? (s/n): ");
            String resposta = scanner.nextLine().toLowerCase();

            if (resposta.equals("s")) {
                flashcard.registrarAcerto();
                System.out.println("\n🎉 Excelente!");
            } else {
                flashcard.registrarErro();
                System.out.println("\n📌 Erro registrado!");
            }

            System.out.print("\nProximar flashcard? (s/n): ");
            resposta = scanner.nextLine().toLowerCase();
            if (resposta.equals("s")) {
                index++;
            } else {
                continuar = false;
            }
        }
    }

    private void exibirEstatisticas() {
        limparTela();
        exibirCabecalho();
        System.out.println("\n📊 ESTATÍSTICAS GERAIS\n");

        int total = deck.getTotalFlashcards();
        int acertos = deck.getTotalAcertos();
        int erros = deck.getTotalErros();
        double taxa = deck.getTaxaAcertoGeral();

        System.out.println("╔════════════════════════════════════════╗");
        System.out.printf("║ Total de Flashcards: %-19d║\n", total);
        System.out.printf("║ Total de Acertos:    %-19d║\n", acertos);
        System.out.printf("║ Total de Erros:      %-19d║\n", erros);
        System.out.printf("║ Taxa de Acerto:      %-18.1f%%║\n", taxa);
        System.out.println("╚════════════════════════════════════════╝");

        System.out.println("\n📈 ESTATÍSTICAS POR CATEGORIA:\n");

        for (String categoria : deck.obterCategorias()) {
            List<Flashcard> porCategoria = deck.obterPorCategoria(categoria);
            double taxaCategoria = porCategoria.stream()
                    .mapToDouble(Flashcard::getTaxaAcerto)
                    .average()
                    .orElse(0);

            System.out.printf("%-30s: %.1f%% (%d flashcards)\n",
                    categoria, taxaCategoria, porCategoria.size());
        }

        pausa();
    }

    private void exibirCategorias() {
        limparTela();
        exibirCabecalho();
        System.out.println("\n🏷️  CATEGORIAS DISPONÍVEIS\n");

        List<String> categorias = deck.obterCategorias();
        for (int i = 0; i < categorias.size(); i++) {
            List<Flashcard> flashcards = deck.obterPorCategoria(categorias.get(i));
            System.out.printf("%d. %-30s (%d flashcards)\n",
                    i + 1, categorias.get(i), flashcards.size());
        }

        pausa();
    }

    private void exibirCabecalho() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║     🌱 AGRINHO 2026 FLASHCARDS 🌱     ║");
        System.out.println("║  Educação Ambiental em Equilíbrio com  ║");
        System.out.println("║          Produção                      ║");
        System.out.println("╚════════════════════════════════════════╝");
    }

    private int lerInteiro() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void pausa() {
        System.out.print("\nPressione Enter para continuar...");
        scanner.nextLine();
    }

    private void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
