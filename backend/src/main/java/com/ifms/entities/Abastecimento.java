package com.ifms.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import javax.persistence.Table;
@Entity

@Table(name  = "tb_abastecimento")
public class  Abastecimento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	
	private String quilometragem;
	private String telefone;
	private Integer quantidadeEmlitros;
	private Double  valorPorLitro;
	
	
	
	@Column(name = "data_do_abastecimento")
	private String dataDoAbastecimento;
	
	@ManyToOne
	@JoinColumn(name = "id_combustivel_fk")
	private Combustivel combustivel;
	
	
	@ManyToOne (targetEntity = Veiculo.class)
	@JoinColumn(name = "cpf_Motorista")
	private String cpfMotorista;
	
	
  public  Abastecimento () {

}



public Abastecimento(Long id, String dataDoAbastecimento, String quilometragem, String telefone,
		Integer quantidadeEmlitros, Double valorPorLitro, String cpfMotorista, Combustivel combustivel) {
	super();
	this.id = id;
	this.dataDoAbastecimento = dataDoAbastecimento;
	this.quilometragem = quilometragem;
	this.telefone = telefone;
	this.quantidadeEmlitros = quantidadeEmlitros;
	this.valorPorLitro = valorPorLitro;
	this.cpfMotorista = cpfMotorista;
	this.combustivel = combustivel;
}



public Long getId() {
	return id;
}



public void setId(Long id) {
	this.id = id;
}



public String getDataDoAbastecimento() {
	return dataDoAbastecimento;
}



public void setDataDoAbastecimento(String dataDoAbastecimento) {
	this.dataDoAbastecimento = dataDoAbastecimento;
}



public String getQuilometragem() {
	return quilometragem;
}



public void setQuilometragem(String quilometragem) {
	this.quilometragem = quilometragem;
}



public String getTelefone() {
	return telefone;
}



public void setTelefone(String telefone) {
	this.telefone = telefone;
}



public Integer getQuantidadeEmlitros() {
	return quantidadeEmlitros;
}



public void setQuantidadeEmlitros(Integer quantidadeEmlitros) {
	this.quantidadeEmlitros = quantidadeEmlitros;
}



public Double getValorPorLitro() {
	return valorPorLitro;
}



public void setValorPorLitro(Double valorPorLitro) {
	this.valorPorLitro = valorPorLitro;
}



public String getCpfMotorista() {
	return cpfMotorista;
}



public void setCpfMotorista(String cpfMotorista) {
	this.cpfMotorista = cpfMotorista;
}



public Combustivel getCombustivel() {
	return combustivel;
}



public void setCombustivel(Combustivel combustivel) {
	this.combustivel = combustivel;
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((combustivel == null) ? 0 : combustivel.hashCode());
	result = prime * result + ((cpfMotorista == null) ? 0 : cpfMotorista.hashCode());
	result = prime * result + ((dataDoAbastecimento == null) ? 0 : dataDoAbastecimento.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((quantidadeEmlitros == null) ? 0 : quantidadeEmlitros.hashCode());
	result = prime * result + ((quilometragem == null) ? 0 : quilometragem.hashCode());
	result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
	result = prime * result + ((valorPorLitro == null) ? 0 : valorPorLitro.hashCode());
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
	Abastecimento other = (Abastecimento) obj;
	if (combustivel != other.combustivel)
		return false;
	if (cpfMotorista == null) {
		if (other.cpfMotorista != null)
			return false;
	} else if (!cpfMotorista.equals(other.cpfMotorista))
		return false;
	if (dataDoAbastecimento == null) {
		if (other.dataDoAbastecimento != null)
			return false;
	} else if (!dataDoAbastecimento.equals(other.dataDoAbastecimento))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (quantidadeEmlitros == null) {
		if (other.quantidadeEmlitros != null)
			return false;
	} else if (!quantidadeEmlitros.equals(other.quantidadeEmlitros))
		return false;
	if (quilometragem == null) {
		if (other.quilometragem != null)
			return false;
	} else if (!quilometragem.equals(other.quilometragem))
		return false;
	if (telefone == null) {
		if (other.telefone != null)
			return false;
	} else if (!telefone.equals(other.telefone))
		return false;
	if (valorPorLitro == null) {
		if (other.valorPorLitro != null)
			return false;
	} else if (!valorPorLitro.equals(other.valorPorLitro))
		return false;
	return true;
}




 
 
 
  
}


