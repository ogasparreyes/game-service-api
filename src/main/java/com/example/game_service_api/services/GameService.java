package com.example.game_service_api.services;

import java.util.Optional;

import com.example.game_service_api.entities.Game;

public interface GameService {
	Game saveGame(Game gameRequest);
	Optional<Game> getGame(String idGame);
	String deleteGame(String id);
}
