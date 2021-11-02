package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerNumberTest {

	@Test
	@DisplayName("당첨번호 리스트 객체 생성한다.")
	public void 당첨번호_리스트_생성() throws Exception {
		String input = "1,2,3,4,5,6";
	    WinnerNumber winnerNumber = new WinnerNumber(input);
	    assertThat(winnerNumber.getWinnerNumber().getInput().size()).isEqualTo(6);
	    assertThat(winnerNumber.getWinnerNumber().getInput()).containsExactly(1,2,3,4,5,6);
	}

}