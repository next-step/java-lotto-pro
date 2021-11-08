package model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {
	@Test
	@DisplayName("14000원으로 구입할 수 있는 로또 개수는 14")
	void 구입_금액에_해당하는_로또_개수1() {
		PurchaseCount result = Lottos.purchaseCountFrom(Money.of("14000"));

		assertThat(result).isEqualTo(new PurchaseCount(14));
	}

	@Test
	@DisplayName("500원으로 구입할 수 있는 로또 개수는 0")
	void 구입_금액에_해당하는_로또_개수2() {
		PurchaseCount result = Lottos.purchaseCountFrom(Money.of("500"));

		assertThat(result).isEqualTo(new PurchaseCount(0));
	}

	@Test
	@DisplayName("7500원으로 구입할 수 있는 로또 개수는 7")
	void 구입_금액에_해당하는_로또_개수3() {
		PurchaseCount result = Lottos.purchaseCountFrom(Money.of("7500"));

		assertThat(result).isEqualTo(new PurchaseCount(7));
	}

	@Test
	@DisplayName("두 장 구매, 한 장 3개 일치, 한 장 4개 일치하는 경우")
	void 당첨_통계_데이터1() {
		Lottos lottos = new Lottos(Lists.newArrayList(
			new Lotto(Lists.newArrayList(1, 2, 3, 4, 5, 6)),
			new Lotto(Lists.newArrayList(4, 5, 6, 7, 8, 9)))
		);

		LastWeekWinningNumber winningNumber = LastWeekWinningNumber.of("3, 4, 5, 6, 10, 11");
		winningNumber.updateBonusBall(BonusBall.from(12));
		MatchResult matchResult = lottos.matchResult(winningNumber);

		assertAll(
			() -> assertThat(matchResult.getThreeMatchCount()).isEqualTo(Count.from(1)),
			() -> assertThat(matchResult.getFourMatchCount()).isEqualTo(Count.from(1)),
			() -> assertThat(matchResult.getFiveMatchCount()).isEqualTo(Count.from(0)),
			() -> assertThat(matchResult.getSixMatchCount()).isEqualTo(Count.from(0))
		);
	}

	@Test
	@DisplayName("세 장 구매, 두 장 3개 일치, 한 장 4개 일치하는 경우")
	void 당첨_통계_데이터2() {
		Lottos lottos = new Lottos(Lists.newArrayList(
			new Lotto(Lists.newArrayList(1, 2, 3, 4, 5, 6)),
			new Lotto(Lists.newArrayList(4, 5, 6, 7, 8, 9)),
			new Lotto(Lists.newArrayList(4, 5, 6, 7, 8, 9)))
		);

		LastWeekWinningNumber winningNumber = LastWeekWinningNumber.of("3, 4, 5, 6, 10, 11");
		winningNumber.updateBonusBall(BonusBall.from(12));
		MatchResult matchResult = lottos.matchResult(winningNumber);

		assertAll(
			() -> assertThat(matchResult.getThreeMatchCount()).isEqualTo(Count.from(2)),
			() -> assertThat(matchResult.getFourMatchCount()).isEqualTo(Count.from(1)),
			() -> assertThat(matchResult.getFiveMatchCount()).isEqualTo(Count.from(0)),
			() -> assertThat(matchResult.getSixMatchCount()).isEqualTo(Count.from(0))
		);
	}
}