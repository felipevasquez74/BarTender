package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Response;
import com.example.demo.entity.ArraysBartender;
import com.example.demo.repository.BartenderRepository;
import com.example.demo.service.BarService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BarServiceImpl implements BarService {

	@Autowired
	private BartenderRepository bartenderRepository;

	@Override
	public Response getDivisibleNumber(Integer iterations, Integer stackId) {
		Response response = new Response();
		log.info("Execute getDivisibleNumber service");
		try {
			List<Integer> p = this.getPrimeNumbers(iterations);
			List<Integer> b = new ArrayList<>();
			log.info("Search of stack {} in database", stackId);
			ArraysBartender arraysBartender = this.bartenderRepository.getById(stackId);
			List<Integer> inputList = Arrays.stream(arraysBartender.getInputArray().split(",")).map(Integer::valueOf)
					.collect(Collectors.toList());
			for (int i = 0; i < iterations; i++) {
				for (int j = 0; j < inputList.size(); j++) {
					if (inputList.get(j) % p.get(i) == 0) {
						log.info("Number {} % {} is evenly divisible. Added to array B", inputList.get(j), p.get(i));
						if (!b.contains(inputList.get(j)))
							b.add(inputList.get(j));
					}
				}
			}
			log.info("Array B: {}", b);
			response.setStatus(HttpStatus.OK.value());
			response.setReason("Ok");
			response.setArrayB(b);
		} catch (Exception e) {
			log.error("ERROR in service getDivisibleNumber ", e.getMessage());
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setReason((HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()) + ". " + e.getMessage());
		}
		return response;
	}

	public List<Integer> getPrimeNumbers(Integer iterations) {
		List<Integer> primeNumbers = new ArrayList<>();
		for (int i = 1; i < iterations * 6; i++) {
			int count = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0)
					count++;
			}
			if (count == 2)
				primeNumbers.add(i);
		}
		return primeNumbers;
	}
}
