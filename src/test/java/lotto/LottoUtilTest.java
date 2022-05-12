package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;

public class LottoUtilTest {

	@Test
	@DisplayName("로또 번호 생성 테스트")
	void create_random_lottoNumber() {
		assertAll(() -> assertThat(LottoUtil.randomLottoNumbers()).hasSize(6),
				() -> assertThat(new LottoNumbers(LottoUtil.randomLottoNumbers())));
	}

	@Test
	@DisplayName("로또 금액 테스트")
	void lotto_price() {
		assertEquals(LottoUtil.LOTTO_PRICE, 1000);
	}

	@Test
	@DisplayName("로또 등수에 맞는 당첨금 테스트")
	void lotto_win_money() {
		assertAll(() -> assertEquals(LottoUtil.WIN_MONEYS[0], 0), 
				() -> assertEquals(LottoUtil.WIN_MONEYS[1], 0),
				() -> assertEquals(LottoUtil.WIN_MONEYS[2], 0), 
				() -> assertEquals(LottoUtil.WIN_MONEYS[3], 5000),
				() -> assertEquals(LottoUtil.WIN_MONEYS[4], 50000),
				() -> assertEquals(LottoUtil.WIN_MONEYS[5], 1500000),
				() -> assertEquals(LottoUtil.WIN_MONEYS[6], 2000000000));
	}

}
