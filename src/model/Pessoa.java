package model;

public class Pessoa {
	
	private int idPessoa;
	
	private String CPFPessoa;
	
	private String nomePessoa;
	
	private String endPessoa;
	
	private int tipoPessoa;

	public Pessoa(int idPessoa, String CPFPessoa, String nomePessoa, String endPessoa, int tipoPessoa) {
		super();
		this.idPessoa = idPessoa;
		this.CPFPessoa = CPFPessoa;
		this.nomePessoa = nomePessoa;
		this.endPessoa = endPessoa;
		this.tipoPessoa = tipoPessoa;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getCPFPessoa() {
		return CPFPessoa;
	}

	public void setCPFPessoa(String CPFPessoa) {
		this.CPFPessoa = CPFPessoa;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getEndPessoa() {
		return endPessoa;
	}

	public void setEndPessoa(String endPessoa) {
		this.endPessoa = endPessoa;
	}

	public int getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(int tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
}
