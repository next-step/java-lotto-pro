package lotto.view;

import java.util.Set;
import java.util.stream.Collectors;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

public class LottoMessage {
	private final Lotto lotto;

	public LottoMessage(Lotto lotto) {
		this.lotto = lotto;
	}

	@Override
	public String toString() {
		Set<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
		return lottoNumbers.stream()
			.sorted()
			.map(LottoNumber::getInt)
			.map(Object::toString)
			.collect(Collectors.joining(", ", "[", "]"));
	}
}
