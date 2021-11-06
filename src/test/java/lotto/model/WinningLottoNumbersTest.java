package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoNumbersTest {
	static WinningLottoNumbers winningLottoNumbers;

	@BeforeAll
	static void beforeAll() {
		winningLottoNumbers = new WinningLottoNumbers(2,7,12,18,32,34);
	}

	@Test
	@DisplayName("로또 당첨 결과 확인 - 3개 매치")
	void matchThree() {
		Lotto lotto = new Lotto(new LottoNumbers(2,7,12,22,24,25));
		LottoResult result = winningLottoNumbers.result(lotto);
		assertThat(result).isEqualTo(LottoResult.MATCH_THREE);
	}

	@Test
	@DisplayName("로또 당첨 결과 확인 - 4개 매치")
	void matchFour() {
		Lotto lotto = new Lotto(new LottoNumbers(2,7,12,18,24,25));
		LottoResult result = winningLottoNumbers.result(lotto);
		assertThat(result).isEqualTo(LottoResult.MATCH_FOUR);
	}

	@Test
	@DisplayName("로또 당첨 결과 확인 - 5개 매치")
	void matchFive() {
		Lotto lotto = new Lotto(new LottoNumbers(2,7,12,18,32,25));
		LottoResult result = winningLottoNumbers.result(lotto);
		assertThat(result).isEqualTo(LottoResult.MATCH_FIVE);
	}

	@Test
	@DisplayName("로또 당첨 결과 확인 - 6개 매치")
	void matchSix() {
		Lotto lotto = new Lotto(new LottoNumbers(2,7,12,18,32,34));
		LottoResult result = winningLottoNumbers.result(lotto);
		assertThat(result).isEqualTo(LottoResult.MATCH_SIX);
	}
}
