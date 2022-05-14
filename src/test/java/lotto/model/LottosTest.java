package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

	@Test
	@DisplayName("생성 테스트")
	void create_lottos() {
		List<LottoNumbers> lottoNumbers = new ArrayList<>();
		lottoNumbers.add(new LottoNumbers("1,2,3,4,5,6"));
		lottoNumbers.add(new LottoNumbers("1,2,3,4,5,6"));
		assertEquals(new Lottos(lottoNumbers).getLottos().size(), 2);
	}
}
