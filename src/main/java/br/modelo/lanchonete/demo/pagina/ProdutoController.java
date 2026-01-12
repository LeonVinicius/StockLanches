package br.modelo.lanchonete.demo.pagina;

import br.modelo.lanchonete.demo.model.Produto;
import br.modelo.lanchonete.demo.service.HistoricoService;
import br.modelo.lanchonete.demo.service.ProdutoService;
import br.modelo.lanchonete.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProdutoController {

    @Autowired private UsuarioService usuarioService;
    @Autowired private ProdutoService produtoService;
    @Autowired private HistoricoService historicoService;

    
    private void setupModel(Model model, String page) {
        model.addAttribute("nomeUsuario", usuarioService.getUsuarioLogado().getUsuario());
        model.addAttribute("emailUsuario", usuarioService.getUsuarioLogado().getEmail());
        model.addAttribute("activePage", page);
    }

   
    @GetMapping("/adicionar")
    public String adicionar(Model model) {
        if (!usuarioService.isUserLogged()) return "redirect:/login";
        setupModel(model, "adicionar");
        return "produto-adicionar";
    }

    @PostMapping("/adicionar")
    public String processarAdicionar(Produto produto, RedirectAttributes ra) {
        if (!usuarioService.isUserLogged()) return "redirect:/login";
        
        produtoService.adicionar(produto);
        historicoService.registrar("Entrada", produto.getNome(), produto.getQuantidade(), usuarioService.getUsuarioLogado().getUsuario());
        
        ra.addFlashAttribute("mensagemSucesso", "Produto cadastrado com sucesso!");
        return "redirect:/adicionar";
    }

    
    @GetMapping("/consultar")
    public String consultar(Model model, 
                            @RequestParam(required = false) String busca,
                            @RequestParam(required = false) String categoria,
                            @RequestParam(required = false) String ordenar) {
        if (!usuarioService.isUserLogged()) return "redirect:/login";
        setupModel(model, "consultar");
        
        model.addAttribute("produtos", produtoService.filtrar(busca, categoria, ordenar));
        model.addAttribute("buscaAtual", busca);
        model.addAttribute("categoriaAtual", categoria);
        model.addAttribute("ordenacaoAtual", ordenar);
        
        return "produto-consultar";
    }

    
    @GetMapping("/editar")
    public String editar(Model model, @RequestParam(required = false) String busca) {
        if (!usuarioService.isUserLogged()) return "redirect:/login";
        setupModel(model, "editar");
        
        Produto p = new Produto();
        if (busca != null && !busca.isEmpty()) {
            Produto encontrado = produtoService.buscarPrimeiroPorNome(busca);
            if (encontrado != null) {
                p = encontrado;
                model.addAttribute("mensagemSucesso", "Produto encontrado!");
            } else {
                model.addAttribute("mensagemErro", "Produto não encontrado.");
            }
            model.addAttribute("buscaAtual", busca);
        }
        model.addAttribute("produto", p);
        return "produto-editar";
    }

    @PostMapping("/editar")
    public String processarEditar(Produto produto, RedirectAttributes ra) {
        if (!usuarioService.isUserLogged()) return "redirect:/login";
        
        produtoService.atualizar(produto);
        historicoService.registrar("Edição", produto.getNome(), produto.getQuantidade(), usuarioService.getUsuarioLogado().getUsuario());
        
        ra.addFlashAttribute("mensagemSucesso", "Produto atualizado!");
        return "redirect:/consultar";
    }

    
    @GetMapping("/excluir")
    public String excluir(Model model, @RequestParam(required = false) String busca) {
        if (!usuarioService.isUserLogged()) return "redirect:/login";
        setupModel(model, "excluir");
        
        model.addAttribute("produtos", produtoService.filtrar(busca, null, null));
        model.addAttribute("buscaAtual", busca);
        return "produto-excluir";
    }

    @PostMapping("/excluir/remover")
    public String processarExcluir(@RequestParam Long id, RedirectAttributes ra) {
        if (!usuarioService.isUserLogged()) return "redirect:/login";
        
        Produto p = produtoService.buscarPorId(id);
        if (p != null) {
            historicoService.registrar("Saída", p.getNome(), p.getQuantidade(), usuarioService.getUsuarioLogado().getUsuario());
            produtoService.remover(id);
            ra.addFlashAttribute("mensagemSucesso", "Produto removido!");
        }
        return "redirect:/excluir";
    }

   
    @GetMapping("/historico")
    public String historico(Model model, @RequestParam(required = false) String tipoFiltro) {
        if (!usuarioService.isUserLogged()) return "redirect:/login";
        setupModel(model, "historico");
        
        model.addAttribute("historicoLogs", historicoService.listar(tipoFiltro));
        return "historico";
    }
}