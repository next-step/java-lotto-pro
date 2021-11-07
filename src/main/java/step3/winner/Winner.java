package step3.winner;

import static step3.Constant.*;
import static step3.winner.WinningAmount.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import step3.Constant;
import step3.LottoNumber;
import step3.LottoNumbers;
import step3.LottoPapers;
import step3.Money;

public class Winner {

	private final Map<Integer, Integer> winningAmount;
	private final LottoPapers lottoPapers;
	private int sumWinningAmount;
	private BigDecimal yield;

	public Winner(LottoPapers lottoPapers) {
		this.lottoPapers = lottoPapers;
		winningAmount = new HashMap<>();
	}

	public Map<Integer, Integer> statistics(List<LottoNumber> lottoNumbers) {
		isNotEmpty(lottoNumbers);
		for (LottoNumbers lottoPapers : lottoPapers) {
			Integer winningCount = findMatchLottoNumber(lottoNumbers, lottoPapers);
			Integer winningAmount = WinningAmount.valueOf(winningCount);
			addWinnerList(winningCount, winningAmount);
			sumWinningAmount(winningAmount);
		}
		return winningAmount;
	}

	private void isNotEmpty(List<LottoNumber> lottoNumbers) {
		if (lottoNumbers.isEmpty()) {
			throw new IllegalArgumentException("로또번호가 정상적으로 생서되지 않았습니다.");
		}
	}

	private Integer findMatchLottoNumber(List<LottoNumber> lottoNumbers, LottoNumbers lottoPapers) {
		int matchCount = 0;
		for (LottoNumber lottoNumber : lottoNumbers) {
			matchCount += lottoPapers.match(lottoNumber);
		}
		return matchCount;
	}

	private void sumWinningAmount(Integer winningAmount) {
		sumWinningAmount += winningAmount;
	}

	private void addWinnerList(Integer matchNumber, Integer winningAmount) {
		this.winningAmount.put(matchNumber, winningAmount);
	}

	public void yield(Money inputWinningMoney) {
		WinningMoney winningMoney = new WinningMoney(inputWinningMoney);
		yield = winningMoney.yield(sumWinningAmount);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(THREE.getMessage()).append(getWinner(THREE.getMatch())).append(EACH).append(Constant.ENTER);
		sb.append(FOUR.getMessage()).append(getWinner(FOUR.getMatch())).append(EACH).append(ENTER);
		sb.append(FIVE.getMessage()).append(getWinner(FIVE.getMatch())).append(EACH).append(ENTER);
		sb.append(SIX.getMessage()).append(getWinner(SIX.getMatch())).append(EACH).append(ENTER);
		sb.append(TOTAL_YIELD).append(yield).append(END_OF_WORD);
		return sb.toString();
	}

	private Integer getWinner(int matchCount) {
		Optional<Integer> integer = Optional.ofNullable(winningAmount.get(matchCount));
		return integer.orElse(0);
	}
}
