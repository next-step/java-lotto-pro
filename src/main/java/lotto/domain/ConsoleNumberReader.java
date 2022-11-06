package lotto.domain;

import lotto.view.InputView;

public class ConsoleNumberReader implements NumberReader<LottoNumbers> {
	@Override
	public LottoNumbers read() {
		return InputView.readLottoNumbers();
	}
}
