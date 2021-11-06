import java.util.Arrays;
import java.util.List;

import nextstep.utils.Console;

public class View {

	public String inPayKRW() {
		println(Message.INPUT_PAY_KRW.getContent());
		return Console.readLine();
	}

	public String inWinningLotto() {
		println(Message.INPUT_WINNING_LOTTO.getContent());
		return Console.readLine();
	}

	public String inBonus() {
		println(Message.INPUT_BONUS.getContent());
		return Console.readLine();
	}

	public void outBoughtLotto(List<Lotto> lottos) {
		println(String.format(Message.BOUGHT_LOTTO.getContent(), lottos.size()));
		lottos.stream().map(Lotto::toString).forEach(this::println);
	}

	public void outLottoWinningStatistics(LottoWinningStatistics statistics) {
		println(Message.WINNING_STATISTICS.getContent());
		println(Message.SEPARATOR.getContent());

		Arrays.asList(
			LottoWinningRank.FIFTH,
			LottoWinningRank.FOURTH,
			LottoWinningRank.THIRD,
			LottoWinningRank.SECOND,
			LottoWinningRank.FIRST
		).forEach(rank -> outLottoMatchingCount(rank, statistics));

		outLottoEarningRate(statistics.earningRate());
	}

	private void outLottoMatchingCount(LottoWinningRank rank, LottoWinningStatistics statistics) {
		final int matchingCount = rank.getMatchingCount();
		final int prizeKRW = rank.getPrizeKRW();
		final String message = rank.getExtraMessage();
		final Long numOfLottos = statistics.countLottos(rank);
		println(String.format(Message.COUNT_MATCHING.getContent()
			, matchingCount, message, prizeKRW, LottoStore.KRW_UNIT, numOfLottos));
	}

	private void outLottoEarningRate(double earningRate) {
		print(String.format(Message.EARNING_RATE.getContent(), earningRate));
		if (earningRate < LottoWinningStatistics.EARNING_RATE_BASE) {
			print(Message.EARNING_RATE_NOTE.getContent());
		}
	}

	public void error(String message) {
		println(String.format(Message.ERROR.getContent(), message));
	}

	public void space() {
		System.out.println();
	}

	private void println(String s) {
		System.out.println(s);
	}

	private void print(String s) {
		System.out.print(s);
	}
}
