package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoResultTest {

	@ParameterizedTest(name = "index {index} ==> winningNumber {0} , lottoNumber {1}, resultCount {2}")
	@CsvSource(value = {
		"1,2,3,4,5,6 : 1,2,3,4,5,6 : 6",
		"1,2,3,4,5,6 : 1,2,3,4,7,8 : 4",
		"1,2,3,4,5,6 : 7,8,9,10,11,12 : 0"
	}, delimiter = ':')
	void 당첨번호와_로또번호를_비교해주는_기능테스트(String winningNumber, String lottoNumber, int resultCount) {
		//given
		WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningNumber);
		LottoNumbers lottoNumbers = new LottoNumbers(lottoNumber);

		//when
		LottoResult lottoResult = new LottoResult();
		int contains = lottoResult.containsWinningLottoNumbers(winningLottoNumbers, lottoNumbers);

		//then
		assertThat(contains).isEqualTo(resultCount);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"1,2,3,4,5,6 : 1,2,3,4,5,6 : 6",
		"1,2,3,4,5,6 : 1,2,3,4,7,8 : 4",
		"1,2,3,4,5,6 : 7,8,9,10,11,12 : 0"
	}, delimiter = ':')
	void 당첨번호와_로또생성기로_생성된_로또를_비교해주는_기능테스트(String winningNumber, String inputNumber, Integer resultCount) {
		//given
		WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningNumber);
		LottoGenerator lottoGenerator = new LottoGenerator("1000", inputNumber);

		//when
		LottoResult lottoResult = new LottoResult();
		Map<Integer, Integer> containsMap =
			lottoResult.containsWinningLottoGenerator(winningLottoNumbers, lottoGenerator);

		//then
		assertThat(containsMap.get(resultCount)).isEqualTo(1);
	}
}