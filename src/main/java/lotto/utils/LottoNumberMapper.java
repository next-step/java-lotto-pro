package lotto.utils;

import static java.util.stream.Collectors.*;

import java.util.List;

import lotto.domain.LottoNumber;

public class LottoNumberMapper {

	private LottoNumberMapper() {}

	public static List<LottoNumber> mapToLottoNumbers(List<Integer> numbers) {
		return numbers.stream()
					  .map(LottoNumber::of)
					  .collect(toList());
	}
}
