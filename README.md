# 🌱 Agrinho 2026 - Sistema de Flashcards

Um sistema interativo de flashcards desenvolvido em **Java** para estudar sobre **Educação Ambiental em Equilíbrio com Produção**, focado no programa Agrinho 2026.

## 📚 Características

- ✅ **20 flashcards** cobrindo temas de educação ambiental e produção sustentável
- ✅ **Interface em console** intuitiva e amigável
- ✅ **Modo de estudo aleatório** para revisar de forma desafiadora
- ✅ **Estudo por categoria** com filtros específicos
- ✅ **Flashcards para revisar** - identifica questões com mais erros
- ✅ **Estatísticas detalhadas** de desempenho
- ✅ **Rastreamento de acertos e erros** para cada flashcard
- ✅ **Testes unitários** cobrindo toda a lógica
- ✅ **Código bem documentado** e estruturado

## 🎯 Temas Abordados

O sistema contém flashcards divididos nas seguintes categorias:

1. **Sustentabilidade** - Conceitos fundamentais de desenvolvimento sustentável
2. **Produção Agrícola** - Práticas agrícolas sustentáveis
3. **Impacto Ambiental** - Efeitos da agricultura no meio ambiente
4. **Práticas Sustentáveis** - Técnicas e métodos ecoamigáveis
5. **Educação Ambiental** - Importância da conscientização
6. **Recursos Naturais** - Conservação e manejo de recursos

## 🚀 Como Usar

### Pré-requisitos

- Java 11 ou superior
- Maven 3.6 ou superior

### Compilar o Projeto

```bash
mvn clean compile
```

### Executar a Aplicação

```bash
mvn exec:java -Dexec.mainClass="com.agrinho2026.Application"
```

Ou criar um JAR executável:

```bash
mvn clean package
java -jar target/flashcards-system-1.0.0.jar
```

### Executar Testes

```bash
mvn test
```

## 📋 Menu Principal

Ao iniciar a aplicação, você terá acesso aos seguintes menus:

```
╔════════════════════════════════════════╗
║         MENU PRINCIPAL                 ║
╠════════════════════════════════════════╣
║ 1. Estudar Modo Aleatório              ║
║ 2. Estudar por Categoria               ║
║ 3. Estudar Flashcards que Errei        ║
║ 4. Ver Estatísticas                    ║
║ 5. Ver Todas as Categorias             ║
║ 6. Sair                                ║
╚════════════════════════════════════════╝
```

### Opções Explicadas

#### 1️⃣ Estudar Modo Aleatório
- Flashcards são apresentados em ordem aleatória
- Perfeito para revisar todo o conteúdo
- Você marca acertos ou erros manualmente

#### 2️⃣ Estudar por Categoria
- Escolha uma categoria específica
- Estude apenas os tópicos que deseja
- Ótimo para focar em áreas mais fracas

#### 3️⃣ Estudar Flashcards que Errei
- Identifica automaticamente questões com mais erros
- Ajuda na revisão direcionada
- Melhora sua performance

#### 4️⃣ Ver Estatísticas
- Taxa de acerto geral
- Estatísticas por categoria
- Progresso total de estudos

#### 5️⃣ Ver Todas as Categorias
- Lista todas as categorias disponíveis
- Mostra quantidade de flashcards por categoria
- Facilita planejamento de estudo

## 📁 Estrutura do Projeto

```
agrinho2026/
├── pom.xml
├── README.md
└── src/
    ├── main/java/com/agrinho2026/
    │   ├── Application.java              # Entrada da aplicação
    │   ├── model/
    │   │   ├── Flashcard.java            # Modelo de flashcard
    │   │   └── FlashcardDeck.java        # Gerenciador de flashcards
    │   ├── data/
    │   │   └── FlashcardDatabase.java    # Base de dados de flashcards
    │   └── ui/
    │       └── ConsoleUI.java            # Interface em console
    └── test/java/com/agrinho2026/
        └── model/
            ├── FlashcardTest.java        # Testes do Flashcard
            └── FlashcardDeckTest.java    # Testes do Deck
```

## 🛠️ Classes Principais

### `Flashcard`
Representa um flashcard individual com:
- ID único
- Pergunta e resposta
- Categoria
- Nível de dificuldade (1-5 ⭐)
- Contador de acertos e erros
- Taxa de acerto calculada

### `FlashcardDeck`
Gerencia uma coleção de flashcards:
- Adicionar/remover flashcards
- Filtrar por categoria ou dificuldade
- Obter flashcards aleatórios
- Calcular estatísticas globais
- Identificar flashcards para revisar

### `ConsoleUI`
Interface interativa em console:
- Menu principal navegável
- Modo estudo interativo
- Exibição de estatísticas
- Entrada de usuário validada

### `FlashcardDatabase`
Fornece dados iniciais:
- 20 flashcards pré-carregados
- Categorias estruturadas
- Conteúdo educacional verificado

## 📊 Exemplo de Uso

```
❓ O que significa desenvolvimento sustentável?

Digite sua resposta (ou pressione Enter para ver a resposta): 

✅ RESPOSTA CORRETA:
É o desenvolvimento que atende às necessidades do presente sem 
comprometer a capacidade das gerações futuras de atenderem às 
suas próprias necessidades.

Você acertou? (s/n): s

🎉 Excelente! +1 acerto

Deseja continuar estudando? (s/n): s
```

## 🧪 Testes

O projeto inclui testes unitários para:

- **FlashcardTest**: Testa criação, registro de acertos/erros, cálculo de taxa
- **FlashcardDeckTest**: Testa gerenciamento de coleções e estatísticas

Rode os testes com:
```bash
mvn test
```

## 🌟 Funcionalidades Futuras

- [ ] Persistência em arquivo (salvar progresso)
- [ ] Modo de múltipla escolha
- [ ] Sistema de ranking/pontuação
- [ ] Sincronização com banco de dados
- [ ] Interface gráfica (Swing/JavaFX)
- [ ] API REST para integração
- [ ] Mais flashcards dinâmicos

## 📝 Contribuindo

Para adicionar novos flashcards, edite a classe `FlashcardDatabase.java`:

```java
deck.adicionarFlashcard(new Flashcard(
    21,  // ID único
    "Sua pergunta aqui?",
    "Sua resposta aqui",
    "Categoria",
    2    // Dificuldade 1-5
));
```

## 📄 Licença

Este projeto é de código aberto e pode ser livremente utilizado para fins educacionais.

## 🤝 Autor

Desenvolvido como parte do programa **Agrinho 2026** para promover educação ambiental.

## 🌍 Sobre o Agrinho

O Agrinho é um programa de educação ambiental que visa promover a sustentabilidade no agronegócio, integrando educação ambiental com práticas agrícolas responsáveis.

---

**Estude com dedicação! 🌱📚**
