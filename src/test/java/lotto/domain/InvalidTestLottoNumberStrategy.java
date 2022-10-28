package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class InvalidTestLottoNumberStrategy implements LottoNumberStrategy {
	@Override
	public List<Integer> pickNumbers() {
		return Arrays.asList(1, 2, 3, 4);
	}
}
