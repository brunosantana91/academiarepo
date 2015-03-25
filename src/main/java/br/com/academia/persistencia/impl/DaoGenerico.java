package br.com.academia.persistencia.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.academia.persistencia.DaoInterface;


@Transactional(propagation=Propagation.SUPPORTS)
public abstract class DaoGenerico<T> implements DaoInterface<T> {
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sf) {sessionFactory = sf;}
	
	protected Session getSession() {
		return getSessionFactory().getCurrentSession();
	}
	
	@SuppressWarnings("rawtypes")
	protected abstract Class getClazz();
	
	
	public void adicionar(T objeto) {
		getSession().saveOrUpdate(objeto);
	}
	
	public void remover(T objeto) {
		getSession().refresh(objeto);
		getSession().delete(objeto);
	}
	
	public void editar(T objeto){
		getSession().update(objeto);
	}
	
	@SuppressWarnings("unchecked")
	public T atualizar(T objeto){
		return (T) getSession().merge(objeto);
	}
	
	@SuppressWarnings("unchecked")
	public T buscarPorId(Integer id) {
		return (T) getSession().get(getClazz(), id);
	}
	
	@SuppressWarnings("unchecked")
	protected T buscarPorIdEager(Class<T> classe, Integer id, String... listasLazy){
		Criteria c = getSession().createCriteria(classe);
		c.add(Restrictions.idEq(id));
		for(int i = 0; i < listasLazy.length; i++){
		c.setFetchMode(listasLazy[i], FetchMode.JOIN);
		}
		return (T) c.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<T> listar(){
		return getSession().createCriteria(getClazz()).list();
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> listarEager(Class<T> classe, String... listasLazy){
		Criteria c = getSession().createCriteria(classe);
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		for(int i = 0; i < listasLazy.length; i++){
			c.setFetchMode(listasLazy[i], FetchMode.JOIN);
		}
		return (List<T>) c.list();
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> listarPorQuery(Class<T> classe, String query, Object... valores){
		Query q = criarQuery(query, valores);
		return q.list();
	}
	
	@SuppressWarnings("unchecked")
	protected T buscarPorQuery(Class<T> classe, String query, Object... valores){
		Query q = criarQuery(query, valores);
		return (T) q.uniqueResult();
	}
	
	protected Query criarQuery(String query, Object...valores){
		Query q = getSession().createQuery(query);
		for(int i = 0; i < valores.length; i++){
			q.setParameter(i, valores[i]);
		}
		return q;
	}


}
