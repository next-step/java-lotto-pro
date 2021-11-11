package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottosTest {
	@ParameterizedTest(name = "index {index} ==> inputMoney {0}, lottoNumbersListSize {1}")
	@CsvSource(value = {"10000:10", "1111:1", "20000:20", "13200:13"}, delimiter = ':')
	void 입력된_구입금액만큼_로또생성기로_로또를_생성하는_테스트(String inputMoney, int lottoNumbersListSize) {
		// given
		Money money = Money.from(inputMoney);
		List<LottoNumbers> lottoNumbersList = LottoGenerator.getInstance().generateLottoNumbers(money);
		System.out.println(lottoNumbersList.size());

		// when
		Lottos lottos = Lottos.of(lottoNumbersList);

		// then
		assertAll(
			() -> assertThat(lottos).isInstanceOf(Lottos.class),
			() -> assertThat(lottos.size()).isEqualTo(lottoNumbersListSize)
		);
	}

	@ParameterizedTest(name = "index {index} ==> inputMoney {0}, inputNumber {1}, lottoNumbersListSize {2}")
	@CsvSource(value = {
		"1000:1,2,3,4,5,6:1",
		"1111:1,2,3,4,5,6:1",
		"2000:1,2,3,4,5,6:2",
		"13200:1,2,3,4,5,6:13"}, delimiter = ':')
	void 입력된_구입금액과_입력된숫자로_로또를_생성하는_테스트(String inputMoney, String inputNumber, int lottoNumbersListSize) {
		// given
		Money money = Money.from(inputMoney);
		List<LottoNumbers> lottoGenerator = LottoGenerator.getInstance()
			.generateLottoNumbers(money, Collections.singletonList(inputNumber));

		// when
		Lottos lottos = Lottos.of(lottoGenerator);

		// then
		assertAll(
			() -> assertThat(lottos).isInstanceOf(Lottos.class),
			() -> assertThat(lottos.size()).isEqualTo(lottoNumbersListSize)
		);
	}

}