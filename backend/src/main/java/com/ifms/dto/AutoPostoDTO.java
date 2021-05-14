package com.ifms.dto;

import java.io.Serializable;

import com.ifms.entities.AutoPosto;

public class AutoPostoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  private Long id;
	  private String nomeFantasia;
	  private String telefone;
	  private String email;
	  private String CNPJ;
	  private String endereco;




		
public AutoPostoDTO() {
	
	}


public AutoPostoDTO(Long id, String nomeFantasia, String telefone, String email, String cNPJ, String endereco) {
	super();
	this.id = id;
	this.nomeFantasia = nomeFantasia;
	this.telefone = telefone;
	this.email = email;
	CNPJ = cNPJ;
	this.endereco = endereco;
}






public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getNomeFantasia() {
	return nomeFantasia;
}


public void setNomeFantasia(String nomeFantasia) {
	this.nomeFantasia = nomeFantasia;
}


public String getTelefone() {
	return telefone;
}


public void setTelefone(String telefone) {
	this.telefone = telefone;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getCNPJ() {
	return CNPJ;
}


public void setCNPJ(String cNPJ) {
	CNPJ = cNPJ;
}


public String getEndereco() {
	return endereco;
}


public void setEndereco(String endereco) {
	this.endereco = endereco;
}


public static long getSerialversionuid() {
	return serialVersionUID;
}








@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((CNPJ == null) ? 0 : CNPJ.hashCode());
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((nomeFantasia == null) ? 0 : nomeFantasia.hashCode());
	result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	AutoPostoDTO other = (AutoPostoDTO) obj;
	if (CNPJ == null) {
		if (other.CNPJ != null)
			return false;
	} else if (!CNPJ.equals(other.CNPJ))
		return false;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (endereco == null) {
		if (other.endereco != null)
			return false;
	} else if (!endereco.equals(other.endereco))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (nomeFantasia == null) {
		if (other.nomeFantasia != null)
			return false;
	} else if (!nomeFantasia.equals(other.nomeFantasia))
		return false;
	if (telefone == null) {
		if (other.telefone != null)
			return false;
	} else if (!telefone.equals(other.telefone))
		return false;
	return true;
}


public AutoPostoDTO (AutoPosto entity) {
	
	this.id = entity.getId();
	this.nomeFantasia = entity.getNomeFantasia();
}



}
