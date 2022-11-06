package lotto.reader;

import lotto.domain.LottoNumbers;
import lotto.view.InputView;

public class ConsoleNumberReader implements NumberReader<LottoNumbers> {
	@Override
	public LottoNumbers read() {
		return InputView.readLottoNumbers();
	}
}
