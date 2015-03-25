package br.com.academia.beans.util.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.format.Formatter;

@Named(value="cpfConverter")
@Scope("request")
public class CPFConverter implements Converter{

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		return value;
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		
		Formatter formatadorCpf = new CPFFormatter();
		
		return formatadorCpf.format(value.toString());
	}

}
