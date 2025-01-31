package com.example.game_service_api.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.game_service_api.entities.Game;
import com.example.game_service_api.repositories.GameRepository;
import com.example.game_service_api.services.GameService;

@Service
public class GameServiceImpl implements GameService{
private final GameRepository gameRepository;
	
	public GameServiceImpl(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}

	@Override
	public Game saveGame(Game gameRequest) {
		return gameRepository.save(gameRequest);
	}


	
	public Optional<Game> getGame(String idGame) {
		
		Optional<Game> respGame = gameRepository.findById(Long.parseLong(idGame));
	    return respGame;
	}

	@Override
	public String deleteGame(String id) {
		gameRepository.deleteById(Long.parseLong(id));
		return "Eliminado/transaccion completa";
	}
}
