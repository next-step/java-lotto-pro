package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class LottoTest {
	@Test
	public void init() {
		Lotto lotto = new Lotto(
			Arrays.asList(1, 2, 3, 4, 5, 6)
				.stream()
				.map(LottoNumber::new)
				.collect(Collectors.toList())
		);

		assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)
			.stream()
			.map(LottoNumber::new)
			.collect(Collectors.toList()))
		);
	}

	@Test
	public void 로또_번호_중복() {
		assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 1, 2, 3, 5, 6)
			.stream()
			.map(LottoNumber::new)
			.collect(Collectors.toList()))
		).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 로또_번호_부족() {
		assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 3, 5, 6)
			.stream()
			.map(LottoNumber::new)
			.collect(Collectors.toList()))
		).isInstanceOf(IllegalArgumentException.class);
	}
}
