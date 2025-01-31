package com.example.game_service_api.controller;

import com.example.game_service_api.entities.Game;
import com.example.game_service_api.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    private List<String> games = Arrays.asList("Halo 1", "Call Of Dutty", "NFS", "FIFA 25");

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

    @GetMapping("/game/{nameGame}")
    public ResponseEntity<String> getGameByName(@PathVariable String nameGame) {

        return ResponseEntity.ok(games.stream().filter(g -> g.equals(nameGame)).findAny().orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT)));
    }

    @DeleteMapping("/{idGame}")
    public ResponseEntity<String> deleteGame(@PathVariable String idGame) {
        return ResponseEntity.ok(gameService.deleteGame(idGame));
    }


}
