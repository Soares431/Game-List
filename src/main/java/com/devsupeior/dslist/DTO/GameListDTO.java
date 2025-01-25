package com.devsupeior.dslist.DTO;

import com.devsupeior.dslist.entities.GameList;

public class GameListDTO {
	
	
	private long id;
	private String name;
	
	public GameListDTO() {
		
	}
	
	public GameListDTO(GameList entity) {
		
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
}
