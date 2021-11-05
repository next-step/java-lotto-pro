package lottoLegacy;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

	@Test
	@DisplayName("로또 5개 자동생성 한다.")
	public void 로또_자동생성_5개() {
		int count = 5;
		Lottos lottos = new Lottos(count);
		assertThat(lottos.getLottoList().size()).isEqualTo(count);
		lottos.getLottoList().stream().forEach(lotto -> System.out.println(lotto.getNumbers()));
	}

}