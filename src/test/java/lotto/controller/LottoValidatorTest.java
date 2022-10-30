package lotto.controller;

import static money.Money.wons;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.FixedLottoTicketGenerator;
import lotto.domain.AutoLottoTicketsVendor;

class LottoValidatorTest {

	List<Integer> 고정_로또_번호 = Lists.newArrayList(1, 2, 3, 4, 5, 6);

	AutoLottoTicketsVendor 로또_판매기 = new AutoLottoTicketsVendor(new FixedLottoTicketGenerator(고정_로또_번호));

	@ParameterizedTest
	@CsvSource({"1000,900", "1000,0", "2000,1999"})
	void 로또_가격_미만으로_로또를_입력할_경우_예외를_던진다(int 로또_가격, int 로또_구매_금액) {

		assertThatThrownBy(() -> LottoValidator.verifyMoneyIsEqualToOrGreaterThanPrice(wons(로또_가격), wons(로또_구매_금액)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@CsvSource({"1000,1000, 2", "1000, 0, 1"})
	void 지불한_금액이_수동으로_구매할_로또_가격보다_적을_경우_예외를_던진다(int 로또_가격, int 로또_구매_가격, int 수동_로또_구매_개수) {
		assertThatThrownBy(() -> LottoValidator.verifyManualLottoTotalPriceIsLessThanBillingMoney(
			wons(로또_구매_가격), wons(로또_가격), 수동_로또_구매_개수))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6})
	void 보너스볼_입력_시_지난주_당첨_번호와_중복일_경우_예외를_던진다(int 보너스볼) {
		assertThatThrownBy(() -> LottoValidator.verifyBonusNumberIsNotInWinningLottoNumbers(
			고정_로또_번호, 보너스볼))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
