package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.UserMoney;
import lotto.model.WinningList;

public class LottoResultTest {
	private LottoResult lottoResult;
	private int sum = 0;

	@BeforeEach
	void setUp() {
		lottoResult = new LottoResult();
	}

	@Test
	@DisplayName("로또 구입 테스트")
	void buy_lotto() {
		assertThat(lottoResult.buyAutoLottos(new UserMoney("1000"))).hasSize(1);
	}

	@Test
	@DisplayName("당첨 리스트 생성 테스트")
	void lotto_profitRate() {
		// given
		sum = 0;
		UserMoney userMoney = new UserMoney("1000");

		List<LottoNumber> lottoNumbers = new ArrayList<>();
		lottoNumbers.add(new LottoNumber(1));
		lottoNumbers.add(new LottoNumber(2));
		lottoNumbers.add(new LottoNumber(3));
		lottoNumbers.add(new LottoNumber(4));
		lottoNumbers.add(new LottoNumber(5));
		lottoNumbers.add(new LottoNumber(6));
		LottoNumbers winningLottoNumbers = new LottoNumbers(lottoNumbers);

		// when
		lottoResult.buyAutoLottos(userMoney);
		WinningList winningList = lottoResult.winningList(winningLottoNumbers);
		winningList.getWinningList().entrySet().forEach((entry) -> sum += entry.getValue());

		// then
		assertEquals(sum, 1);
	}
}
