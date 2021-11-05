package step3;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class LottoNumbersTest {

	@Test
	@DisplayName("여섯개의 랜덤한 숫자에 따른 로또번호가 생성되는지 확인")
	void createLotto() {
		LottoNumbers lottoNumbers = new LottoNumbers();
		try (MockedStatic<RandomUtils> randomMock = mockStatic(RandomUtils.class)) {
			randomMock
				.when(() -> RandomUtils.pick())
				.thenReturn(1, 4, 5, 6, 7, 9);
			LottoNumbers createLotto = lottoNumbers.createLottoNumbers();
			assertThat(createLotto).isEqualTo(createNumbers());
		}
	}

	@Test
	@DisplayName("로또 번호가 6개 이상 뽑히면 Exception 발생")
	void createOverFlowThrow() {
		assertThatThrownBy(() -> {
			LottoNumbers lottoNumbers = new LottoNumbers(Sets.newHashSet(createOverMax()));
			lottoNumbers.createLottoNumbers();
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

	private LottoNumbers createNumbers() {
		return new LottoNumbers(Sets.newHashSet(Arrays.asList(new LottoNumber(1),
			new LottoNumber(4),
			new LottoNumber(5),
			new LottoNumber(6),
			new LottoNumber(7),
			new LottoNumber(9))));
	}
}