package br.com.academia.beans.util.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.academia.entidades.Modalidade;
import br.com.academia.servico.ServicoModalidade;

@Named(value = "modalidadeConverter")
@Scope("request")
public class ModalidadeConverter implements Converter {

	@Autowired
	private ServicoModalidade servico;

	public Object getAsObject(FacesContext context, UIComponent component,
			String string) {
		if (string == null || string.isEmpty())
			return null;
		Integer id = Integer.valueOf(string);
		Modalidade m = servico.buscarPorIdEager(id);
		return m;
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object object) {
		Modalidade m = (Modalidade) object;
		if (m == null || m.getId() == null)
			return null;
		return String.valueOf(m.getId());
	}
}
