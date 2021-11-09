package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.Lottos;
import lotto.util.LottoGenerator;

public class LottosTest {
	@Test
	@DisplayName("Lotto 여러개 구매 테스트")
	void purchaseLottos() {
		int money = 14000;
		Lottos lottos = LottoGenerator.purchaseLottos(money);
		assertThat(lottos.size()).isEqualTo(14);
		assertThatIllegalArgumentException().isThrownBy(() -> {
			LottoGenerator.purchaseLottos(500);
		});
	}
}
