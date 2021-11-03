package com.example.lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("로또 게임")
class LottoGameTest {
	private static Stream<Arguments> validLottoNumbers() {
		return Stream.of(
			Arguments.of(
				// valid lotto numbers
				Arrays.asList(
					new LottoNumber(8),
					new LottoNumber(21),
					new LottoNumber(23),
					new LottoNumber(41),
					new LottoNumber(42),
					new LottoNumber(43))),
			Arguments.of(
				// valid but not sorted lotto numbers
				Arrays.asList(
					new LottoNumber(3),
					new LottoNumber(11),
					new LottoNumber(5),
					new LottoNumber(16),
					new LottoNumber(38),
					new LottoNumber(32)))
		);
	}

	private static Stream<Arguments> invalidLottoNumbers() {
		return Stream.of(
			Arguments.of(
				// null
				Collections.emptyList()),
			Arguments.of(
				// empty number
				Collections.emptyList()),
			Arguments.of(
				// duplicated number
				Arrays.asList(
					new LottoNumber(3),
					new LottoNumber(3),
					new LottoNumber(5),
					new LottoNumber(16),
					new LottoNumber(38),
					new LottoNumber(32))),
			Arguments.of(
				// less than 6 numbers
				Arrays.asList(
					new LottoNumber(3),
					new LottoNumber(5),
					new LottoNumber(16),
					new LottoNumber(38),
					new LottoNumber(32))),
			Arguments.of(
				// more than 6 numbers
				Arrays.asList(
					new LottoNumber(3),
					new LottoNumber(4),
					new LottoNumber(5),
					new LottoNumber(16),
					new LottoNumber(38),
					new LottoNumber(32),
					new LottoNumber(33)))
		);
	}

	@DisplayName("로또 게임의 가격은 1000원이다.")
	@Test
	void price() {
		// given & when & then
		assertThat(LottoGame.LOTTO_GAME_PRICE).isEqualTo(1000);
	}

	@DisplayName("로또 게임을 생성한다. 중복되지 않는 오름차순의 6개 로또 번호들을 갖는다.")
	@ParameterizedTest
	@MethodSource("validLottoNumbers")
	void constructor(List<LottoNumber> lottoNumbers) {
		// given & when
		LottoGame lottoGame = new LottoGame(() -> lottoNumbers);

		// then
		assertAll(
			() -> assertThat(lottoGame).isNotNull(),
			() -> assertThat(new HashSet<>(lottoGame.getLottoNumbers())).hasSize(6),
			() -> assertThat(lottoGame.getLottoNumbers()).isSortedAccordingTo(
				Comparator.comparingInt(LottoNumber::getValue)),
			() -> assertThat(lottoGame.getLottoNumbers()).hasSize(6),
			() -> assertThat(lottoGame.getLottoNumbers()).isEqualTo(
				lottoNumbers.stream()
					.sorted(Comparator.comparingInt(LottoNumber::getValue))
					.collect(Collectors.toList()))
		);
	}

	@DisplayName("로또 게임을 생성할 수 없다.")
	@ParameterizedTest
	@MethodSource("invalidLottoNumbers")
	void constructor_fail(List<LottoNumber> lottoNumbers) {
		// given & when & then
		assertThatThrownBy(() -> new LottoGame(() -> lottoNumbers))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
