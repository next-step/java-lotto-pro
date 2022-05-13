package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningListTest {

	@Test
	@DisplayName("당첨내역 생성 테스트")
	void create_winningList() {
		assertEquals(new WinningList().getWinningList().size(), 5);
	}

	@Test
	@DisplayName("당첨내역 증가 테스트")
	void increase_winningMoney() {
		WinningList winningList = new WinningList();
		winningList.increase(WinningMoney.SIX);
		winningList.increase(WinningMoney.SIX);
		winningList.increase(WinningMoney.SIX);
		assertEquals(winningList.getWinningList().get(WinningMoney.SIX), 3);
	}
	
	@Test
	@DisplayName("당첨금액 테스트")
	void total_winningMoney() {
		WinningList winningList = new WinningList();
		winningList.increase(WinningMoney.SIX);
		winningList.increase(WinningMoney.FIVE);
		assertEquals(winningList.totalWinningMoney(), 1500000 + 2000000000);
	}
}
