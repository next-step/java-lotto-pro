import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoTest {

	@Test
	public void of() {
		assertThat(Lotto.of().getNumOfLottoNumbers())
			.isEqualTo(Lotto.NUM_OF_LOTTO_NUMBERS);
	}
}
