package com.example.game_service_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.game_service_api.entities.Game;

// DAO
public interface GameRepository extends JpaRepository<Game, Long>{

}
