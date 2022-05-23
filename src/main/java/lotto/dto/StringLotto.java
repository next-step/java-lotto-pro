package lotto.dto;

import java.util.List;

import lotto.domain.Lotto;

public class StringLotto {
	private List<String> lotto;

	public StringLotto(List<String> lotto) {
		this.lotto = lotto;
	}

	public static StringLotto of(List<String> lotto) {
		return new StringLotto(lotto);
	}

	public Lotto convertToLotto() {
		return Lotto.getInstanceByString(lotto);
	}
}
