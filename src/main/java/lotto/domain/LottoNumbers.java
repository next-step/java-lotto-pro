package lotto.domain;

import static java.util.stream.Collectors.*;
import static lotto.constant.ErrorMessage.*;
import static lotto.constant.LottoNumberConstant.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import lotto.generator.NumberGenerator;
import lotto.utils.MessageBuilder;

public class LottoNumbers {
	private final List<LottoNumber> lottoNumbers;

	private LottoNumbers(List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public static LottoNumbers createBy(NumberGenerator numberGenerator) {
		List<LottoNumber> lottoNumbers = mapToLottoNumbers(numberGenerator.generate());
		validateLottoNumbers(lottoNumbers);

		return new LottoNumbers(lottoNumbers);
	}

	private static List<LottoNumber> mapToLottoNumbers(List<Integer> numbers) {
		return numbers.stream()
					  .map(LottoNumber::of)
					  .collect(toList());
	}

	private static void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
		List<Integer> numbers = lottoNumbers.stream()
											.map(LottoNumber::getNumber)
											.collect(toList());
		Set<Integer> numberSet = new LinkedHashSet<>(numbers);

		if (numberSet.size() != VALID_LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException(MessageBuilder.build(DUPLICATED_LOTTO_NUMBER, numbers));
		}
	}

	public int getSize() {
		return this.lottoNumbers.size();
	}

	public List<LottoNumber> getValues() {
		return this.lottoNumbers;
	}
}
