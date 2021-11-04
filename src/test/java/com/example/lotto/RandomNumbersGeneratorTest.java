package com.example.lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("랜덤 번호들 생성기")
class RandomNumbersGeneratorTest {

	@DisplayName("중복되지 않는 6개 번호들을 랜덤으로 생성한다.")
	@RepeatedTest(value = 10)
	void generate() {
		// given
		RandomNumbersGenerator generator = new RandomNumbersGenerator();

		// when
		List<Integer> numbers = generator.generate(
			LottoNumber.ONE,
			LottoNumber.FORTY_FIVE,
			LottoNumbers.LOTTO_NUMBER_COUNT);

		// then
		assertAll(
			() -> assertThat(numbers).isNotNull(),
			() -> assertThat(new HashSet<>(numbers)).hasSize(LottoNumbers.LOTTO_NUMBER_COUNT),
			() -> assertThat(numbers).hasSize(LottoNumbers.LOTTO_NUMBER_COUNT)
		);
	}
}
