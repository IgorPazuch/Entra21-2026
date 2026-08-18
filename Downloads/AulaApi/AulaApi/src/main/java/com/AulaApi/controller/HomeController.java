package com.AulaApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
public class HomeController {

	@GetMapping
	public String ola() {
		return "Olá";
	}
}

/* Verbos do Http
* GET http://localhost:8080/home
* POST
* PUT
* DELETE 
* PATCH
* */