package view;

import java.io.PrintStream;

import model.LottoRank;
import model.common.Score;

public final class ScoreView {

	private static final String RANK_COUNT_FORMAT = "%s- %d개";

	private final PrintStream printer;

	private ScoreView(PrintStream printer) {
		this.printer = printer;
	}

	public static ScoreView from(PrintStream printer) {
		return new ScoreView(printer);
	}

	public void view(Score score) {
		printRank(score, LottoRank.FIFTH);
		printRank(score, LottoRank.FOURTH);
		printRank(score, LottoRank.THIRD);
		printRank(score, LottoRank.SECOND);
		printRank(score, LottoRank.FIRST);
	}

	private void printRank(Score score, LottoRank rank) {
		printer.printf(RANK_COUNT_FORMAT, rank, score.count(rank));
		printer.println();
	}
}
