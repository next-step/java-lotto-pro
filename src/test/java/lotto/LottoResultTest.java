package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.LottoNumbers;
import lotto.model.Lottos;
import lotto.model.WinningMoney;

public class LottoResultTest {

	@Test
	@DisplayName("수익률 구하기")
	void buy_lotto_auto() {
		List<LottoNumbers> lottos = new ArrayList<>();
		lottos.add(new LottoNumbers("1,2,3,4,5,6"));
		lottos.add(new LottoNumbers("1,2,3,4,5,7"));

		LottoResult lottoResult = new LottoResult(new Lottos(lottos), new LottoNumbers("1,2,3,4,5,6"), "8");
		assertEquals(lottoResult.profitRate(1000),
				(WinningMoney.SIX.getWinningMoney() + WinningMoney.FIVE.getWinningMoney()) / 2000);
	}
	
	@Test
	@DisplayName("2등이 포함된 수익률 구하기")
	void buy_lotto_auto_contains_second() {
		List<LottoNumbers> lottos = new ArrayList<>();
		lottos.add(new LottoNumbers("1,2,3,4,5,6"));
		lottos.add(new LottoNumbers("1,2,3,4,5,7"));

		LottoResult lottoResult = new LottoResult(new Lottos(lottos), new LottoNumbers("1,2,3,4,5,8"), "7");
		assertEquals(lottoResult.profitRate(1000),
				(WinningMoney.FIVE.getWinningMoney() + WinningMoney.FIVE_BOUNS.getWinningMoney()) / 2000);
	}
}
