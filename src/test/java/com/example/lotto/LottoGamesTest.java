package com.example.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 게임들")
class LottoGamesTest {

	@DisplayName("로또게임들을 생성한다.")
	@Test
	void constructor() {
		// given & when
		LottoGames lottoGames = new LottoGames(5, (from, to, size) -> Arrays.asList(1, 2, 3, 4, 5, 6));

		// then
		assertThat(lottoGames).isNotNull();
	}
}
