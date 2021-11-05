package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.code.RankCode;

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

	@ParameterizedTest(name = "index {index} ==> winningNumber {0} , lottoNumber {1}, resultCount {2}")
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

	@ParameterizedTest(name = "index {index} ==> winningNumber {0} , lottoNumber {1}, resultCount {2}")
	@CsvSource(value = {
		"1,2,3,4,5,6 : 1,2,3,4,5,6 : 6",
		"1,2,3,4,5,6 : 1,2,3,4,7,8 : 4",
		"1,2,3,4,5,6 : 7,8,9,10,11,12 : 0"
	}, delimiter = ':')
	void 일치결과를_통해_로또등수를_구하는_기능테스트(String winningLottoNumber, String LottoNumber, int resultCount) {
		// given
		WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningLottoNumber);
		LottoNumbers lottoNumbers = new LottoNumbers(LottoNumber);
		LottoResult lottoResult = new LottoResult();

		// when
		RankCode rankCode = lottoResult.getRankCodeUsingContainsCount(winningLottoNumbers, lottoNumbers);

		// then
		assertThat(rankCode).isEqualTo(RankCode.getRankCode(resultCount));
	}

	@ParameterizedTest(name = "index {index} ==> winningNumber {0} , lottoNumber {1}, mapSize {2}")
	@CsvSource(value = {
		"1,2,3,4,5,6 : 13000 : 13",
		"1,2,3,4,5,6 : 12000 : 12",
		"1,2,3,4,5,6 : 20000 : 20"
	}, delimiter = ':')
	void 일치결과를_통해_로또등수Map을_반환해주는_기능테스트(String winningLottoNumber, String inputMoney, int mapSize) {
		// given
		WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningLottoNumber);
		LottoGenerator lottoGenerator = new LottoGenerator(inputMoney);
		LottoResult lottoResult = new LottoResult();

		// when
		Map<RankCode, Integer> rankMap = lottoResult.getRankCodeMapUsingContainsMap(winningLottoNumbers,
			lottoGenerator);

		// then
		assertThat(rankMap
			.values()
			.stream()
			.mapToInt(Integer::intValue)
			.sum()).isEqualTo(mapSize);
	}

	@ParameterizedTest(name = "index {index} ==> winningNumber {0} , lottoNumber {1}, mapSize {2}")
	@CsvSource(value = {
		"1,2,3,4,5,6 : 1,2,3,4,5,6 : 2000000",
		"1,2,3,4,5,6 : 1,2,3,4,5,7 : 1500",
		"1,2,3,4,5,6 : 1,2,3,4,7,8 : 50",
		"1,2,3,4,5,6 : 1,2,3,7,8,9 : 5",
		"1,2,3,4,5,6 : 7,8,9,10,11,12 : 0"
	}, delimiter = ':')
	void 로또등수Map을_통해_총_수익률을_반환해주는_기능테스트(String winningLottoNumber, String lottoNumber, double yieldResult) {
		// given
		WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningLottoNumber);
		LottoGenerator lottoGenerator = new LottoGenerator("1000", lottoNumber);
		LottoResult lottoResult = new LottoResult();

		// when
		double yield = lottoResult.calcularateYield(winningLottoNumbers, lottoGenerator);

		// then
		assertThat(yield).isEqualTo(yieldResult);
	}
}