package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.LottoNumbers;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.model.WinningMoney;

public class LottoResultTest {

	private Lottos lottos;

	@BeforeEach
	void setup() {
		List<LottoNumbers> lottos = new ArrayList<>();
		lottos.add(new LottoNumbers("1,2,3,4,5,6"));
		lottos.add(new LottoNumbers("1,2,3,4,5,7"));
		this.lottos = new Lottos(lottos);
	}

	@Test
	@DisplayName("수익률 구하기")
	void buy_lotto_auto() {
		WinningLotto winningLotto = new WinningLotto(new LottoNumbers("1,2,3,4,5,7"), "6");
		LottoResult lottoResult = new LottoResult(winningLotto, this.lottos);
		assertEquals(lottoResult.profitRate(1000),
				(WinningMoney.FIRST.getWinningMoney() + WinningMoney.SECOND.getWinningMoney()) / 2000);
	}

	@Test
	@DisplayName("2등이 포함된 수익률 구하기")
	void buy_lotto_auto_contains_second() {
		List<LottoNumbers> lottos = new ArrayList<>();
		lottos.add(new LottoNumbers("1,2,3,4,5,6"));
		lottos.add(new LottoNumbers("1,2,3,4,5,7"));

		WinningLotto winningLotto = new WinningLotto(new LottoNumbers("1,2,3,4,5,8"), "7");
		LottoResult lottoResult = new LottoResult(winningLotto, this.lottos);
		assertEquals(lottoResult.profitRate(1000),
				(WinningMoney.THIRD.getWinningMoney() + WinningMoney.SECOND.getWinningMoney()) / 2000);
	}
}
