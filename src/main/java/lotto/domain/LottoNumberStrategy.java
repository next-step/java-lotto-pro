package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface LottoNumberStrategy {
	Set<LottoNumber> pickNumbers();

	default Set<LottoNumber> convert(List<Integer> numbers) {
		return numbers.stream()
			.map(LottoNumber::from)
			.collect(Collectors.toSet());
	}
}
