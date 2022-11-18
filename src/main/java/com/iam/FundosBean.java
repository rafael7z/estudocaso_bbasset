package com.iam;

public class FundosBean {
	private int codFundo;
	private String nomeFundo;
	private long cnpjFundo;
	private String riscoFundo;
	
	public FundosBean() {
		super();
	}
	
	public FundosBean(int codFundo, String nomeFundo, long cnpjFundo, String riscoFundo) {
		super();
		this.codFundo = codFundo;
		this.nomeFundo = nomeFundo;
		this.cnpjFundo = cnpjFundo;
		this.riscoFundo = riscoFundo;
	}

	public int getCodFundo() {
		return codFundo;
	}

	public void setCodFundo(int codFundo) {
		this.codFundo = codFundo;
	}

	public String getNomeFundo() {
		return nomeFundo;
	}

	public void setNomeFundo(String nomeFundo) {
		this.nomeFundo = nomeFundo;
	}

	public long getCnpjFundo() {
		return cnpjFundo;
	}

	public void setCnpjFundo(long cnpjFundo) {
		this.cnpjFundo = cnpjFundo;
	}

	public String getRiscoFundo() {
		return riscoFundo;
	}

	public void setRiscoFundo(String riscoFundo) {
		this.riscoFundo = riscoFundo;
	}
		
	

}
