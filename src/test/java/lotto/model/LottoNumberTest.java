package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class LottoNumberTest {
	@Test
	void create() {
		LottoNumber no1 = new LottoNumber(23);
		assertThat(no1).isEqualTo(new LottoNumber(23));
	}
}
