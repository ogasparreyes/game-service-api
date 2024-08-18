package com.example.game_service_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.game_service_api.entities.Game;
import com.example.game_service_api.services.GameService;


@RestController
@RequestMapping("/api/games")
public class GameController {
	
	private final GameService gameService;
	
	public GameController(GameService gameService) {
		this.gameService = gameService;
	}
	
	@PostMapping
	public ResponseEntity<Game> saveGame(@RequestBody Game game){
		Game gameResponse= gameService.saveGame(game);
		return ResponseEntity.ok(gameResponse);
	}
	
	@GetMapping("/{idGame}")
	public ResponseEntity<Game> getGame(@PathVariable String idGame){
		return ResponseEntity.ok(gameService.getGame(idGame).get());
	}

}
