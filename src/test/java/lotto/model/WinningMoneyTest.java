package lotto.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningMoneyTest {

	@Test
	@DisplayName("맞은 숫자에 대한 당첨금 enum 테스트")
	void create_winning_money() {
		assertAll(() -> assertEquals(WinningMoney.FIRST.getWinningMoney(), 2000000000),
				() -> assertEquals(WinningMoney.FIRST.getMatchCount(), 6),
				() -> assertEquals(WinningMoney.THIRD.getWinningMoney(), 1500000),
				() -> assertEquals(WinningMoney.THIRD.getMatchCount(), 5),
				() -> assertEquals(WinningMoney.FOURTH.getWinningMoney(), 50000),
				() -> assertEquals(WinningMoney.FOURTH.getMatchCount(), 4),
				() -> assertEquals(WinningMoney.FIFTH.getWinningMoney(), 5000),
				() -> assertEquals(WinningMoney.FIFTH.getMatchCount(), 3));
	}

	@Test
	@DisplayName("로또번호가 맞은 갯수에 대한 enum 반환 테스트")
	void find_winning_money() {
		assertAll(() -> assertEquals(WinningMoney.find(6), WinningMoney.FIRST),
				() -> assertEquals(WinningMoney.find(5), WinningMoney.THIRD),
				() -> assertEquals(WinningMoney.find(4), WinningMoney.FOURTH),
				() -> assertEquals(WinningMoney.find(3), WinningMoney.FIFTH));
	}

	@Test
	@DisplayName("2등 추가 테스트")
	void win_second_test() {
		assertAll(() -> assertEquals(WinningMoney.SECOND.getWinningMoney(), 30000000),
				() -> assertEquals(WinningMoney.SECOND.getMatchCount(), 5),
				() -> assertTrue(WinningMoney.SECOND.isSecondPlace()));
	}
}
