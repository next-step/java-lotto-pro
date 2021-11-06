package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("로또 순위")
class LottoRankTest {

	@ParameterizedTest(name = "{displayName}[{index}] when the match count is {0}, rank is {1}")
	@DisplayName("일치 갯수에 따른 순위")
	@CsvSource({"0,NONE", "1,NONE", "2,NONE", "3,FIFTH", "4,FOURTH", "5,THIRD", "6,FIRST"})
	void byMatchCountAndBonus(int matchCount, LottoRank expected) {
		//when, then
		assertThat(LottoRank.byMatchCountAndBonus(matchCount, false))
			.isEqualTo(expected);
	}
}
