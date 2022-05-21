package view;

import java.util.List;

import lotto.model.LottoNumbers;
import lotto.model.Lottos;
import lotto.model.WinningList;
import lotto.model.WinningMoney;

public class ResultView {
	private static final String LEFT_SQUARE_BRACKET = "[";
	private static final String RIGHT_SQUARE_BRACKET = "]";
	private static final String COMMA_OWN_SPACE = ", ";

	private ResultView() {
	}

	public static void printLottos(Lottos manualLottos, Lottos autoLottos) {
		System.out.printf("\n수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualLottos.size(), autoLottos.size());
		lottosPrint(manualLottos.getLottos());
		lottosPrint(autoLottos.getLottos());
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
		if (winningMoney.isSecondPlace()) {
			return String.format("%d개 일치, 보너스 볼 일치(%d원)- %d개", winningMoney.getMatchCount(),
					winningMoney.getWinningMoney(), matchCount);
		}
		return String.format("%d개 일치 (%d원)- %d개", winningMoney.getMatchCount(), winningMoney.getWinningMoney(),
				matchCount);
	}

	private static void lottosPrint(List<LottoNumbers> lottos) {
		for (LottoNumbers lottoNumbers : lottos) {
			System.out.println(lottoNumbersStringFormat(lottoNumbers));
		}
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
