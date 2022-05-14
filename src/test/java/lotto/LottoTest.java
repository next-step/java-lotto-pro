package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
	Answer answer123456 = new Answer("1, 2, 3, 4, 5, 6");

	@Test
	void 로또_생성() {
		assertThat(new Lotto(6, 5, 4, 3, 2, 1)).isNotNull();
	}

	@Test
	void 로또_자릿수부족() {
		assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 로또_자릿수초과() {
		assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5, 6, 7))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 로또_중복() {
		assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5, 5))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 당첨금_6개_일치() {
		Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
		Winnings winnings = lotto.winnings(answer123456);
		assertThat(winnings.getMoney()).isEqualTo(2000000000);
	}

	@Test
	void 당첨금_5개_일치() {
		Lotto lotto = new Lotto(1, 2, 3, 4, 5, 7);
		Winnings winnings = lotto.winnings(answer123456);
		assertThat(winnings.getMoney()).isEqualTo(1500000);
	}

	@Test
	void 당첨금_4개_일치() {
		Lotto lotto = new Lotto(1, 2, 3, 4, 7, 8);
		Winnings winnings = lotto.winnings(answer123456);
		assertThat(winnings.getMoney()).isEqualTo(50000);
	}

	@Test
	void 당첨금_3개_일치() {
		Lotto lotto = new Lotto(1, 2, 3, 7, 8, 9);
		Winnings winnings = lotto.winnings(answer123456);
		assertThat(winnings.getMoney()).isEqualTo(5000);
	}
}
