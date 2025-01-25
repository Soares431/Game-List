package com.devsupeior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsupeior.dslist.DTO.GameMinDTO;
import com.devsupeior.dslist.Repositories.GameRepository;
import com.devsupeior.dslist.entities.Game;

@Service
public class GameService {
	
	@Autowired
	private GameRepository repository;
	
	public List<GameMinDTO> findAll(){
		List<Game> result = repository.findAll();
		
		// transforma uma lista de "Games" para uma lista de "GameMinDTO"
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
		
	}
}
