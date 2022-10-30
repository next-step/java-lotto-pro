package lotto.strategy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoRandomCreateStrategyTest {

	@Test
	void 로또_생성() {
		LottoRandomCreateStrategy lottoRandomCreateStrategy = new LottoRandomCreateStrategy();
		assertDoesNotThrow(lottoRandomCreateStrategy::create);
	}
}
