package com.example.demo.bartender.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.ArraysBartender;
import com.example.demo.repository.BartenderRepository;
import com.example.demo.service.impl.BarServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class BarServiceImplTest {

	@Mock
	private BartenderRepository bartenderRepository;

	@InjectMocks
	private BarServiceImplTest barServiceImplTest;

	private ArraysBartender arraysBartender;

	@Autowired
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
	void getAllArrays() {
		when(bartenderRepository.findAll()).thenReturn(Arrays.asList(arraysBartender));
		assertNotNull(bartenderRepository.findAll());
	}

	@Test
	void getArrayByIdButIsNotPresent() {
		Optional<ArraysBartender> arraysBartender1 = this.bartenderRepository.findById(6);
		assertFalse(arraysBartender1.isPresent());
	}

	@Test
	void getPrimeNumbersWhenGetZeroInParameters() {
		List<Integer> list = barServiceImpl.getPrimeNumbers(0);
		assertTrue(list.isEmpty());
	}

	@Test
	void getFirstFivePrimerNumbers() {
		List<Integer> list1 = barServiceImpl.getPrimeNumbers(2);
		List<Integer> list2 = new ArrayList<>(Arrays.asList(2, 3, 5, 7, 11));
		assertArrayEquals(list1.toArray(), list2.toArray());	}
}
