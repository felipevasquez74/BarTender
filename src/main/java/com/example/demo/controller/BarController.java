package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Response;
import com.example.demo.service.BarService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BarController {

	@Autowired
	private BarService barService;

	@GetMapping(value = "/bartender/iterations?{iterations}/stackId?{stackId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Response> getBartenderArray(
			@PathVariable(value = "iterations", required = true) Integer iterations,
			@PathVariable(value = "stackId", required = true) Integer stackId) {
		log.info("GetBartenderArray controller for stack {} with {} iterations", iterations, stackId);
		Response response = barService.getDivisibleNumber(iterations, stackId);
		return ResponseEntity.status(response.getStatus()).body(response);
	}
}