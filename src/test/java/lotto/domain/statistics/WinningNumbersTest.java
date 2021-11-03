package lotto.domain.statistics;

import lotto.domain.lotto.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningNumbersTest {

    @Test
    @DisplayName("1 ~ 45 사이의 값을 입력 받아 당첨 번호를 생성한다.")
    void createWinningNumbers() {
        //given //when
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningNumbers winningNumbers = new WinningNumbers(numbers);

        //then
        assertThat(winningNumbers.getWinningNumbers()).hasSize(6);
    }

    @ParameterizedTest(name = "당첨 번호 범위: [{index}] {0}")
    @ValueSource(ints = {5, 7})
    @DisplayName("당첨 번호가 6개 보다 작거나 많은 경우 예외가 발생한다.")
    void validateSize(int size) {
        //given //when
        List<Integer> numbers = IntStream.rangeClosed(1, size)
                .boxed()
                .collect(Collectors.toList());

        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(numbers));
    }

    @Test
    @DisplayName("당첨 번호가 중복될 경우 예외가 발생한다.")
    void validateDuplication() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(numbers));
    }

    @ParameterizedTest(name = "당첨 번호와 일치하는 개수: [{index}] {1}")
    @MethodSource("lottoTickets")
    @DisplayName("당첨 번호와 일치하는 로또 번호 개수를 반환한다.")
    void matchWinningNumbers(LottoTicket lottoTicket, int excepted) {
        //given
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when
        int matchCount = winningNumbers.matchCount(lottoTicket);

        //then
        assertThat(matchCount).isEqualTo(excepted);
    }

    private static Stream<Arguments> lottoTickets() {
        return Stream.of(
                Arguments.of(LottoTicket.from(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(LottoTicket.from(2, 3, 4, 5, 6, 7), 5),
                Arguments.of(LottoTicket.from(3, 4, 5, 6, 7, 8), 4),
                Arguments.of(LottoTicket.from(4, 5, 6, 7, 8, 9), 3),
                Arguments.of(LottoTicket.from(5, 6, 7, 8, 9, 10), 2),
                Arguments.of(LottoTicket.from(6, 7, 8, 9, 10, 11), 1),
                Arguments.of(LottoTicket.from(7, 8, 9, 10, 11, 12), 0)
        );
    }
}