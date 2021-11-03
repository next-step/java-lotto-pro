package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoDomainTest {

	private static LottoDomain domain;

	@BeforeAll
	public static void setup() {
		domain = new LottoDomain();
	}

	static List<Arguments> lottoNumbersAndMatchExpected() {
		return Lists.list(
			arguments(Arrays.asList(1, 2, 3, 4, 5, 6), 6),
			arguments(Arrays.asList(1, 2, 3, 4, 5, 7), 5),
			arguments(Arrays.asList(1, 2, 3, 4, 7, 8), 4),
			arguments(Arrays.asList(1, 2, 3, 7, 8, 9), 3),
			arguments(Arrays.asList(1, 2, 7, 8, 9, 10), 2),
			arguments(Arrays.asList(1, 7, 8, 9, 10, 11), 1),
			arguments(Arrays.asList(7, 8, 9, 10, 11, 12), 0)
		);
	}

	@ParameterizedTest
	@CsvSource(delimiter = ',', value = {"12000,12", "12500,12", "0,0", "500,0"})
	@DisplayName("구매 금액에 맞는 구매 갯수를 계산해야 한다.(가격: 1000원)")
	public void lottoCountTest(int money, int expectedCount) {
		// when
		int count = domain.getLottoCountByMoney(money);

		// then
		assertThat(count).isEqualTo(expectedCount);
	}

	@ParameterizedTest
	@ValueSource(ints = {3, 5, 10, 20})
	@DisplayName("요청 갯수에 따라 로또번호(오름차순, 1~45, 6개 번호)들을 생성해야 한다")
	public void generateLottoNumbersTest(int count) {
		// when
		List<List<Integer>> lottoNumbersList = domain.getLottoNumbersByCount(count);

		// then
		assertThat(lottoNumbersList.size()).isEqualTo(count);
		for (List<Integer> numbers : lottoNumbersList) {
			lottoNumberTest(numbers);
		}
	}

	@DisplayName("로또번호(오름차순, 1~45, 6개 번호)여야 한다")
	private void lottoNumberTest(List<Integer> numbers) {
		// then
		assertThat(numbers).isSorted();
		assertThat(numbers.size()).isEqualTo(6);
		for (int number : numbers) {
			assertThat(number)
				.isGreaterThanOrEqualTo(1)
				.isLessThanOrEqualTo(45);
		}
	}

	@ParameterizedTest
	@MethodSource("lottoNumbersAndMatchExpected")
	@DisplayName("당첨번호와 로또번호들이 주어지면, 당첨내역들을 계산해야 한다")
	public void getMatchCountTest(List<Integer> numbers, int expected) {
		// when
		List<Integer> answerNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		// then
		int matchCount = domain.getMatchCount(answerNumbers, numbers);

		// then
		assertThat(matchCount).isEqualTo(expected);
	}

	@Test
	@DisplayName("당첨 내역과 구매 금액이 주어지면, 수익률을 계산해야 한다")
	public void calculateProfit() {
		// given
		List<Integer> matchCounts = Arrays.asList(3, 0, 0, 0, 0);
		int money = 14000;
		double expected = 0.35;

		// when
		double result = domain.getProfit(money, matchCounts);

		// then
		assertThat(result).isEqualTo(expected);
	}

}
