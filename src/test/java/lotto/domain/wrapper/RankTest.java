package lotto.domain.wrapper;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RankTest {
	@DisplayName("로또번호 적중 개수별 금액 확인")
	@ParameterizedTest
	@CsvSource(value = {
		"0,false,0",
		"1,false,0",
		"2,false,0",
		"3,false,5000",
		"4,false,50000",
		"5,false,1500000",
		"6,false,2000000000",
	})
	public void winningMoneyByMatchedNumberCountTest(int matchedNumberCount, boolean matchBonus, int winningMoney) {
		assertThat(Rank.valueOf(matchedNumberCount, matchBonus).getWinningMoney()).isEqualTo(winningMoney);
	}
}
