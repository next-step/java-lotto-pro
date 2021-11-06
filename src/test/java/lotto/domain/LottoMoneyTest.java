package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoMoneyTest {

	@Test
	public void init() {
		LottoMoney money = new LottoMoney("15000");
		assertThat(money).isEqualTo(new LottoMoney("15000"));
	}

	@Test
	public void 지불_금액에_따른_숫자반환() {
		LottoMoney money = new LottoMoney("15000");
		int result = money.buyCount();
		assertThat(result).isEqualTo(15);
	}

	@Test
	public void 지불_금액이_맞지_않은_경우() {
		assertThatThrownBy(() ->
			new LottoMoney("18500")
		).isInstanceOf(IllegalArgumentException.class);
	}
}
