/* Arquivo: js/modal-detalhes.js */

function abrirModalDetalhes(nome, categoria, custo, fornecedor, descricao) {
    // 1. Preenche os campos do modal com os dados recebidos
    document.getElementById('m-nome').innerText = nome;
    document.getElementById('m-categoria').innerText = categoria;
    
    // 2. Formata o custo para dinheiro (R$)
    // Verifica se custo é um número válido, senão usa 0
    const valorCusto = parseFloat(custo) || 0;
    const custoFormatado = valorCusto.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });
    document.getElementById('m-custo').innerText = custoFormatado;
    
    // 3. Preenche fornecedor e descrição (com texto padrão se estiver vazio)
    document.getElementById('m-fornecedor').innerText = fornecedor || 'Não informado';
    document.getElementById('m-descricao').innerText = descricao || 'Nenhuma descrição disponível para este produto.';

    // 4. Mostra o modal na tela (alterando o display do CSS)
    const modal = document.getElementById('modalDetalhes');
    if (modal) {
        modal.style.display = 'flex';
    }
}

function fecharModalDetalhes(event) {
    const modal = document.getElementById('modalDetalhes');
    
    if (!modal) return;

    // Fecha se clicar:
    // 1. No fundo escuro (Overlay) -> event.target === modal
    // 2. Em qualquer botão dentro do modal (X ou Voltar) -> event.target.closest('button')
    if (event.target === modal || event.target.closest('button')) {
         modal.style.display = 'none';
    }
}