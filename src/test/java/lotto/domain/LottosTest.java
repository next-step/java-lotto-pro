package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class LottosTest {

	private Lottos lottos;
	private List<Lotto> exampleLottos;

	@BeforeEach
	void setUp() {
		exampleLottos = Arrays.asList(
			LottoGenerator.generate(),
			LottoGenerator.generate()
		);

		lottos = Lottos.from(exampleLottos);
	}

	@ParameterizedTest
	@NullAndEmptySource
	@DisplayName("null 이나 빈 리스트를 전달하면 예외가 발생한다.")
	void testInvalid(List<Lotto> input) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Lottos.from(input))
			.withMessage(Lottos.LOTTOS_NULL_OR_EMPTY_ERROR);
	}

	@Test
	@DisplayName("로또 목록의 size를 얻어올 수 있다.")
	void testSize() {
		assertThat(lottos.size()).isEqualTo(2);
	}

	@Test
	@DisplayName("동일한 로또 목록을 반환한다.")
	void test() {
		assertThat(lottos.lottos()).isEqualTo(exampleLottos);
	}
}
