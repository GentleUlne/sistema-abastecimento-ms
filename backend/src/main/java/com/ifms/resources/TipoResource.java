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

import com.ifms.dto.TipoDTO;
import com.ifms.services.TipoService;


@RestController
@RequestMapping(value = "/Tipos")
public class TipoResource {
	
	@Autowired
	private TipoService service ;
	
    @GetMapping
	public ResponseEntity<List<TipoDTO>> findAll(){
	List<TipoDTO> lista = service.findAll();
	
	return ResponseEntity.ok().body(lista);

    	
	
	}
    
    @GetMapping(value = "/{id}" )
    public ResponseEntity<TipoDTO> findById(@PathVariable Long id){
		
    	TipoDTO dto = service.findById(id);
    	return ResponseEntity.ok().body(dto);
    	}
    
    @PostMapping
    public ResponseEntity<TipoDTO> insert(@RequestBody TipoDTO dto){
    	dto = service.insert(dto);
    	// Quando retornar 201 objeto criado, por padrão retorna também o endereço do recurso
    	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
    	return ResponseEntity.created(uri).body(dto);

    	}
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<TipoDTO> update(@PathVariable long id, @RequestBody TipoDTO dto){
    	 dto = service.update(id,dto);
    	return ResponseEntity.ok().body(dto);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<TipoDTO > delete (@PathVariable long id){
    	
    	
    	service.delete(id);
    	return ResponseEntity.noContent().build();
    }
    
}
