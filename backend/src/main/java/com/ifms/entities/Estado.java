package com.ifms.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import javax.persistence.Table;
@Entity

@Table(name  = "tb_estado")
public class  Estado implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	 private Long id;
	  private String UF;
	  
  @OneToMany(mappedBy = "nome")
    private List <Cidade>  cidade; 
	  
	  
  public Estado() {

}

public Estado(Long id, String UF) {
	super();
	this.id = id;
	this.UF = UF;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getUF() {
	return UF;
}

public void setUF(String UF) {
	this.UF = UF;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((UF == null) ? 0 : UF.hashCode());
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
	Estado other = (Estado) obj;
	if (UF == null) {
		if (other.UF != null)
			return false;
	} else if (!UF.equals(other.UF))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}

 
 
 
  
}
