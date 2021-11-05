package lottoLegacy;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningTest {

	@Test
	@DisplayName("5000원 투자 3등 당첨 4개인 경우 수익률 4.00 return")
	public void 수익률_계산() {
		//given
		int investment = 5000;
		Winning winning = new Winning();
		for (int i = 0; i < 4; i++) {
			winning.addWinningMap(3, false);
		}
		//when
		String yield = winning.getYield(investment);
		//then
		assertThat(yield).isEqualTo("4.00");
	}

}