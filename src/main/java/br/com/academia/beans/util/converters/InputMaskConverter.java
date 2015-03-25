package br.com.academia.beans.util.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.stereotype.Component;

@Component
@FacesConverter(value="inputMaskConverter")
public class InputMaskConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null || value != "") {
			value = value.toString().replaceAll("[= /.]", "");
			value = value.toString().replaceAll("[-()]", "");
			value = value.toString().replaceAll("[_]", "");
			value = value.toString().replaceAll("[,]", ".");
		}
		return value;
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		
		return value.toString();
	}

}
