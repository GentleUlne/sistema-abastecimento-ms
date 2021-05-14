package com.ifms.dto;

import java.io.Serializable;


import com.ifms.entities.Veiculo;

public class VeiculoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private Long id;
	  private Integer ano; 
	  private String placa;
	  private String renavam;
	  private String patrimonio;
	  private String chassi;
	  private String versao;
	  private String capacidadeTanque;
	  private String tipoCombustivel;
	  public VeiculoDTO() {

	}
	  
	  
	  
	public VeiculoDTO(Long id, Integer ano, String placa, String renavam, String patrimonio, String chassi,
			String versao, String capacidadeTanque, String tipoCombustivel) {
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
	
	public VeiculoDTO(Veiculo entity) {
		
		this.id = entity.getId();
		this.placa = entity.getPlaca();
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
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
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
	  

}
