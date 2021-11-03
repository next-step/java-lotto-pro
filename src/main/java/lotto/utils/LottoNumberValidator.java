package lotto.utils;

import static java.util.stream.Collectors.*;
import static lotto.constant.ErrorMessage.*;
import static lotto.constant.LottoNumberConstant.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import lotto.domain.LottoNumber;

public class LottoNumberValidator {

	private LottoNumberValidator() {}

	public static void validateLottoNumber(int number) {
		if (LOTTO_NUMBER_MIN <= number && number <= LOTTO_NUMBER_MAX) {
			return;
		}

		throw new IllegalArgumentException(MessageBuilder.build(INVALID_LOTTO_NUMBER, number));
	}

	public static void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
		List<Integer> numbers = lottoNumbers.stream()
											.map(LottoNumber::getNumber)
											.collect(toList());
		Set<Integer> numberSet = new LinkedHashSet<>(numbers);

		if (numberSet.size() != VALID_LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException(MessageBuilder.build(DUPLICATED_LOTTO_NUMBER, numbers));
		}
	}
}
