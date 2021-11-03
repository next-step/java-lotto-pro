package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTest {

	@Test
	@DisplayName("로또 생성 테스트(6자리 숫자)")
	void makeLotto() {
		Lotto lotto = new Lotto();
		LottoNumbers numbers = lotto.getNumbers();
		String result = numbers.toString();

		assertThat(result).startsWith("[").endsWith("]");

		assertThat(result.split(",").length).isEqualTo(6);

		assertThatCode(()->{
			Long.parseUnsignedLong(result.replaceAll("[\\[\\], ]",""));
		}).doesNotThrowAnyException();
	}

}
