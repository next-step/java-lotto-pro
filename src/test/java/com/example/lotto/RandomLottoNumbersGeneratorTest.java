package com.example.lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("랜덤 로또 번호들 생성기")
class RandomLottoNumbersGeneratorTest {

	@DisplayName("중복되지 않는 6개 로또 번호들을 랜덤으로 생성한다.")
	@RepeatedTest(value = 10)
	void generate() {
		// given
		LottoNumbersGenerator lottoNumbersGenerator = new RandomLottoNumbersGenerator();

		// when
		List<LottoNumber> lottoNumbers = lottoNumbersGenerator.generate();

		// then
		assertAll(
			() -> assertThat(lottoNumbers).isNotNull(),
			() -> assertThat(new HashSet<>(lottoNumbers)).hasSize(6),
			() -> assertThat(lottoNumbers).hasSize(6)
		);
	}
}
