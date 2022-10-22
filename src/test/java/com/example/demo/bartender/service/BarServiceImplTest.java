package com.example.demo.bartender.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entity.ArraysBartender;
import com.example.demo.repository.BartenderRepository;
import com.example.demo.service.impl.BarServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BarServiceImplTest {

	@Mock
	private BartenderRepository bartenderRepository;

	@InjectMocks
	private BarServiceImplTest barServiceImplTest;

	private ArraysBartender arraysBartender;

	@Mock
	private BarServiceImpl barServiceImpl;

	@BeforeEach
	public void initTest() {
		MockitoAnnotations.openMocks(this);
		Mockito.reset(bartenderRepository);

		arraysBartender = new ArraysBartender();
		arraysBartender.setId(1);
		arraysBartender.setInputArray("2,4,5,6,7,8");

	}

	@Test
	public void getAllArrays() {
		when(bartenderRepository.findAll()).thenReturn(Arrays.asList(arraysBartender));
		assertNotNull(bartenderRepository.findAll());
	}

	@Test
	public void getArrayByIdButIsNotPresent() {
		Optional<ArraysBartender> arraysBartender1 = this.bartenderRepository.findById(6);
		assertFalse(arraysBartender1.isPresent());
	}

	@Test
	public void getPrimeNumbersWhenGetZeroInParameters() {
		List<Integer> list = barServiceImpl.getPrimeNumbers(0);
		assertTrue(list.isEmpty());
	}

}
