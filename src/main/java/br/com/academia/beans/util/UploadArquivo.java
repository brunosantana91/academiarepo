package br.com.academia.beans.util;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;

public class UploadArquivo {

	private byte[] arquivoUpado;
	private String caminhoArquivoUpado;
	private String nomeArquivoUpado;

	public void upload(FileUploadEvent fileUploadEvent, String tipo, String diretorio) {
		try {
			arquivoUpado = IOUtils.toByteArray(fileUploadEvent.getFile().getInputstream());
			nomeArquivoUpado = new java.util.Date().getTime() + tipo;
			caminhoArquivoUpado = diretorio + getNomeArquivoUpado();

			// cria a pasta para salvar o arquivo Upado
			File file = new File(diretorio);
			file.mkdirs();

		} catch (Exception ex) {
			System.out.println("Erro no upload de arquivo" + ex);
		}
	}
	
	public void gravar(){
		try{
			FileOutputStream fos = new FileOutputStream(caminhoArquivoUpado);
			fos.write(arquivoUpado);
			fos.close();
		}catch(Exception ex){
			System.out.println("falha ao gravar arquivo upado" + ex);
		}
	}

	// busca caminho completo da aplicao no servidor
/*	private String getRealPath() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ServletContext context = (ServletContext) facesContext.getExternalContext().getContext();
		return context.getRealPath("/");
	}*/

	public String getNomeArquivoUpado() {
		return nomeArquivoUpado;
	}

	public byte[] getArquivoUpado() {
		return arquivoUpado;
	}

}
