package lotto.domain;

import java.util.List;

import lotto.utils.LottoNumberMapper;
import lotto.utils.LottoNumberValidator;

public class WinningNumbers {
	private final List<LottoNumber> winningNumbers;

	private WinningNumbers(List<LottoNumber> winningNumbers) {
		this.winningNumbers = winningNumbers;
	}

	public static WinningNumbers createBy(List<Integer> numbers) {
		List<LottoNumber> winningNumbers = LottoNumberMapper.mapToLottoNumbers(numbers);
		LottoNumberValidator.validateLottoNumbers(winningNumbers);

		return new WinningNumbers(winningNumbers);
	}

	public int getSize() {
		return this.winningNumbers.size();
	}

	public List<LottoNumber> getValues() {
		return this.winningNumbers;
	}
}
