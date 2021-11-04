package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoAppTest {

	private static LottoApp lottoApp;

	@BeforeAll
	public static void setup() {
		lottoApp = new LottoApp();
	}

	@ParameterizedTest
	@CsvSource(delimiter = ',', value = {"12000,12", "12500,12", "0,0", "500,0"})
	@DisplayName("구매 금액에 맞는 구매 갯수를 계산해야 한다.(가격: 1000원)")
	public void lottoCountTest(int money, int expectedCount) {
		// when
		int count = lottoApp.getLottoCountByMoney(money);

		// then
		assertThat(count).isEqualTo(expectedCount);
	}

	@ParameterizedTest
	@ValueSource(ints = {3, 5, 10, 20})
	@DisplayName("요청 갯수에 따라 로또번호(오름차순, 1~45, 6개 번호)들을 생성해야 한다")
	public void generateLottoNumbersTest(int count) {
		// when
		List<LottoNumber> lottoNumbersList = lottoApp.getLottoNumbersByCount(count);

		// then
		assertThat(lottoNumbersList.size()).isEqualTo(count);
	}

	@Test
	@DisplayName("일치갯수들이 주어지면, 총 포인트를 계산해야 한다")
	public void calculatePointTest() {
		// given
		LottoNumber answers = LottoNumber.of(Arrays.asList(1, 2, 3, 4, 5, 6));
		List<LottoNumber> numbers = new ArrayList<>();
		numbers.add(LottoNumber.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
		numbers.add(LottoNumber.of(Arrays.asList(1, 2, 3, 4, 5, 9)));
		numbers.add(LottoNumber.of(Arrays.asList(1, 2, 3, 4, 8, 9)));
		numbers.add(LottoNumber.of(Arrays.asList(1, 2, 3, 7, 8, 9)));

		// when
		LottoPrize vo = lottoApp.calculatePoint(answers, numbers);

		// then
		assertThat(vo.getCnt4St()).isEqualTo(1);
		assertThat(vo.getCnt1St()).isEqualTo(1);
		assertThat(vo.getCnt2St()).isEqualTo(1);
		assertThat(vo.getCnt3St()).isEqualTo(1);
	}

	@Test
	@DisplayName("당첨 내역과 구매 금액이 주어지면, 수익률을 계산해야 한다")
	public void calculateProfit() {
		// given
		LottoPrize lottoPrize = new LottoPrize(0, 0, 0, 1);
		int money = 14000;
		double expected = 0.35;

		// when
		double result = lottoApp.getProfit(money, lottoPrize);

		// then
		assertThat(result).isEqualTo(expected);
	}

}
