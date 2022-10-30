package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.util.Lists;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.LottoTicket;

class FixedLottoTicketGeneratorTest {

	@ParameterizedTest
	@MethodSource("고정_로또_번호_입력")
	void 고정_로또_번호를_생성한다(List<Integer> 고정_로또_번호) {
		FixedLottoTicketGenerator 고정_로또_번호_생성기 = new FixedLottoTicketGenerator(고정_로또_번호);

		LottoTicket 로또_티켓 = 고정_로또_번호_생성기.generate();

		assertThat(로또_티켓).isEqualTo(LottoTicket.of(고정_로또_번호));

	}

	private static Stream<Arguments> 고정_로또_번호_입력() {
		return Stream.of(
			Arguments.of(Lists.newArrayList(1, 2, 3, 4, 5, 6)),
			Arguments.of(Lists.newArrayList(45, 44, 43, 42, 41, 40))
		);
	}

}
