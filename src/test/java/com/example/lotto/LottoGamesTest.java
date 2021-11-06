package com.example.lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 게임들")
class LottoGamesTest {

	@DisplayName("로또게임들을 수동으로 생성한다.")
	@Test
	void manual() {
		// given & when
		LottoGames lottoGames = LottoGames.manual(
			Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 7)));

		// then
		assertThat(lottoGames).isNotNull();
	}

	@DisplayName("로또게임들을 자동으로 생성한다.")
	@Test
	void auto() {
		// given & when
		LottoGames lottoGames = LottoGames.auto(5, (from, to, size) -> Arrays.asList(1, 2, 3, 4, 5, 6));

		// then
		assertThat(lottoGames).isNotNull();
	}

	@DisplayName("로또게임들을 합칠 수 있다.")
	@Test
	void merge() {
		// given
		LottoGames first = LottoGames.manual(Collections.singletonList(Arrays.asList(1, 2, 3, 4, 5, 6)));
		LottoGames second = LottoGames.auto(5, (from, to, size) -> Arrays.asList(1, 2, 3, 4, 5, 6));

		// when
		LottoGames merge = LottoGames.merge(first, second);

		// then
		assertAll(
			() -> assertThat(merge).isNotNull(),
			() -> assertThat(merge.getValues()).hasSize(6)
		);
	}
}
