package lotto.view;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningRank;
import lotto.domain.WinningRecord;
import lotto.domain.WinningStatistics;
import lotto.utils.MessageBuilder;

public class ResultView {
	private static final String LOTTO_COUNT_MESSAGE = "%s개를 구매했습니다.";
	private static final String WINNING_STATISTICS_GUIDE_MESSAGE = "당첨 통계";
	private static final String WINNING_RANK_RECODE_RESULT_MESSAGE = "%s개 일치 (%s원)- %s개";
	private static final String DIVIDE_LINE = "---------";

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
	}

	private void printWinningRecords(List<WinningRecord> winningRecords) {
		for (WinningRecord record : winningRecords) {
			WinningRank winningRank = record.getWinningRank();
			System.out.println(MessageBuilder.build(WINNING_RANK_RECODE_RESULT_MESSAGE,
													winningRank.getWinningNumberCount(),
													winningRank.getPrizeMoney(),
													record.getCount()));
		}
	}

	private void printLottoCount(Lottos lottos) {
		System.out.println(MessageBuilder.build(LOTTO_COUNT_MESSAGE, lottos.getSize()));
	}

	private void newLine() {
		System.out.println();
	}
}
