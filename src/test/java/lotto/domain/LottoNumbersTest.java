package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.exception.InvalidLottoNumberException;

@DisplayName("로또 번호 컬렉션 테스트")
class LottoNumbersTest {

	@Test
	@DisplayName("로또 번호 컬렉션 생성")
	void createLottoNumbersTest() {
		Set<Integer> lottoNumberSet = Set.of(1, 2, 3, 4, 5, 6);
		LottoNumbers lottoNumbers = LottoNumbers.of(lottoNumberSet);
		assertThat(lottoNumbers).isInstanceOf(LottoNumbers.class);
	}

	@Test
	@DisplayName("로또 번호가 6개가 아닐 시에 InvalidLottoNumberException 발생")
	void throwInvalidLottoNumbersCountTest() {
		Set<Integer> lottoNumberSet = Set.of(1, 2, 3, 4, 5);
		assertThatThrownBy(() -> LottoNumbers.of(lottoNumberSet))
			.isInstanceOf(InvalidLottoNumberException.class);
	}

	@Test
	@DisplayName("같은 로또 번호 컬렉션인지 확인")
	void equalsTest() {
		Set<Integer> lottoNumberSet = Set.of(1, 2, 3, 4, 5, 6);
		LottoNumbers lottoNumbers = LottoNumbers.of(lottoNumberSet);
		assertThat(lottoNumbers).isEqualTo(LottoNumbers.of(lottoNumberSet));
	}

}