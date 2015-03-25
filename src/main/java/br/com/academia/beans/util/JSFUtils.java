package br.com.academia.beans.util;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.component.visit.VisitCallback;
import javax.faces.component.visit.VisitContext;
import javax.faces.component.visit.VisitResult;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sun.faces.component.visit.FullVisitContext;

@Component(value="jsfUtils")
@Scope(value="view")
public class JSFUtils {
	
	public void redirectComScrollPorTag(ActionEvent actionEvent){

		String pagina = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("pagina");
		String idTag = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idTag");

		try {
	            FacesContext.getCurrentInstance().getExternalContext().redirect(pagina+"#"+idTag);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	public UIComponent buscaComponentePorId(final String id) {
		FacesContext context = FacesContext.getCurrentInstance(); 
	    UIViewRoot root = context.getViewRoot();
	    final UIComponent[] found = new UIComponent[1];

	    root.visitTree(new FullVisitContext(context), new VisitCallback() {     
	        public VisitResult visit(VisitContext context, UIComponent component) {
	            if(component.getId().equals(id)){
	                found[0] = component;
	                return VisitResult.COMPLETE;
	            }
	            return VisitResult.ACCEPT;              
	        }
	    });

	    return found[0];

	}
	
	
	
	

}
