package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import utils.Randoms;

class LottoTicketTest {

	@Test
	void 로또_티켓은_중복되지_않는_로또_번호_6개를_갖는다() {
		List<Integer> 로또_번호_입력 = generateUniqueNumbers();
		LottoTicket.of(로또_번호_입력);
	}

	@ParameterizedTest
	@MethodSource("중복된_로또번호_생성")
	void 로또_티켓에_중복된_로또_번호를_입력할_경우_예외를_던진다(List<Integer> 로또_번호_입력) {
		assertThatThrownBy(() -> LottoTicket.of(로또_번호_입력))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@MethodSource("갯수가_무효한_로또번호_생성")
	void 로또_티켓에_입력_갯수가_유효하지_않으면_예외를_던진다(List<Integer> 로또_번호_입력) {
		assertThatThrownBy(() -> LottoTicket.of(로또_번호_입력))
			.isInstanceOf(IllegalArgumentException.class);
	}

	private static Stream<Arguments> 중복된_로또번호_생성() {
		return Stream.of(
			Arguments.of(Lists.newArrayList(1, 2, 3, 4, 5, 5)),
			Arguments.of(Lists.newArrayList(1, 1, 1, 1, 1, 1))
		);
	}

	private static Stream<Arguments> 갯수가_무효한_로또번호_생성() {
		return Stream.of(
			Arguments.of(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7)),
			Arguments.of(Lists.newArrayList(45, 44, 43, 42, 41, 40, 39))
		);
	}

	private static List<Integer> generateUniqueNumbers() {
		return Randoms.generateUniqueNumbers(1, 45, 6);
	}
}
