package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoResultTest {

	private static Money money = Money.from(1000);

	private Method privateMethod(String methodName) throws Exception {
		Method method = LottoResult.class.getDeclaredMethod(methodName);
		method.setAccessible(true);
		return method;
	}

	@ParameterizedTest(name = "index {index} ==> winningNumber {0} , lottoNumber {1}, resultCount {2}")
	@CsvSource(value = {
		"1,2,3,4,5,6 : 9 : 1,2,3,4,5,6 : 6",
		"1,2,3,4,5,6 : 9 : 1,2,3,4,7,8 : 4",
		"1,2,3,4,5,6 : 15 : 7,8,9,10,11,12 : 0"
	}, delimiter = ':')
	void 당첨번호와_로또번호를_비교해주는_기능테스트(String winningNumber, String bonusNumber, String lottoNumber, int resultCount) throws
		Exception {
		//given
		WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.of(winningNumber, bonusNumber);
		LottoNumbers lottoNumbers = LottoNumbers.from(lottoNumber);
		Lottos lottos = Lottos.of(Collections.singletonList(lottoNumbers), money);
		LottoResult lottoResult = LottoResult.of(winningLottoNumbers, lottos);

		//when
		Method method = LottoResult.class.getDeclaredMethod("containsWinningLottoNumbers", WinningLottoNumbers.class,
			LottoNumbers.class);
		method.setAccessible(true);
		int contains = (int)method.invoke(lottoResult, winningLottoNumbers, lottoNumbers);

		//then
		assertThat(contains).isEqualTo(resultCount);
	}

	@ParameterizedTest(name = "index {index} ==> winningNumber {0} , lottoNumber {1}, resultCount {2}")
	@CsvSource(value = {
		"1,2,3,4,5,6 : 7 : 1,2,3,4,5,6 : FIRST",
		"1,2,3,4,5,6 : 7 : 1,2,3,4,5,7 : SECOND",
		"1,2,3,4,5,6 : 7 : 1,2,3,4,5,8 : THIRD",
		"1,2,3,4,5,6 : 7 : 7,8,9,10,11,12 : NOTHING"
	}, delimiter = ':')
	void 당첨번호와_로또생성기로_생성된_로또를_비교해주는_기능테스트(String winningNumber, String bonusNumber, String inputNumber,
		String result) throws
		Exception {
		//given
		WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.of(winningNumber, bonusNumber);
		Lottos lottos = Lottos.of(Collections.singletonList(LottoNumbers.from(inputNumber)), money);
		LottoResult lottoResult = LottoResult.of(winningLottoNumbers, lottos);

		//when
		Method method = privateMethod("containsWinningLottoGenerator");
		Map<LottoRank, Integer> lottoRankMap = (Map<LottoRank, Integer>)method.invoke(lottoResult);

		//then
		assertThat(lottoRankMap.get(LottoRank.valueOf(result))).isEqualTo(1);
	}

	@ParameterizedTest(name = "index {index} ==> winningNumber {0} , lottoNumber {1}, mapSize {2}")
	@CsvSource(value = {
		"1,2,3,4,5,6 : 8 : 1,2,3,4,5,6 : 2000000",
		"1,2,3,4,5,6 : 8 : 1,2,3,4,5,8 : 30000",
		"1,2,3,4,5,6 : 8 : 1,2,3,4,5,7 : 1500",
		"1,2,3,4,5,6 : 8 : 1,2,3,4,7,8 : 50",
		"1,2,3,4,5,6 : 8 : 1,2,3,7,8,9 : 5",
		"1,2,3,4,5,6 : 8 : 7,8,9,10,11,12 : 0"
	}, delimiter = ':')
	void 로또등수Map을_통해_총_수익률을_반환해주는_기능테스트(String winningLottoNumber, String bonusNumber, String lottoNumber,
		double yieldResult) {
		// given
		WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.of(winningLottoNumber, bonusNumber);
		Lottos lottos = Lottos.of(Collections.singletonList(LottoNumbers.from(lottoNumber)), money);
		LottoResult lottoResult = LottoResult.of(winningLottoNumbers, lottos);

		// when
		double yield = lottoResult.getYield();

		// then
		assertThat(yield).isEqualTo(yieldResult);
	}
}