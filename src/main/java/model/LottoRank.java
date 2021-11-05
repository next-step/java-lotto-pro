package model;

import java.util.Arrays;

public enum LottoRank {

	FIRST(6, 2_000_000_000, (count, isMatchedBonus) -> count == 6),
	SECOND(5, 30_000_000, (count, isMatchedBonus) -> count == 5 && isMatchedBonus),
	THIRD(5, 1_500_000, (count, isMatchedBonus) -> count == 5 && !isMatchedBonus),
	FOURTH(4, 50_000, (count, isMatchedBonus) -> count == 4),
	FIFTH(3, 5_000, (count, isMatchedBonus) -> count == 3),
	NONE(0, 0, (count, isMatchedBonus) -> count <= 2);

	private final int matchCount;
	private final int prizeMoney;
	private final MatchCondition condition;

	LottoRank(int matchCount, int prizeMoney, MatchCondition condition) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
		this.condition = condition;
	}

	public static LottoRank byMatchCountAndBonus(int matchCount, boolean isMatchedBonus) {
		return Arrays.stream(LottoRank.values())
			.filter(lottoRank -> lottoRank.condition.match(matchCount, isMatchedBonus))
			.findFirst()
			.orElse(NONE);
	}

	@Override
	public String toString() {
		String bonusMatchString = "";
		if (this == SECOND) {
			bonusMatchString = ", 보너스 볼 일치";
		}
		return String.format("%d개 일치%s(%d원)", this.matchCount, bonusMatchString, this.prizeMoney);
	}

	public int multipliedPrizeMoney(int count) {
		return prizeMoney * count;
	}
}
