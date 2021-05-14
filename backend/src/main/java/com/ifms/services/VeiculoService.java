package com.ifms.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ifms.dto.VeiculoDTO;
import com.ifms.entities.Veiculo;
import com.ifms.repositories.VeiculoRepository;
import com.ifms.resources.exceptions.StandardError;
import com.ifms.services.exceptions.DataBaseException;
import com.ifms.services.exceptions.ResourceNotFoundException;


@Service
public class VeiculoService {
	
	@Autowired
	VeiculoRepository repository;
	@Transactional(readOnly =true)
	public List<VeiculoDTO> findAll(){
		
	List<Veiculo> List =	repository.findAll();
	
	
		return   List.stream().map(Veiculo -> new VeiculoDTO(Veiculo))
				
			
				.collect(Collectors.toList());
		
	}
	@Transactional(readOnly =true)
	public VeiculoDTO findById(Long id) {
	Optional<Veiculo> obj =	repository.findById(id);
	    
	Veiculo Veiculo  = obj.orElseThrow(()-> new ResourceNotFoundException("A Escola solicitada não foi encontrada."));
		
		return new VeiculoDTO(Veiculo);
	}
	

	@Transactional
	public VeiculoDTO insert(VeiculoDTO dto) {
		Veiculo entity = new Veiculo();
		entity.setAno(dto.getAno());
		entity.setCapacidadeTanque(dto.getCapacidadeTanque());
		entity.setPatrimonio(dto.getPatrimonio());
		entity.setPlaca(dto.getPlaca());
		entity.setRenavam(dto.getRenavam());
		entity.setVersao(dto.getVersao());
		entity = repository.save(entity);
		return new VeiculoDTO(entity); 
	}
	@Transactional
	public   VeiculoDTO  update(long id,  VeiculoDTO dto) {
		try {
			Veiculo entity = repository.getOne(id);
			entity.setAno(dto.getAno());
			entity.setCapacidadeTanque(dto.getCapacidadeTanque());
			entity.setPatrimonio(dto.getPatrimonio());
			entity.setPlaca(dto.getPlaca());
			entity.setRenavam(dto.getRenavam());
			entity.setVersao(dto.getVersao());
			entity = repository.save(entity);
			return new VeiculoDTO(entity); 
			
			
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id "
					+ "da Escola não foi encontrada");
		}
		
		
	}
	public void delete(long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possivel deletar, O id "
					+ "da Escola não foi encontrada");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possivel deletar a Escola, pois a mesma está em uso");
		}
		
		
	}
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError();
		error.setTimestamp(Instant.now());
		error.setStatus(status.value());
		error.setError("Resource not found");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}

	
	
}
