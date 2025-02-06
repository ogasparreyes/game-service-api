package com.example.game_service_api.controller;

import com.example.game_service_api.entities.Game;
import com.example.game_service_api.services.GameService;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

    private static final Logger logger = LoggerFactory.getLogger(GameController.class);

    private  MeterRegistry meterRegistry;

    private List<String> games = Arrays.asList(
            "Halo 1",
            "Call Of Duty",
            "NFS",
            "FIFA 25",
            "The Legend of Zelda: Breath of the Wild",
            "Super Mario Odyssey",
            "Red Dead Redemption 2",
            "The Witcher 3: Wild Hunt",
            "Minecraft",
            "Fortnite",
            "Apex Legends",
            "Overwatch",
            "God of War",
            "Dark Souls III",
            "Sekiro: Shadows Die Twice",
            "Assassin's Creed Valhalla",
            "Cyberpunk 2077",
            "Genshin Impact",
            "Animal Crossing: New Horizons",
            "Doom Eternal",
            "Resident Evil 2 Remake",
            "Final Fantasy VII Remake",
            "Ghost of Tsushima",
            "Hades",
            "Stardew Valley",
            "Among Us",
            "Fall Guys: Ultimate Knockout",
            "Battlefield V",
            "The Last of Us Part II",
            "Persona 5 Royal"
    );

    public GameController(GameService gameService, MeterRegistry meterRegistry) {
        this.gameService = gameService;
        this.meterRegistry = meterRegistry;
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

    @GetMapping("/tes")
    @Timed("request.game.timed.method")
    public ResponseEntity<String> test() {
        meterRegistry.counter("request.game.name.test").increment();
        return ResponseEntity.ok("SUCCESS");
    }

    // Limpiar la cache @CacheEvict("cache_games") example un deleteByID ...
    @Cacheable("cache_games")
    @GetMapping("/game/{nameGame}")
    public ResponseEntity<String> getGameByName(@PathVariable String nameGame) {
        meterRegistry.counter("request.game.name").increment();
        logger.info("Buscando titulo: {}", nameGame);
        return ResponseEntity.ok(games.stream().filter(g -> g.equals(nameGame)).findAny().orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT)));
    }

    @DeleteMapping("/{idGame}")
    public ResponseEntity<String> deleteGame(@PathVariable String idGame) {
        return ResponseEntity.ok(gameService.deleteGame(idGame));
    }


}
