package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

	@Test
	@DisplayName("로또번호가 중복되어서 출력되지 않는지 확인 ")
	void createLotto() {
		LottoNumbers lottoNumbers = new LottoNumbers(Sets.newHashSet(createNumbers()));

		Set<LottoNumber> resultLotto = lottoNumbers.createLottoNumbers();
		assertThat(resultLotto).containsOnly(
			new LottoNumber(1),
			new LottoNumber(3),
			new LottoNumber(5),
			new LottoNumber(6),
			new LottoNumber(4),
			new LottoNumber(2));
		assertThat(resultLotto.size()).isEqualTo(6);
	}

	@Test
	@DisplayName("로또 번호가 6개 이상 뽑히면 Exception 발생")
	void createOverFlowThrow() {
		assertThatThrownBy(() ->{
			LottoNumbers lottoNumbers = new LottoNumbers(Sets.newHashSet(createOverMax()));
			Set<LottoNumber> resultLotto = lottoNumbers.createLottoNumbers();
		}).isInstanceOf(ArrayIndexOutOfBoundsException.class);
	}

	private List<LottoNumber> createOverMax() {
		return Arrays.asList(
			new LottoNumber(1),
			new LottoNumber(3),
			new LottoNumber(5),
			new LottoNumber(6),
			new LottoNumber(9),
			new LottoNumber(4),
			new LottoNumber(2));
	}

	private List<LottoNumber> createNumbers() {
		return Arrays.asList(
			new LottoNumber(1),
			new LottoNumber(3),
			new LottoNumber(5),
			new LottoNumber(6),
			new LottoNumber(6),
			new LottoNumber(4),
			new LottoNumber(2));
	}
}