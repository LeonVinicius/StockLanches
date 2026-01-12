package br.modelo.lanchonete.demo.pagina;

import br.modelo.lanchonete.demo.model.Produto;
import br.modelo.lanchonete.demo.service.ProdutoService;
import br.modelo.lanchonete.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DashboardController {

    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/home")
    public String home(Model model) {
        if (!usuarioService.isUserLogged()) return "redirect:/login";
        
       
        model.addAttribute("nomeUsuario", usuarioService.getUsuarioLogado().getUsuario());
        model.addAttribute("emailUsuario", usuarioService.getUsuarioLogado().getEmail());
        model.addAttribute("activePage", "dashboard");

        List<Produto> lista = produtoService.listarTodos();

        
        model.addAttribute("totalProdutos", lista.size());
        
        long countBaixo = lista.stream().filter(p -> p.getQuantidade() <= (p.getEstoqueMinimo() != null ? p.getEstoqueMinimo() : 5)).count();
        model.addAttribute("produtosBaixoEstoque", countBaixo);
        
        double valorTotal = lista.stream().mapToDouble(p -> p.getQuantidade() * p.getPrecoVenda()).sum();
        model.addAttribute("valorTotalEstoque", valorTotal);
        
        model.addAttribute("agora", LocalDateTime.now());

       
        model.addAttribute("qtdLanches", lista.stream().filter(p -> "Lanches".equalsIgnoreCase(p.getCategoria())).count());
        model.addAttribute("qtdBebidas", lista.stream().filter(p -> "Bebidas".equalsIgnoreCase(p.getCategoria())).count());
        model.addAttribute("qtdSobremesas", lista.stream().filter(p -> "Sobremesas".equalsIgnoreCase(p.getCategoria())).count());
        model.addAttribute("qtdAcomp", lista.stream().filter(p -> "Acompanhamentos".equalsIgnoreCase(p.getCategoria())).count());

      
        List<Produto> top5 = lista.stream().sorted(Comparator.comparing(Produto::getQuantidade)).limit(5).collect(Collectors.toList());
        model.addAttribute("nomesTop5", top5.stream().map(Produto::getNome).collect(Collectors.toList()));
        model.addAttribute("qtdTop5", top5.stream().map(Produto::getQuantidade).collect(Collectors.toList()));

        
        model.addAttribute("listaProdutos", lista);

        return "home";
    }
}