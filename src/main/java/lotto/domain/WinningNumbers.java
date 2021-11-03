package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.utils.LottoNumberMapper;
import lotto.utils.LottoNumberValidator;

public class WinningNumbers {
	public static final int WINNING_LOTTO_CONDITION_MIN_NUMBER_SIZE = 3;

	private final List<LottoNumber> winningNumbers;

	private WinningNumbers(List<LottoNumber> winningNumbers) {
		this.winningNumbers = winningNumbers;
	}

	public static WinningNumbers createBy(List<Integer> numbers) {
		List<LottoNumber> winningNumbers = LottoNumberMapper.mapToLottoNumbers(numbers);
		LottoNumberValidator.validateLottoNumbers(winningNumbers);

		return new WinningNumbers(winningNumbers);
	}

	public static WinningNumbers createDefault() {
		return new WinningNumbers(new ArrayList<>());
	}

	public boolean isWinningNumber(LottoNumber lottoNumber) {
		return this.winningNumbers.contains(lottoNumber);
	}

	public boolean isWinning() {
		return this.winningNumbers.size() >= WINNING_LOTTO_CONDITION_MIN_NUMBER_SIZE;
	}

	public void add(LottoNumber lottoNumber) {
		this.winningNumbers.add(lottoNumber);
	}

	public int getSize() {
		return this.winningNumbers.size();
	}

	public List<LottoNumber> getValues() {
		return this.winningNumbers;
	}
}
