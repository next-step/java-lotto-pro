package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

	@Test
	@DisplayName("주어진 로또번호로 정렬된 로또번호를 생성해야 한다")
	public void createTest() {
		// given
		List<Integer> numberList = Arrays.asList(3, 2, 1, 4, 5, 6);

		// when
		LottoNumber lottoNumber = LottoNumber.of(numberList);

		// then
		List<Integer> integers = lottoNumber.getNumbers();
		assertThat(integers).containsExactly(1, 2, 3, 4, 5, 6);
	}

	@Test
	@DisplayName("주어진 번호(+보너스번호)로 당첨번호를 생성해야 한다")
	public void createWithBonusTest() {
		// given
		List<Integer> numberList = Arrays.asList(3, 2, 1, 4, 5, 6);
		int bonusNumber = 9;

		// when
		LottoNumber winningNumber = LottoNumber.ofWinning(numberList, bonusNumber);

		// then
		List<Integer> integers = winningNumber.getNumbers();
		assertThat(integers).containsExactly(1, 2, 3, 4, 5, 6);
		assertThat(winningNumber.isMatchBonusNumber(9)).isTrue();
	}

	@Test
	@DisplayName("로또 숫자는 6개의 1~45 범위의 숫자로 이루어져야 한다")
	public void validateTest() {
		// given
		List<Integer> duplicateNumbers = Arrays.asList(1, 1, 3, 4, 5, 6);
		List<Integer> notEnoughNumbers = Arrays.asList(1, 2, 3);
		List<Integer> outRangeNumbers = Arrays.asList(0, 1, 2, 3, 4, 90);

		// when, then
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> LottoNumber.of(duplicateNumbers))
			.withMessageContaining("중복이 있으면 안됩니다");
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> LottoNumber.of(notEnoughNumbers))
			.withMessageContaining("6개의 숫자로 되어야 합니다");
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> LottoNumber.of(outRangeNumbers))
			.withMessageContaining("1이상 45이하인 숫자여야 합니다");
	}

	@Test
	@DisplayName("보너스 번호는 1~45 범위의 숫자이며, 다른 번호들과 중복되면 안된다")
	public void bonusNumberValidTest() {
		// given
		List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6);
		int outRangeBonusNumber = 100;
		int duplicateBonusNumber = 1;

		// when, then
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> LottoNumber.ofWinning(numberList, duplicateBonusNumber))
			.withMessageContaining("보너스번호는 다른 번호들과 중복이 되면 안됩니다");
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> LottoNumber.ofWinning(numberList, outRangeBonusNumber))
			.withMessageContaining("1이상 45이하인 숫자여야 합니다");

	}

	@Test
	@DisplayName("서로 일치하는 숫자 갯수를 반환해야 한다")
	public void getMatchCountTest() {
		// given
		LottoNumber lottoNumber = LottoNumber.of(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoNumber lottoNumber2 = LottoNumber.of(Arrays.asList(1, 2, 3, 9, 10, 11));

		// when
		int result = lottoNumber.getMatchCount(lottoNumber2);

		// then
		assertThat(result).isEqualTo(3);
	}

	@Test
	@DisplayName("보너스 번호가 포함되어있는지 확인할 수 있어야 한다")
	public void isEqualBonusNumberTest() {
		// given
		LottoNumber winningNumber = LottoNumber.ofWinning(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
		LottoNumber lottoNumber = LottoNumber.of(Arrays.asList(1, 2, 3, 9, 10, 7));
		LottoNumber diffLottoNumber = LottoNumber.of(Arrays.asList(1, 2, 3, 9, 10, 11));

		// when, then
		assertThat(LottoNumber.isContainBonusNumber(winningNumber, lottoNumber)).isTrue();
		assertThat(LottoNumber.isContainBonusNumber(winningNumber, diffLottoNumber)).isFalse();

	}

}
