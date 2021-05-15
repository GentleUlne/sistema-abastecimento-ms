

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

@Table(name  = "tb_combustivel")
public class Combustivel  implements Serializable{
	
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	 private Long id;
	private static final long serialVersionUID = 1L;
	
@OneToMany(mappedBy = "combustivel")
   private List <Abastecimento>  abastecimento;
	
	enum TCombustivel{
		  GASOLINA, ETANOL, FLEX, GNV, DIESEL
		}
	
}
