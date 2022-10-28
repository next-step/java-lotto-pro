package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class RandomLottoNumberStrategy implements LottoNumberStrategy {
	@Override
	public List<Integer> pickNumbers() {
		return Arrays.asList(1, 2, 3, 4, 5, 6);
	}
}
