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
		Set<LottoNumber> lottoNumberSet = Set.of(
			LottoNumber.of(1),
			LottoNumber.of(2),
			LottoNumber.of(3),
			LottoNumber.of(4),
			LottoNumber.of(5),
			LottoNumber.of(6)
		);
		LottoNumbers lottoNumbers = LottoNumbers.of(lottoNumberSet);
		assertThat(lottoNumbers).isInstanceOf(LottoNumbers.class);
	}

	@Test
	@DisplayName("로또 번호가 6개가 아닐 시에 InvalidLottoNumberException 발생")
	void throwInvalidLottoNumbersCountTest() {
		Set<LottoNumber> lottoNumberSet = Set.of(
			LottoNumber.of(1),
			LottoNumber.of(2),
			LottoNumber.of(3),
			LottoNumber.of(4),
			LottoNumber.of(5)
		);
		assertThatThrownBy(() -> LottoNumbers.of(lottoNumberSet))
			.isInstanceOf(InvalidLottoNumberException.class);
	}

	@Test
	@DisplayName("같은 로또 번호 컬렉션인지 확인")
	void equalsTest() {
		Set<LottoNumber> lottoNumberSet = Set.of(
			LottoNumber.of(1),
			LottoNumber.of(2),
			LottoNumber.of(3),
			LottoNumber.of(4),
			LottoNumber.of(5),
			LottoNumber.of(6)
		);
		LottoNumbers lottoNumbers = LottoNumbers.of(lottoNumberSet);
		assertThat(lottoNumbers).isEqualTo(LottoNumbers.of(lottoNumberSet));
	}

}