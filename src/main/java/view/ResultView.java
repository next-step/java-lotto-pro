package view;

import java.util.List;

import lotto.model.LottoNumbers;
import lotto.model.WinningList;
import lotto.model.WinningMoney;

public class ResultView {
	private static final String LEFT_SQUARE_BRACKET = "[";
	private static final String RIGHT_SQUARE_BRACKET = "]";
	private static final String COMMA_OWN_SPACE = ", ";

	public static void printLottos(List<LottoNumbers> lottos) {
		System.out.println(lottoNumbersTitleStringFormat(lottos));
		for (int i = 0; i < lottos.size(); ++i) {
			System.out.println(lottoNumbersStringFormat(lottos.get(i)));
		}
	}

	public static void printWinStatistics(WinningList winningList) {
		System.out.println("\n당첨 통계\n---------");
		winningList.getWinningList().remove(WinningMoney.OTHER);
		winningList.getWinningList()
				.forEach((winningMoney, count) -> System.out.println(winLottoCountStringFormat(winningMoney, count)));

	}

	public static void printProfitRate(double profitRate) {
		System.out.println(profitRateStringFormat(profitRate));
	}

	private static String profitRateStringFormat(double profitRate) {
		return String.format("총 수익률은 %.02f입니다.", profitRate);
	}

	private static String winLottoCountStringFormat(WinningMoney winningMoney, int matchCount) {
		return String.format("%d개 일치 (%d원)- %d개", winningMoney.getMatchCount(), winningMoney.getWinningMoney(),
				matchCount);
	}

	private static String lottoNumbersTitleStringFormat(List<LottoNumbers> lottos) {
		return String.format("%d개를 구매했습니다.", lottos.size());
	}

	private static String lottoNumbersStringFormat(LottoNumbers lottoNumbers) {
		StringBuffer lottoNumbersMessage = new StringBuffer();
		lottoNumbersMessage.append(LEFT_SQUARE_BRACKET);
		for (int i = 0; i < lottoNumbers.getLottoNumbers().size(); ++i) {
			String lottoNumberMessage = lottoNumbersStringFormatAddComma(i, lottoNumbers.getLottoNumbers().size() - 1,
					lottoNumbers.getLottoNumbers().get(i).getLottoNumber());
			lottoNumbersMessage.append(lottoNumberMessage);
		}
		lottoNumbersMessage.append(RIGHT_SQUARE_BRACKET);
		return lottoNumbersMessage.toString();
	}

	private static String lottoNumbersStringFormatAddComma(int index, int maxSize, int value) {
		if (index != maxSize) {
			return value + COMMA_OWN_SPACE;
		}
		return value + "";
	}
}
