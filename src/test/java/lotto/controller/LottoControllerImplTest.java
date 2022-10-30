package lotto.controller;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import lotto.FixedLottoTicketGenerator;
import lotto.domain.AutoLottoTicketsVendor;
import money.Money;

class LottoControllerImplTest {

	List<Integer> 고정_로또_번호 = Lists.newArrayList(1, 2, 3, 4, 5, 6);
	int 로또_가격 = 5000;

	AutoLottoTicketsVendor 로또_판매기 = new AutoLottoTicketsVendor(new FixedLottoTicketGenerator(고정_로또_번호));

	LottoController lottoController = new LottoControllerImpl(Money.wons(로또_가격), 로또_판매기);

	@Test
	void 로또_가격_미만으로_로또를_입력할_경우_예외를_던진다() {
		List<List<Integer>> 로또_번호 = asList(고정_로또_번호);

		assertThatThrownBy(() -> lottoController.buyLottoTickets(로또_가격 - 1, 로또_번호))
			.isInstanceOf(IllegalArgumentException.class);
	}

}
