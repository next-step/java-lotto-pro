package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.utils.MessageBuilder;

public class ResultView {
	private static final String LOTTO_COUNT_MESSAGE = "%s개를 구매했습니다.";

	public void printLottos(Lottos lottos) {
		printLottoCount(lottos);

		for (Lotto lotto : lottos.getValues()) {
			System.out.println(lotto.getLottoNumbers());
		}
		newLine();
	}

	private void printLottoCount(Lottos lottos) {
		System.out.println(MessageBuilder.build(LOTTO_COUNT_MESSAGE, lottos.getSize()));
	}

	private void newLine() {
		System.out.println();
	}
}
