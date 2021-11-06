package model.generator;

import model.Lotto;

public interface LottoGenerator<T extends Lotto> {

	T lotto();
}
