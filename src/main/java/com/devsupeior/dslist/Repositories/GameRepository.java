package com.devsupeior.dslist.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsupeior.dslist.entities.Game;

//Camda de acesso a dados
// Precisa do tipo da entidade (Game) e o tipo do ID da entidade(Long)
public interface GameRepository extends JpaRepository<Game, Long>{
	
	
	
}
