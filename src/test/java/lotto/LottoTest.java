package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class LottoTest {
	@Test
	void autoGenerate() {
		Lotto lotto = LottoGenerator.generate();
		assertThat(lotto).isNotNull();
	}

	@Test
	void generate() {
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
	}

	@Test
	void compare() {
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto winLotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
		assertThat(lotto.compareNumbers(winLotto)).isEqualTo(new Numbers(Arrays.asList(4, 5, 6)));
	}

	@Test
	void purchaseLottos() {
		int money = 14000;
		Lottos lottos = new Lottos(money);
		assertThat(lottos.size()).isEqualTo(14);
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Lottos(500);
		});
	}

	@Test
	void winPrize() {
		int money = 2000;
		Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto lotto2 = new Lotto(Arrays.asList(4, 5, 6, 7, 15, 18));
		Lotto winLotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));

		Lottos lottos = new Lottos(money, lotto1, lotto2);
		LottoGame game = new LottoGame(winLotto);
		Prize prize = game.winPrize(lottos);

		assertThat(prize).isEqualTo(
			new Prize(winLotto.compareNumbers(lotto1), winLotto.compareNumbers(lotto2)));
		assertThat(prize.winMoney()).isEqualTo(55000);
		assertThat(prize.totalCount()).isEqualTo(2);
		assertThat(prize.rateReturn()).isEqualTo(55000.0 / 2000);
	}
}
