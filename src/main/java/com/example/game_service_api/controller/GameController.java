package com.example.game_service_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Game> saveGame(@RequestBody Game game) {
        Game gameResponse = gameService.saveGame(game);
        return ResponseEntity.ok(gameResponse);
    }

    //input: idGame
    //output: return Game

    @GetMapping("/{idGame}")
    public ResponseEntity<Game> getGame(@PathVariable String idGame) {
        return ResponseEntity.ok(gameService.getGame(idGame).get());
    }

    @DeleteMapping("/{idGame}")
    public ResponseEntity<String> deleteGame(@PathVariable String idGame) {
        return ResponseEntity.ok(gameService.deleteGame(idGame));
    }


}
