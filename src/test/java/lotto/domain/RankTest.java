package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RankTest {
	@ParameterizedTest
	@CsvSource(value = {"6:FIRST", "5:THIRD", "4:FOURTH", "3:FIFTH"}, delimiter = ':')
	@DisplayName("당첨 확인")
	void winning(int matchCount, Rank rank) {
		assertThat(Rank.matchPrize(matchCount)).isEqualTo(rank);
	}

	@Test
	@DisplayName("보너스 번호 당첨 확인")
	void bonus_winning() {
		assertThat(Rank.matchPrize(4, true)).isEqualTo(Rank.SECOND);
		assertThat(Rank.matchPrize(5, false)).isEqualTo(Rank.THIRD);
	}
}
