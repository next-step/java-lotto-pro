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
		assertAll(() -> assertEquals(WinningMoney.SIX.getWinningMoney(), 2000000000),
				() -> assertEquals(WinningMoney.SIX.getMatchCount(), 6),
				() -> assertEquals(WinningMoney.FIVE.getWinningMoney(), 1500000),
				() -> assertEquals(WinningMoney.FIVE.getMatchCount(), 5),
				() -> assertEquals(WinningMoney.FOUR.getWinningMoney(), 50000),
				() -> assertEquals(WinningMoney.FOUR.getMatchCount(), 4),
				() -> assertEquals(WinningMoney.THREE.getWinningMoney(), 5000),
				() -> assertEquals(WinningMoney.THREE.getMatchCount(), 3));
	}

	@Test
	@DisplayName("로또번호가 맞은 갯수에 대한 enum 반환 테스트")
	void find_winning_money() {
		assertAll(() -> assertEquals(WinningMoney.find(6), WinningMoney.SIX),
				() -> assertEquals(WinningMoney.find(5), WinningMoney.FIVE),
				() -> assertEquals(WinningMoney.find(4), WinningMoney.FOUR),
				() -> assertEquals(WinningMoney.find(3), WinningMoney.THREE));
	}

	@Test
	@DisplayName("2등 추가 테스트")
	void win_second_test() {
		assertAll(() -> assertEquals(WinningMoney.FIVE_BOUNS.getWinningMoney(), 30000000),
				() -> assertEquals(WinningMoney.FIVE_BOUNS.getMatchCount(), 5),
				() -> assertEquals(WinningMoney.FIVE_BOUNS, WinningMoney.FIVE_BOUNS),
				() -> assertTrue(WinningMoney.FIVE_BOUNS.isSecondPlace()));
	}
}
