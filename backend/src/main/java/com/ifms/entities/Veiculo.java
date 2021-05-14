package com.ifms.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity

@Table(name  = "tb_veiculo")
public class  Veiculo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
  private Long id;
  private Integer ano; 

  private String renavam;
  private String patrimonio;
  private String chassi;
  private String versao;
  private String capacidadeTanque;
  private String tipoCombustivel;
  
  
  


  @ManyToOne (targetEntity = Modelo.class )


  private String placa;
 
  
	
	

	
  public Veiculo() {

}
  




 
 
 
public Long getId() {
	return id;
}








public void setId(Long id) {
	this.id = id;
}








public Integer getAno() {
	return ano;
}








public void setAno(Integer ano) {
	this.ano = ano;
}








public String getPlaca() {
	return placa;
}








public void setPlaca(String placa) {
	this.placa = placa;
}








public String getRenavam() {
	return renavam;
}








public void setRenavam(String renavam) {
	this.renavam = renavam;
}








public String getPatrimonio() {
	return patrimonio;
}








public void setPatrimonio(String patrimonio) {
	this.patrimonio = patrimonio;
}








public String getVersao() {
	return versao;
}








public void setVersao(String versao) {
	this.versao = versao;
}








public String getCapacidadeTanque() {
	return capacidadeTanque;
}








public void setCapacidadeTanque(String capacidadeTanque) {
	this.capacidadeTanque = capacidadeTanque;
}








public String getTipoCombustivel() {
	return tipoCombustivel;
}








public void setTipoCombustivel(String tipoCombustivel) {
	this.tipoCombustivel = tipoCombustivel;
}








public Veiculo(Long id, Integer ano, String placa, String renavam, String patrimonio, String chassi, String versao,
		String capacidadeTanque, String tipoCombustivel) {
	super();
	this.id = id;
	this.ano = ano;
	this.placa = placa;
	this.renavam = renavam;
	this.patrimonio = patrimonio;
	this.chassi = chassi;
	this.versao = versao;
	this.capacidadeTanque = capacidadeTanque;
	this.tipoCombustivel = tipoCombustivel;
}








@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((ano == null) ? 0 : ano.hashCode());
	result = prime * result + ((capacidadeTanque == null) ? 0 : capacidadeTanque.hashCode());
	result = prime * result + ((chassi == null) ? 0 : chassi.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((patrimonio == null) ? 0 : patrimonio.hashCode());
	result = prime * result + ((placa == null) ? 0 : placa.hashCode());
	result = prime * result + ((renavam == null) ? 0 : renavam.hashCode());
	result = prime * result + ((tipoCombustivel == null) ? 0 : tipoCombustivel.hashCode());
	result = prime * result + ((versao == null) ? 0 : versao.hashCode());
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
	Veiculo other = (Veiculo) obj;
	if (ano == null) {
		if (other.ano != null)
			return false;
	} else if (!ano.equals(other.ano))
		return false;
	if (capacidadeTanque == null) {
		if (other.capacidadeTanque != null)
			return false;
	} else if (!capacidadeTanque.equals(other.capacidadeTanque))
		return false;
	if (chassi == null) {
		if (other.chassi != null)
			return false;
	} else if (!chassi.equals(other.chassi))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (patrimonio == null) {
		if (other.patrimonio != null)
			return false;
	} else if (!patrimonio.equals(other.patrimonio))
		return false;
	if (placa == null) {
		if (other.placa != null)
			return false;
	} else if (!placa.equals(other.placa))
		return false;
	if (renavam == null) {
		if (other.renavam != null)
			return false;
	} else if (!renavam.equals(other.renavam))
		return false;
	if (tipoCombustivel == null) {
		if (other.tipoCombustivel != null)
			return false;
	} else if (!tipoCombustivel.equals(other.tipoCombustivel))
		return false;
	if (versao == null) {
		if (other.versao != null)
			return false;
	} else if (!versao.equals(other.versao))
		return false;
	return true;
}














 
 
 
  
}
