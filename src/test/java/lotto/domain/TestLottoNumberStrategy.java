package lotto.domain;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestLottoNumberStrategy implements LottoNumberStrategy {
	@Override
	public Set<LottoNumber> pickNumbers() {
		return IntStream.rangeClosed(1, 6)
			.mapToObj(LottoNumber::new)
			.collect(Collectors.toSet());
	}
}
