package br.com.academia.seguranca;

import java.security.MessageDigest;

public class ConversorMd5 {
	
	private String senhaMd5;
	
	public ConversorMd5(String senha){
		if(senha != null) senhaMd5 = getMd5(senha);
	}
	
	public String getSenhaMd5() {
		return senhaMd5;
	}

	 private String getMd5(String string) {
	        String digest = null;
	        try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            byte[] hash = md.digest(string.getBytes("UTF-8"));
	            StringBuilder sb = new StringBuilder(2 * hash.length);
	            for (byte b : hash) {
	                sb.append(String.format("%02x", b & 0xff));
	            }
	            digest = sb.toString();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return digest;
	    }

}
