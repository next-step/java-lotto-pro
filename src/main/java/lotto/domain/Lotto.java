package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
	public static final int PRICE = 1000;

	private final Set<LottoNumber> lottoNumbers;

	public Lotto() {
		List<Integer> numbers = new ArrayList<>();
		this.lottoNumbers = numbers.stream()
			.map(LottoNumber::new)
			.collect(Collectors.toSet());
	}
}
