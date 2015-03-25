package br.com.academia.beans.util.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import br.com.academia.beans.util.formatters.RGFormatter;
import br.com.caelum.stella.format.Formatter;

@Named(value="rgConverter")
@Scope("request")
public class RGConverter implements Converter{

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		return value;
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {

		Formatter formatadorRg = new RGFormatter(); 
		
		return formatadorRg.format(value.toString());
	}

}
