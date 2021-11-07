package lotto.view;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

public class ResultView {

	private static final String PURCHASED_COUNT = "%d개를 구매했습니다.";
	private static final String OPEN_BRACKET = "[";
	private static final String CLOSE_BRACKET = "]";
	private static final String NUMBER_DELIMITER = ", ";

	public void printPurchasedLottos(Lottos lottos) {
		String purchasedMessage = String.format(PURCHASED_COUNT, lottos.size());
		System.out.println(purchasedMessage);

		for (Lotto lotto : lottos.lottos()) {
			System.out.println(makeLottNumberPrintString(lotto));
		}
	}

	private String makeLottNumberPrintString(Lotto lotto) {
		StringBuilder builder = new StringBuilder();

		builder.append(OPEN_BRACKET);
		builder.append(makeLottoNumberString(lotto));
		builder.append(CLOSE_BRACKET);

		return builder.toString();
	}

	private String makeLottoNumberString(Lotto lotto) {
		StringBuilder builder = new StringBuilder();
		List<LottoNumber> numbers = lotto.numbers();
		int lastIndex = numbers.size() - 1;

		for (int i = 0; i < lastIndex; i++) {
			LottoNumber lottoNumber = numbers.get(i);
			builder.append(lottoNumber.number());
			builder.append(NUMBER_DELIMITER);
		}

		builder.append(numbers.get(lastIndex).number());
		return builder.toString();
	}
}
