package lotto.view;

import static lotto.constant.ViewMessage.*;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningRank;
import lotto.domain.WinningRecord;
import lotto.domain.WinningRecords;
import lotto.domain.WinningStatistics;
import lotto.utils.MessageBuilder;

public class ResultView {
	private static final double PROFIT_CRITERIA = 1.0;

	public void printLottos(Lottos lottos) {
		printLottoCount(lottos);

		for (Lotto lotto : lottos.getValues()) {
			System.out.println(lotto.getLottoNumbers());
		}
		newLine();
	}

	public void printWinningStatistics(WinningStatistics winningStatistics) {
		newLine();
		System.out.println(WINNING_STATISTICS_GUIDE_MESSAGE);
		System.out.println(DIVIDE_LINE);

		printWinningRecords(winningStatistics.getWinningRecords());
		printTotalProfitRate(winningStatistics.getRoundedTotalProfitRate());
	}

	private void printWinningRecords(WinningRecords winningRecords) {
		for (WinningRecord record : winningRecords.getValues()) {
			WinningRank winningRank = record.getWinningRank();
			System.out.println(MessageBuilder.build(WINNING_RANK_RECODE_RESULT_MESSAGE,
													winningRank.getWinningNumberCount(),
													decideWinningRecordBonusBallMessage(winningRank),
													winningRank.getPrizeMoney(),
													record.getCount()));
		}
	}

	private void printTotalProfitRate(double totalProfitRate) {
		System.out.println(MessageBuilder.build(TOTAL_PROFIT_RATE_MESSAGE,
												totalProfitRate,
												decideProfitOrLossStateMessage(totalProfitRate)));
	}

	private String decideWinningRecordBonusBallMessage(WinningRank winningRank) {
		if (winningRank.isSecondPlace()) {
			return WINNING_RANK_RECODE_RESULT_BONUS_BALL_MESSAGE;
		}

		return EMPTY_SPACE_MESSAGE;
	}

	private String decideProfitOrLossStateMessage(double totalProfitRate) {
		if (Double.compare(totalProfitRate, PROFIT_CRITERIA) == 0) {
			return NO_CHANGE_MESSAGE;
		}

		return Double.compare(totalProfitRate, PROFIT_CRITERIA) > 0 ? PROFIT_MESSAGE : LOSS_MESSAGE;
	}

	private void printLottoCount(Lottos lottos) {
		System.out.println(MessageBuilder.build(LOTTO_COUNT_MESSAGE, lottos.size()));
	}

	private void newLine() {
		System.out.println();
	}
}
