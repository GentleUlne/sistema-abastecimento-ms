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

@Table(name  = "tb_cidade")
public class  Cidade implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	 private Long id;
	 
	

	  
	  
	 @ManyToOne (targetEntity = Estado.class)
	@JoinColumn(name =  "nome_cidade")
	  private String nome;
	  
	  
	  
	  @OneToMany(mappedBy = "endereco")
	    private List <AutoPosto>  autoposto;

	 @OneToMany (mappedBy = "endereco")
	  private List <Lotacao>  lotacao;
	  
	  
  public Cidade() {

}

public Cidade(Long id, String nome) {
	super();
	this.id = id;
	this.nome = nome;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
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
	Cidade other = (Cidade) obj;
	if (nome == null) {
		if (other.nome != null)
			return false;
	} else if (!nome.equals(other.nome))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}

 
 
 
  
}
