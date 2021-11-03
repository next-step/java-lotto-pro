import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class LottoTest {
	private static final int ENOUGH_TEST_COUNT = 1000;

	@Test
	void 생성한_숫자는_6개() {
		Lotto lotto = Lotto.create();

		assertThat(lotto.getNumbers().size()).isEqualTo(6);
	}

	@RepeatedTest(value = ENOUGH_TEST_COUNT)
	void 중복되는_숫자는_없어야_한다() {
		Lotto lotto = Lotto.create();
		Set<Integer> numberSet = Sets.newHashSet(lotto.getNumbers());

		assertThat(numberSet.size()).isEqualTo(6);
	}
}
