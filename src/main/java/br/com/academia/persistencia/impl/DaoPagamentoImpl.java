package br.com.academia.persistencia.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.academia.entidades.Pagamento;
import br.com.academia.entidades.Perfil;
import br.com.academia.persistencia.DaoPagamento;

@Transactional(propagation=Propagation.SUPPORTS)
@Repository("daoPagamento")
public class DaoPagamentoImpl extends DaoGenerico<Pagamento> implements DaoPagamento{

	public List<Pagamento> listarPagamentosPorPerfil(Perfil perfil) {
		return listarPorQuery(getClazz(), "SELECT p FROM Pagamento p WHERE p.perfil = ?", perfil);
	}

	public List<Pagamento> listarPagamentosPorSituacao(boolean pago) {
		return listarPorQuery(getClazz(), "SELECT p FROM Pagamento p WHERE p.pago = ?", pago);
	}

	@Override
	protected Class<Pagamento> getClazz() {
		return Pagamento.class;
	}

}
