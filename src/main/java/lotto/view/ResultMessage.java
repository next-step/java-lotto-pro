package lotto.view;

import lotto.domain.lotto.MatchRank;

public class ResultMessage {
	private final MatchRank matchRank;
	private final int quantity;

	public ResultMessage(MatchRank matchRank, int quantity) {
		this.matchRank = matchRank;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return String.format("%s- %d개", matchRankMessage(), quantity);
	}

	private String matchRankMessage() {
		return String.format(matchRankFormat(), matchRank.getMatchCount(), matchRank.getWinningPrice());
	}

	private String matchRankFormat() {
		if (matchRank == MatchRank.SECOND) {
			return "%d개 일치, 보너스 볼 일치(%d원)";
		}
		return "%d개 일치 (%d원)";
	}
}
