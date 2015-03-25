package br.com.academia.beans.util.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.academia.entidades.Perfil;
import br.com.academia.servico.ServicoPerfil;

@Named(value = "perfilConverter")
@Scope("request")
public class PerfilConverter implements Converter {

	@Autowired
	private ServicoPerfil servico;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String string) {
		if (string == null || string.isEmpty())
			return null;
		Integer id = Integer.valueOf(string);
		Perfil p = servico.buscarPorId(id);
		return p;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object object) {
		Perfil p = (Perfil) object;
		if (p == null || p.getId() == null)
			return null;
		return String.valueOf(p.getId());
	}
}
