import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {
	@Test
	@DisplayName("14000원으로 구입할 수 있는 로또 개수는 14")
	void 구입_금액에_해당하는_로또_개수1() {
		int result = Lottos.buyCountFor(14000);

		assertThat(result).isEqualTo(14);
	}

	@Test
	@DisplayName("500원으로 구입할 수 있는 로또 개수는 0")
	void 구입_금액에_해당하는_로또_개수2() {
		int lottoCount = Lottos.buyCountFor(500);

		assertThat(lottoCount).isEqualTo(0);
	}

	@Test
	@DisplayName("7500원으로 구입할 수 있는 로또 개수는 7")
	void 구입_금액에_해당하는_로또_개수3() {
		int lottoCount = Lottos.buyCountFor(7500);

		assertThat(lottoCount).isEqualTo(7);
	}
}