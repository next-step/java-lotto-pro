package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
	@Test
	@DisplayName("로또 번호는 6개를 입력해야 한다.")
	void three_numbers_match() {
		assertThatThrownBy(()-> new Lotto(Arrays.asList(
				new Number(1), new Number(2),
				new Number(3), new Number(4)
			)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("문자 로또 번호로 Lotto 생성")
	void create_lotto_to_string() {
		Lotto lotto1 = new Lotto(Arrays.asList(
							new Number(1), new Number(2), new Number(3),
							new Number(4), new Number(5), new Number(6)
						));
		Lotto lotto2 = Lotto.getInstanceByString(Arrays.asList("1", "2", "3", "4", "5", "6"));

		assertThat(lotto1.equals(lotto2)).isTrue();
	}

	@Test
	@DisplayName("로또 번호 일치 결과")
	void match_lotto() {
		Lotto lotto1 = new Lotto(Arrays.asList(
			new Number(1), new Number(2), new Number(3),
			new Number(4), new Number(5), new Number(6)
		));

		Lotto lotto2 = new Lotto(Arrays.asList(
			new Number(1), new Number(2), new Number(3),
			new Number(4), new Number(5), new Number(33)
		));

		assertThat(lotto1.match(lotto2, new Number(6))).isEqualTo(Rank.SECOND);
		assertThat(lotto1.match(lotto2, new Number(45))).isEqualTo(Rank.THIRD);
	}
}
