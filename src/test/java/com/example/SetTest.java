package com.example;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인한다.")
	@Test
	public void requirement_1() {
		// given & when & then
		assertThat(numbers).hasSize(3);
	}

	@DisplayName("Set의 contains() 메소드를 활용해 1,2,3의 값이 존재하는지 확인한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "3",})
	public void requirement_2(int number) {
		// given & when & then
		assertThat(numbers.contains(number)).isTrue();
	}

	@DisplayName("Set의 contains() 메소드를 활용해 결과 값이 false인 경우도 테스트한다.")
	@ParameterizedTest
	@CsvSource({
		"1,true",
		"2,true",
		"3,true",
		"4,false",
		"5,false",
	})
	public void requirement_3(int number, boolean expected) {
		// given & when & then
		assertThat(numbers.contains(number)).isEqualTo(expected);
	}
}
