import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import nextstep.utils.Console;
import step2.PositiveNumber;

public class View {

	public String inPayKRW() {
		println(Message.INPUT_PAY_KRW.getContent());
		return Console.readLine();
	}

	public String inNumOfManualLottos() {
		println(Message.INPUT_NUM_OF_MANUAL_LOTTOS.getContent());
		return Console.readLine();
	}

	public List<String> inManualLottos(PositiveNumber numOfLottos) {
		println(Message.INPUT_MANUAL_LOTTOS.getContent());
		return IntStream.range(0, numOfLottos.get())
			.mapToObj(i -> Console.readLine())
			.collect(Collectors.toList());
	}

	public String inWinningLotto() {
		println(Message.INPUT_WINNING_LOTTO.getContent());
		return Console.readLine();
	}

	public String inWinningBonus() {
		println(Message.INPUT_WINNING_BONUS.getContent());
		return Console.readLine();
	}

	public void outBoughtLottos(int numOfManualLottos, List<Lotto> lottos) {
		final int numOfAutoLottos = lottos.size() - numOfManualLottos;
		println(String.format(Message.BOUGHT_LOTTO.getContent(), numOfManualLottos, numOfAutoLottos));
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
		).forEach(rank -> outNumOfLottosByRank(rank, statistics));

		outLottoEarningRate(statistics.earningRate());
	}

	private void outNumOfLottosByRank(LottoWinningRank rank, LottoWinningStatistics statistics) {
		final int matchingCount = rank.getMatchingCount();
		final String matchingBonusMessage = getMatchingBonusMessageBy(rank);
		final int prizeKRW = rank.getPrizeKRW();
		final Long numOfLottos = statistics.countLottos(rank);
		println(String.format(Message.COUNT_MATCHING.getContent()
			, matchingCount, matchingBonusMessage, prizeKRW, LottoStore.KRW_UNIT, numOfLottos));
	}

	private String getMatchingBonusMessageBy(LottoWinningRank rank) {
		if (LottoWinningRank.SECOND == rank) {
			return Message.MATCH_WINNING_BONUS.getContent();
		}
		return "";
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
