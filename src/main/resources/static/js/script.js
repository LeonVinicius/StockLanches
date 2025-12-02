document.addEventListener('DOMContentLoaded', function() {
    // Cores globais
    Chart.defaults.color = '#94a3b8';
    Chart.defaults.borderColor = '#334155';

    // --- 1. CAPTURAR DADOS DO HTML (Hidden Inputs) ---
    const qtdLanches = document.getElementById('data-lanches').value;
    const qtdBebidas = document.getElementById('data-bebidas').value;
    const qtdSobremesas = document.getElementById('data-sobremesas').value;
    const qtdAcomp = document.getElementById('data-acomp').value;

    const top5NomesRaw = document.getElementById('data-top5-nomes').value;
    const top5QtdRaw = document.getElementById('data-top5-qtd').value;

    // Converte as strings separadas por vírgula em Arrays reais
    // Se a lista estiver vazia, evita erro criando array vazio
    const top5Nomes = top5NomesRaw ? top5NomesRaw.split(',') : [];
    const top5Qtd = top5QtdRaw ? top5QtdRaw.split(',') : [];

    // --- 2. GRÁFICO DE PIZZA ---
    const ctxPizza = document.getElementById('graficoPizza').getContext('2d');
    new Chart(ctxPizza, {
        type: 'pie',
        data: {
            labels: ['Lanches', 'Bebidas', 'Sobremesas', 'Acompanhamentos'],
            datasets: [{
                data: [qtdLanches, qtdBebidas, qtdSobremesas, qtdAcomp], // Dados dinâmicos aqui
                backgroundColor: ['#3b82f6', '#10b981', '#f59e0b', '#a855f7'],
                borderWidth: 0
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            plugins: { legend: { position: 'right' } }
        }
    });

    // --- 3. GRÁFICO DE BARRAS ---
    const ctxBarras = document.getElementById('graficoBarras').getContext('2d');
    new Chart(ctxBarras, {
        type: 'bar',
        data: {
            labels: top5Nomes, // Nomes dinâmicos
            datasets: [{
                label: 'Qtd. Estoque',
                data: top5Qtd, // Quantidades dinâmicas
                backgroundColor: '#ef4444',
                borderRadius: 4,
                barThickness: 20
            }]
        },
        options: {
            indexAxis: 'y',
            responsive: true,
            maintainAspectRatio: false,
            plugins: { legend: { display: false } },
            scales: { x: { beginAtZero: true, grid: { display: false } } }
        }
    });
});