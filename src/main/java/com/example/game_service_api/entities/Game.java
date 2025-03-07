package com.example.game_service_api.entities;

import java.io.Serializable;
import java.lang.module.Configuration;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="games")
public class Game implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	public Game() {
		super();
	}
	public Game(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}

// S.O.L.I.D
// S: responsabilidad de responsabilidad
// O: Open/close
//L Substitucion de liskov
// I: Segregacion de interfaz (roles interfaz)
// Inyeccion de dependencia




