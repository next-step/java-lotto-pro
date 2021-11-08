package step3.winner;

import java.math.BigDecimal;
import java.util.List;

import step3.LottoNumber;
import step3.LottoPapers;

public class Winner {


	public int statistics(List<LottoNumber> userLottoNumbers, LottoPapers createLottoNumbers) {
		return createLottoNumbers.findMatchLottoNumber(userLottoNumbers);
	}

	public BigDecimal yield(int money, int total) {
		WinningMoney winningMoney = new WinningMoney();
		return winningMoney.yield(new BigDecimal(String.valueOf(money)), total);
	}

}
