package com.ifms.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ifms.dto.CidadeDTO;
import com.ifms.services.CidadeService;


@RestController
@RequestMapping(value = "/Cidade")
public class CidadeResource {
	
	@Autowired
	private CidadeService service ;
	
    @GetMapping
	public ResponseEntity<List<CidadeDTO>> findAll(){
	List<CidadeDTO> lista = service.findAll();
	
	return ResponseEntity.ok().body(lista);

    	
	
	}
    
    @GetMapping(value = "/{id}" )
    public ResponseEntity<CidadeDTO> findById(@PathVariable Long id){
		
    	CidadeDTO dto = service.findById(id);
    	return ResponseEntity.ok().body(dto);
    	}
    
    @PostMapping
    public ResponseEntity<CidadeDTO> insert(@RequestBody CidadeDTO dto){
    	dto = service.insert(dto);
    	// Quando retornar 201 objeto criado, por padrão retorna também o endereço do recurso
    	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
    	return ResponseEntity.created(uri).body(dto);

    	}
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<CidadeDTO> update(@PathVariable long id, @RequestBody CidadeDTO dto){
    	 dto = service.update(id,dto);
    	return ResponseEntity.ok().body(dto);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CidadeDTO > delete (@PathVariable long id){
    	
    	
    	service.delete(id);
    	return ResponseEntity.noContent().build();
    }
    
}
