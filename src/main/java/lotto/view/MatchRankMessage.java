package lotto.view;

import lotto.domain.lotto.MatchRank;

public enum MatchRankMessage {
	THREE_MATCH_MESSAGE(MatchRank.THREE_MATCH, "3개 일치 (5000원)"),
	FOUR_MATCH_MESSAGE(MatchRank.FOUR_MATCH, "4개 일치 (50000원)"),
	FIVE_MATCH_MESSAGE(MatchRank.FIVE_MATCH, "5개 일치 (1500000원)"),
	FIVE_MATCH_WITH_BONUS_MESSAGE(MatchRank.FIVE_MATCH_WITH_BONUS, "5개 일치, 보너스 볼 일치(30000000원)"),
	SIX_MATCH_MESSAGE(MatchRank.SIX_MATCH, "6개 일치 (2000000000원)");

	private final MatchRank matchRank;
	private final String message;

	MatchRankMessage(MatchRank matchRank, String message) {
		this.matchRank = matchRank;
		this.message = message;
	}

	public MatchRank getMatchRank() {
		return matchRank;
	}

	public String getMessage() {
		return message;
	}
}
