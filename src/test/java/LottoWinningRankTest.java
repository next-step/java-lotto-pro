import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoWinningRankTest {

	@ParameterizedTest
	@CsvSource(value = {"6:FIRST", "5:THIRD", "4:FOURTH", "3:FIFTH", "2:OTHER", "1:OTHER", "0:OTHER"}, delimiter = ':')
	void valueOf_notBonus(int matchingCount, String rankName) {
		assertThat(LottoWinningRank.valueOf(matchingCount, false).name()).isEqualTo(rankName);
	}

	@Test
	void valueOf_second() {
		assertThat(LottoWinningRank.valueOf(5, true)).isEqualTo(LottoWinningRank.SECOND);
	}
}
