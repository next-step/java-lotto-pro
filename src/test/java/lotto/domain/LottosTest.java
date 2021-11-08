package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottosTest {

	@DisplayName("로또 자동으로 구매하는지 확인")
	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3 })
	public void 로또_자동_구매_확인(int autoQuantity) {
		assertThat(new Lottos(new IssueQuantity().fromAuto(autoQuantity), null).getLottos().size()).isEqualTo(autoQuantity);
	}

	@Test
	@DisplayName("로또 수동으로 구매하는지 확인")
	public void 로또_수동_구매_확인() {
		List<List<Integer>> manual = Arrays.asList(Arrays.asList( 1, 2, 3, 4, 5, 6 ));
		assertThat(new Lottos(new IssueQuantity().fromManual(manual.size()), manual).getLottos().size()).isEqualTo(manual.size());
	}

}
