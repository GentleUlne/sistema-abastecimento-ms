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

import com.ifms.dto.EstadoDTO;
import com.ifms.entities.Estado;
import com.ifms.repositories.EstadoRepository;
import com.ifms.resources.exceptions.StandardError;
import com.ifms.services.exceptions.DataBaseException;
import com.ifms.services.exceptions.ResourceNotFoundException;


@Service
public class EstadoService {
	
	@Autowired
	EstadoRepository repository;
	@Transactional(readOnly =true)
	public List<EstadoDTO> findAll(){
		
	List<Estado> List =	repository.findAll();
		return List.stream().map(Estado -> new EstadoDTO(Estado))
				.collect(Collectors.toList());
		
	}
	@Transactional(readOnly =true)
	public EstadoDTO findById(Long id) {
	Optional<Estado> obj =	repository.findById(id);
	    
	Estado Estado  = obj.orElseThrow(()-> new ResourceNotFoundException("A Escola solicitada não foi encontrada."));
		
		return new EstadoDTO(Estado);
	}
	
	@Transactional
	public EstadoDTO insert(EstadoDTO dto) {
		Estado entity = new Estado();
		entity.setUF(dto.getUF());
		
		
		entity = repository.save(entity);
		return new EstadoDTO(entity); 
	}
	@Transactional
	public EstadoDTO update(long id, EstadoDTO dto) {
		try {
			Estado entity = repository.getOne(id);
			entity.setUF(dto.getUF());
		
			return new EstadoDTO(entity); 
			
			
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
