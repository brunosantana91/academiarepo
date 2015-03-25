package br.com.academia.beans.util.filters;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.academia.beans.LoginBean;
import br.com.academia.entidades.util.Permissoes;


//@WebFilter(filterName="filtroAutenticacao", urlPatterns = { "/*" })
@Component("filtroAutenticacao")
public class FiltroAutenticacao implements Filter {
	
	//
	@Autowired
	private LoginBean loginBean;

 
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		if(loginBean.getUsuarioLogado() == null){
			((HttpServletResponse)response).sendRedirect("/academia/index.xhtml");
			return;
		}
		
		//verifica autoriza��o de admin--------------------------------------------------------//
		String requestPathAdmin = ((HttpServletRequest)request).getRequestURI().toLowerCase();
		System.out.println("URI: "+requestPathAdmin);
		
		List<Permissoes> permissoes = loginBean.getUsuarioLogado().getPermissoes();
		//verificado por ausencia de permiss�o
		if(requestPathAdmin.contains("/admin/") && !permissoes.contains(Permissoes.ADMIN)){
			((HttpServletResponse)response).sendRedirect("/academia/noAccess.xhtml");
			return;
		}
		
		//-----------------------------------------------------------------------------------//
		
		//verifica autoriza��o de instrutor--------------------------------------------------//
		String requestPathInstrutor = ((HttpServletRequest)request).getRequestURI().toLowerCase();
		System.out.println("URI: "+requestPathAdmin);
		

		//verificado por ausencia de permiss�o
		if(requestPathInstrutor.contains("/instructor/") && !permissoes.contains(Permissoes.INSTRUTOR)){
			((HttpServletResponse)response).sendRedirect("/academia/noAccess.xhtml");
			return;
		}
		//-----------------------------------------------------------------------------------//
		
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

		//c�digo de inicializa��o do filtro para o Spring ser capaz de injetar @Autowire beans Spring
		//ServletContext servletContext = fConfig.getServletContext();
	/*	 ServletContext servletContext = fConfig.getServletContext();
		    WebApplicationContext webApplicationContext = 
		            WebApplicationContextUtils.getWebApplicationContext(servletContext);

		    AutowireCapableBeanFactory autowireCapableBeanFactory =
		           webApplicationContext.getAutowireCapableBeanFactory();

		    autowireCapableBeanFactory.configureBean(this, "loginBean");
	}*/

}
	
}
