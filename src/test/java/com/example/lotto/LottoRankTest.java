package com.example.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("로또 순위")
class LottoRankTest {

	private static Stream<Arguments> valueOfArguments() {
		return Stream.of(
			Arguments.of(6, false, LottoRank.FIRST),
			Arguments.of(5, true, LottoRank.SECOND),
			Arguments.of(5, false, LottoRank.THIRD),
			Arguments.of(4, false, LottoRank.FOURTH),
			Arguments.of(3, false, LottoRank.FIFTH),
			Arguments.of(2, false, LottoRank.MISS),
			Arguments.of(1, false, LottoRank.MISS),
			Arguments.of(0, false, LottoRank.MISS)
		);
	}

	@DisplayName("숫자를 맞힌 수로부터 순위를 알 수 있다.")
	@ParameterizedTest
	@MethodSource(value = "valueOfArguments")
	void valueOf(int countOfMatch, boolean matchBonus, LottoRank lottoRank) {
		// given & when & then
		assertThat(LottoRank.valueOf(countOfMatch, matchBonus)).isEqualTo(lottoRank);
	}
}
