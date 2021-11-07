import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {
	@Test
	@DisplayName("equals의 구현이 정상적으로 되었는지 확인")
	void test1() {
		assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
	}

	@Test
	@DisplayName("hashcode의 구현이 정상적으로 되었는지 확인")
	void test2() {
		Set<LottoNumber> set = new HashSet<>();
		set.add(new LottoNumber(1));
		set.add(new LottoNumber(2));
		set.add(new LottoNumber(1));

		assertThat(set.size()).isEqualTo(2);
	}
}
