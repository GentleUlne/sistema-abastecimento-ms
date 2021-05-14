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

import com.ifms.dto.MarcaDTO;
import com.ifms.entities.Marca;
import com.ifms.repositories.MarcaRepository;
import com.ifms.resources.exceptions.StandardError;
import com.ifms.services.exceptions.DataBaseException;
import com.ifms.services.exceptions.ResourceNotFoundException;


@Service
public class MarcaService {
	
	@Autowired
	MarcaRepository repository;
	@Transactional(readOnly =true)
	public List<MarcaDTO> findAll(){
		
	List<Marca> List =	repository.findAll();
		return List.stream().map(Marca -> new MarcaDTO(Marca))
				.collect(Collectors.toList());
		
	}
	@Transactional(readOnly =true)
	public MarcaDTO findById(Long id) {
	Optional<Marca> obj =	repository.findById(id);
	    
	Marca Marca  = obj.orElseThrow(()-> new ResourceNotFoundException("A Escola solicitada não foi encontrada."));
		
		return new MarcaDTO(Marca);
	}
	
	@Transactional
	public MarcaDTO insert(MarcaDTO dto) {
		Marca entity = new Marca();
		entity.setDescricao(dto.getDescricao());
		
		
		entity = repository.save(entity);
		return new MarcaDTO(entity); 
	}
	@Transactional
	public MarcaDTO update(long id, MarcaDTO dto) {
		try {
			Marca entity = repository.getOne(id);
			entity.setDescricao(dto.getDescricao());
		
			return new MarcaDTO(entity); 
			
			
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
