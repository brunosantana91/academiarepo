package br.com.academia.persistencia;

import java.util.List;

import br.com.academia.entidades.Pagamento;
import br.com.academia.entidades.Perfil;

public interface DaoPagamento extends DaoInterface<Pagamento> {
	
	List<Pagamento> listarPagamentosPorPerfil(Perfil perfil);
	List<Pagamento> listarPagamentosPorSituacao(boolean pago);
}
