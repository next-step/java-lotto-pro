import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoWinningRankTest {

	@ParameterizedTest
	@CsvSource(value = {
		"6:true:FIRST", "6:false:FIRST",
		"5:true:SECOND",
		"5:false:THIRD",
		"4:true:FOURTH", "4:false:FOURTH",
		"3:true:FIFTH", "3:false:FIFTH",
		"2:true:OTHER", "2:false:OTHER",
		"1:true:OTHER", "1:false:OTHER",
		"0:true:OTHER", "0:false:OTHER",
	}, delimiter = ':')
	void valueOf(int matchingCount, boolean hasBonus, String rankName) {
		assertThat(LottoWinningRank.valueOf(matchingCount, hasBonus).name()).isEqualTo(rankName);
	}
}
