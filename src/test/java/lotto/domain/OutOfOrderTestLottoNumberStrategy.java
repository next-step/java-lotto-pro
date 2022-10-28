package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class OutOfOrderTestLottoNumberStrategy implements LottoNumberStrategy {
	@Override
	public List<Integer> pickNumbers() {
		return Arrays.asList(6, 5, 4, 3, 2, 1);
	}
}
