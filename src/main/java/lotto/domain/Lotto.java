package lotto.domain;

import java.util.List;

public class Lotto {
	private final String INVALID_SIZE = "로또 번호는 6개를 입력해야 합니다.";
	private final int LOTTO_SIZE = 6;

	public Lotto(List<Integer> integers) {
		validSize(integers);
	}

	private void validSize(List<Integer> integers) {
		if(integers.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException(INVALID_SIZE);
		}
	}
}
