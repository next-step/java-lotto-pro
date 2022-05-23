package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningListTest {
	private Lottos lottos;

	@BeforeEach
	void setUp() {
		List<LottoNumbers> tempLottos = new ArrayList<>();
		tempLottos.add(new LottoNumbers("1,2,3,4,5,6"));
		lottos = new Lottos(tempLottos);
	}

	@Test
	@DisplayName("당첨내역 생성 테스트")
	void create_winningList() {
		assertEquals(new WinningList().getWinningList().size(), 6);
	}

	@Test
	@DisplayName("당첨내역 생성 테스트")
	void create_winningList_data() {
		WinningLotto winningLotto = new WinningLotto(new LottoNumbers("1,2,3,4,5,6"), "8");
		assertEquals(new WinningList(lottos, winningLotto).getWinningList().get(WinningMoney.FIRST), 1);
	}

	@Test
	@DisplayName("2등 당첨내역 생성 테스트")
	void create_winningList_second_data() {
		WinningLotto winningLotto = new WinningLotto(new LottoNumbers("1,2,3,4,5,8"), "6");
		assertEquals(new WinningList(lottos, winningLotto).getWinningList().get(WinningMoney.SECOND), 1);
	}
}
