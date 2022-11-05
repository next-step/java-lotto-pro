package lotto.domain;

import lotto.domain.strategy.GenerateStrategy;
import lotto.view.InputView;

public class ManualGenerateStrategy implements GenerateStrategy {

	@Override
	public LottoNumbers generate() {
		return InputView.readLottoNumbers();
	}
}
