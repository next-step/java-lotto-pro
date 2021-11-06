package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberGeneratorTest {

	@ParameterizedTest
	@ValueSource(ints = {3, 6, 8, 10})
	@DisplayName("로또 번호를 요청 갯수에 맞게 생성해야 한다")
	public void generateByCountTest(int count) {
		// when
		LottoNumbers lottoNumbers = LottoNumberGenerator.generateByCount(count);

		// then
		assertThat(lottoNumbers.getSize()).isEqualTo(count);
	}
}
