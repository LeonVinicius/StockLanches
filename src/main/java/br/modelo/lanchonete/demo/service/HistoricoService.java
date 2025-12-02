package br.modelo.lanchonete.demo.service;

import br.modelo.lanchonete.demo.model.HistoricoLog;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoricoService {
    private List<HistoricoLog> listaHistorico = new ArrayList<>();

    public void registrar(String tipo, String nomeProduto, Integer qtd, String usuarioResponsavel) {
        listaHistorico.add(0, new HistoricoLog(tipo, nomeProduto, qtd, usuarioResponsavel));
    }

    public List<HistoricoLog> listar(String filtroTipo) {
        if (filtroTipo != null && !filtroTipo.equals("Todas")) {
            return listaHistorico.stream()
                    .filter(h -> h.getTipo().equalsIgnoreCase(filtroTipo))
                    .collect(Collectors.toList());
        }
        return listaHistorico;
    }
}