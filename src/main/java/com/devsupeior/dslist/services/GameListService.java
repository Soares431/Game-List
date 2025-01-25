package com.devsupeior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsupeior.dslist.DTO.GameListDTO;
import com.devsupeior.dslist.Repositories.GameListRepository;
import com.devsupeior.dslist.entities.GameList;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository repository;
	
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = repository.findAll();
		
		// transforma uma lista de "GameList" para uma lista de "GameListDTO"
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
		
	}
}
