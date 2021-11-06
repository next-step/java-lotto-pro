package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GeneratedLottoTest {

	@Test
	@DisplayName("자동생성 로또")
	public void GeneratedLottoSuccess() throws Exception {
	    assertThat(new GeneratedLotto().getGeneratedLotto()).isInstanceOf(Lotto.class);
	}

}