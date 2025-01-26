package com.devsupeior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsupeior.dslist.DTO.GameDTO;
import com.devsupeior.dslist.DTO.GameMinDTO;
import com.devsupeior.dslist.Repositories.GameRepository;
import com.devsupeior.dslist.entities.Game;
import com.devsupeior.dslist.projections.GameMinProjection;

@Service
public class GameService {
	
	@Autowired
	private GameRepository repository;
	
	//Faz com que as operações de dados sejam realizadas obedecendo aos princípios das transações
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = repository.findById(id).get();
		return new GameDTO(result);
		
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = repository.findAll();
		
		// transforma uma lista de "Games" para uma lista de "GameMinDTO"
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
		
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> result = repository.searchByList(listId);
		
		// transforma uma lista de "GameMinProjection" para uma lista de "GameMinDTO"
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
		
	}
}
