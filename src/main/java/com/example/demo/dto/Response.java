package com.example.demo.dto;

import java.util.List;

import lombok.Data;

@Data
public class Response {
	private int status;
	private String reason;
	private List<Integer> arrayB;
}
