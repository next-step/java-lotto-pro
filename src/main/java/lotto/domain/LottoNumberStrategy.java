package lotto.domain;

import java.util.List;

public interface LottoNumberStrategy {
	List<Number> generate(int limit);
}
