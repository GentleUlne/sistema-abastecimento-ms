package com.ifms.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity

@Table(name  = "tb_lotacao")
public class  Lotacao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	  private Long id;

	  private String endereco;
       private String descricao;
     private String email;
     private String site;
    private String telefone;
    public Lotacao() {

}
public Lotacao(Long id, String descricao, String endereco, String email, String site, String telefone) {
	super();
	this.id = id;
	this.descricao = descricao;
	this.endereco = endereco;
	this.email = email;
	this.site = site;
	this.telefone = telefone;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
public String getEndereco() {
	return endereco;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getSite() {
	return site;
}
public void setSite(String site) {
	this.site = site;
}
public String getTelefone() {
	return telefone;
}
public void setTelefone(String telefone) {
	this.telefone = telefone;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((site == null) ? 0 : site.hashCode());
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
	Lotacao other = (Lotacao) obj;
	if (descricao == null) {
		if (other.descricao != null)
			return false;
	} else if (!descricao.equals(other.descricao))
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
	if (site == null) {
		if (other.site != null)
			return false;
	} else if (!site.equals(other.site))
		return false;
	if (telefone == null) {
		if (other.telefone != null)
			return false;
	} else if (!telefone.equals(other.telefone))
		return false;
	return true;
}
  




 
 
 
  
}
