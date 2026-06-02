// ==========================================
// VARIÁVEIS GLOBAIS
// ==========================================

let currentCardIndex = 0;
let totalCards = 20;
let isFlipped = false;

// ==========================================
// INTERAÇÃO COM FLASHCARDS
// ==========================================

// Flipar o card ao clicar
document.addEventListener('DOMContentLoaded', function() {
    const flashcard = document.getElementById('flashcard');
    if (flashcard) {
        flashcard.addEventListener('click', function() {
            flipCard();
        });
    }
});

function flipCard() {
    isFlipped = !isFlipped;
    const flashcardInner = document.querySelector('.flashcard-inner');
    if (isFlipped) {
        flashcardInner.style.transform = 'rotateY(180deg)';
    } else {
        flashcardInner.style.transform = 'rotateY(0deg)';
    }
}

// Navegar entre cards
function nextCard() {
    if (currentCardIndex < totalCards - 1) {
        currentCardIndex++;
        updateCardDisplay();
    } else {
        showNotification('Você chegou ao último flashcard!', 'info');
    }
}

function previousCard() {
    if (currentCardIndex > 0) {
        currentCardIndex--;
        updateCardDisplay();
    } else {
        showNotification('Você está no primeiro flashcard!', 'info');
    }
}

function updateCardDisplay() {
    const currentDisplay = document.getElementById('current-card');
    if (currentDisplay) {
        currentDisplay.textContent = currentCardIndex + 1;
    }
    resetFlipCard();
}

function resetFlipCard() {
    isFlipped = false;
    const flashcardInner = document.querySelector('.flashcard-inner');
    if (flashcardInner) {
        flashcardInner.style.transform = 'rotateY(0deg)';
    }
}

// ==========================================
// MARCAÇÃO DE RESPOSTAS
// ==========================================

function markCorrect() {
    showNotification('✅ Acerto registrado! Parabéns!', 'success');
    setTimeout(() => {
        nextCard();
    }, 800);
}

function markWrong() {
    showNotification('❌ Erro registrado. Estude mais este tópico!', 'danger');
    setTimeout(() => {
        nextCard();
    }, 800);
}

// ==========================================
// MODOS DE ESTUDO
// ==========================================

function startRandomMode() {
    showNotification('🎲 Iniciando Modo Aleatório...', 'info');
    currentCardIndex = 0;
    updateCardDisplay();
    scrollToSection('estudar');
}

function startCategoryMode() {
    showNotification('📁 Escolha uma categoria para estudar!', 'info');
    // Placeholder para seleção de categoria
}

function startReviewMode() {
    showNotification('🔄 Iniciando Revisão de Erros...', 'info');
    currentCardIndex = 0;
    updateCardDisplay();
    scrollToSection('estudar');
}

// ==========================================
// NAVEGAÇÃO
// ==========================================

function scrollToSection(sectionId) {
    const section = document.getElementById(sectionId);
    if (section) {
        section.scrollIntoView({ behavior: 'smooth' });
    }
}

// Atualizar link ativo da navbar ao rolar
window.addEventListener('scroll', updateActiveNavLink);

function updateActiveNavLink() {
    const sections = document.querySelectorAll('section');
    const navLinks = document.querySelectorAll('.nav-link');

    let current = '';
    sections.forEach(section => {
        const sectionTop = section.offsetTop;
        const sectionHeight = section.clientHeight;
        if (pageYOffset >= sectionTop - 200) {
            current = section.getAttribute('id');
        }
    });

    navLinks.forEach(link => {
        link.classList.remove('active');
        if (link.getAttribute('href').substring(1) === current) {
            link.classList.add('active');
        }
    });
}

// ==========================================
// FAQ
// ==========================================

function toggleFaq(element) {
    const faqItem = element.parentElement;
    const answer = faqItem.querySelector('.faq-answer');
    
    // Fechar outros itens abertos
    document.querySelectorAll('.faq-item').forEach(item => {
        if (item !== faqItem) {
            item.querySelector('.faq-answer').classList.remove('show');
            item.querySelector('.faq-question').classList.remove('active');
        }
    });
    
    // Toggle do item atual
    element.classList.toggle('active');
    answer.classList.toggle('show');
}

// ==========================================
// NOTIFICAÇÕES
// ==========================================

function showNotification(message, type = 'info') {
    // Criar elemento de notificação
    const notification = document.createElement('div');
    notification.className = `notification notification-${type}`;
    notification.textContent = message;
    
    // Estilos inline
    const styles = {
        position: 'fixed',
        top: '20px',
        right: '20px',
        padding: '15px 25px',
        borderRadius: '8px',
        color: 'white',
        fontSize: '1rem',
        fontWeight: '600',
        zIndex: '1000',
        animation: 'slideInRight 0.3s ease',
        boxShadow: '0 4px 12px rgba(0, 0, 0, 0.15)',
        maxWidth: '90vw'
    };

    const typeStyles = {
        success: { backgroundColor: '#4CAF50' },
        danger: { backgroundColor: '#f44336' },
        info: { backgroundColor: '#2196F3' },
        warning: { backgroundColor: '#ff9800' }
    };

    Object.assign(notification.style, styles);
    Object.assign(notification.style, typeStyles[type] || typeStyles.info);

    document.body.appendChild(notification);

    // Remover após 3 segundos
    setTimeout(() => {
        notification.style.animation = 'slideOutRight 0.3s ease';
        setTimeout(() => {
            notification.remove();
        }, 300);
    }, 3000);
}

// ==========================================
// ESTATÍSTICAS (SIMULADAS)
// ==========================================

function updateStatistics() {
    // Aqui você pode adicionar lógica para atualizar estatísticas
    // quando integrado com backend Java
    console.log('Atualizando estatísticas...');
}

// ==========================================
// TEMAS / MODO ESCURO
// ==========================================

function toggleDarkMode() {
    document.body.classList.toggle('dark-mode');
    localStorage.setItem('theme', document.body.classList.contains('dark-mode') ? 'dark' : 'light');
}

// Carregar tema salvo
window.addEventListener('load', () => {
    const savedTheme = localStorage.getItem('theme');
    if (savedTheme === 'dark') {
        document.body.classList.add('dark-mode');
    }
});

// ==========================================
// ANIMAÇÕES CSS VIA JS
// ==========================================

const style = document.createElement('style');
style.textContent = `
    @keyframes slideInRight {
        from {
            opacity: 0;
            transform: translateX(30px);
        }
        to {
            opacity: 1;
            transform: translateX(0);
        }
    }

    @keyframes slideOutRight {
        from {
            opacity: 1;
            transform: translateX(0);
        }
        to {
            opacity: 0;
            transform: translateX(30px);
        }
    }

    .notification {
        animation: slideInRight 0.3s ease !important;
    }
`;
document.head.appendChild(style);

// ==========================================
// ARMAZENAMENTO LOCAL
// ==========================================

class LocalStorage {
    static saveProgress(cardId, isCorrect) {
        const progress = JSON.parse(localStorage.getItem('flashcardProgress')) || {};
        progress[cardId] = {
            correct: (progress[cardId]?.correct || 0) + (isCorrect ? 1 : 0),
            wrong: (progress[cardId]?.wrong || 0) + (isCorrect ? 0 : 1),
            lastReviewed: new Date().toISOString()
        };
        localStorage.setItem('flashcardProgress', JSON.stringify(progress));
    }

    static getProgress(cardId) {
        const progress = JSON.parse(localStorage.getItem('flashcardProgress')) || {};
        return progress[cardId] || { correct: 0, wrong: 0 };
    }

    static getAllProgress() {
        return JSON.parse(localStorage.getItem('flashcardProgress')) || {};
    }

    static clearProgress() {
        localStorage.removeItem('flashcardProgress');
    }
}

// ==========================================
// INICIALIZAÇÃO
// ==========================================

document.addEventListener('DOMContentLoaded', function() {
    // Inicializar contador de cards
    const totalCardsDisplay = document.getElementById('total-cards');
    if (totalCardsDisplay) {
        totalCardsDisplay.textContent = totalCards;
    }

    const currentCardDisplay = document.getElementById('current-card');
    if (currentCardDisplay) {
        currentCardDisplay.textContent = currentCardIndex + 1;
    }

    // Inicializar tooltip do flashcard
    const flashcard = document.querySelector('.flashcard');
    if (flashcard) {
        flashcard.title = 'Clique para virar o cartão';
    }

    console.log('Agrinho 2026 - Sistema de Flashcards carregado! 🌱');
});

// ==========================================
// UTILITÁRIOS
// ==========================================

// Função para simular dados de servidor
function fetchFlashcards() {
    // Placeholder para integração com backend Java
    return [
        {
            id: 1,
            question: "O que significa desenvolvimento sustentável?",
            answer: "É o desenvolvimento que atende às necessidades do presente sem comprometer a capacidade das gerações futuras de atenderem às suas próprias necessidades.",
            category: "Sustentabilidade",
            difficulty: 2
        },
        // Adicione mais flashcards aqui
    ];
}

// Log para debug
console.log('JavaScript carregado com sucesso!');
