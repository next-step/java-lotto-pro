package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.List;

import lotto.generator.NumberGenerator;
import lotto.utils.LottoNumberMapper;
import lotto.utils.LottoNumberValidator;

public class LottoNumbers {
	private final List<LottoNumber> lottoNumbers;

	private LottoNumbers(List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public static LottoNumbers createBy(NumberGenerator numberGenerator) {
		List<LottoNumber> lottoNumbers = mapToLottoNumbers(numberGenerator.generate());
		return new LottoNumbers(lottoNumbers);
	}

	public static LottoNumbers of(List<Integer> numbers) {
		return new LottoNumbers(mapToLottoNumbers(numbers));
	}

	private static List<LottoNumber> mapToLottoNumbers(List<Integer> numbers) {
		List<LottoNumber> lottoNumbers = LottoNumberMapper.mapToLottoNumbers(numbers);
		LottoNumberValidator.validateLottoNumbers(lottoNumbers);

		return lottoNumbers;
	}

	public int countWinningNumbers(LottoNumbers lastWinningNumbers) {
		return (int) this.lottoNumbers.stream()
									  .filter(lastWinningNumbers::contains)
									  .count();
	}

	public boolean contains(LottoNumber lottoNumber) {
		return this.lottoNumbers.contains(lottoNumber);
	}

	public int getSize() {
		return this.lottoNumbers.size();
	}

	public List<LottoNumber> getValues() {
		return this.lottoNumbers;
	}

	@Override
	public String toString() {
		return this.lottoNumbers.stream()
								.map(LottoNumber::getNumber)
								.collect(toList())
								.toString();
	}
}
