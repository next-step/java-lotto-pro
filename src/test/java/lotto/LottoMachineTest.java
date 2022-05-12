package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;

public class LottoMachineTest {
	private LottoMachine lottoMachine;

	@BeforeEach
	void setUp() {
		lottoMachine = new LottoMachine("1000");
	}

	@Test
	@DisplayName("로또 구입 테스트")
	void buy_lotto() {
		assertThat(lottoMachine.buyAutoLottos()).hasSize(1);
	}

	@Test
	@DisplayName("당첨금액과 수익률을 구하는 기능 테스트")
	void create_lottoNumber_int() {
		LottoNumbers lottoNumbers = lottoMachine.buyAutoLottos().get(0);

		List<LottoNumber> lottoNumbers2 = new ArrayList<>();
		for (int i = 0; i < lottoNumbers.getLottoNumbers().size(); ++i) {
			lottoNumbers2.add(lottoNumbers.getLottoNumbers().get(i));
		}
		int[] winList = lottoMachine.winList(new LottoNumbers(lottoNumbers2));

		assertAll(() -> assertEquals(winList[6], 1), 
				() -> assertEquals(lottoMachine.profitRate(), 2000000.00));
	}
}
