package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningListTest {

	@Test
	@DisplayName("당첨내역 생성 테스트")
	void create_winningList() {
		assertEquals(new WinningList().getWinningList().size(), 6);
	}

	@Test
	@DisplayName("당첨내역 생성 테스트")
	void create_winningList_data() {
		List<LottoNumbers> lottos = new ArrayList<>();
		lottos.add(new LottoNumbers("1,2,3,4,5,6"));
		Lottos tempLottos = new Lottos(lottos);

		assertEquals(
				new WinningList(tempLottos, new LottoNumbers("1,2,3,4,5,6")).getWinningList().get(WinningMoney.SIX), 1);
	}
}
