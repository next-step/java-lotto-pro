package lotto.domain.ticket;

import static lotto.fixture.Fixture.*;
import static org.assertj.core.api.Assertions.*;

import java.util.*;
import java.util.stream.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import lotto.domain.result.*;

class TicketTest {
    private static Stream<Arguments> provideDecideRankByWinningNumbersTest() {
        return Stream.of(
            Arguments.of(Ticket.from(Arrays.asList(1, 2, 3, 4, 5, 6)), Rank.FIRST),
            Arguments.of(Ticket.from(Arrays.asList(1, 2, 3, 4, 5, 7)), Rank.SECOND),
            Arguments.of(Ticket.from(Arrays.asList(1, 2, 3, 4, 5, 8)), Rank.THIRD),
            Arguments.of(Ticket.from(Arrays.asList(1, 2, 3, 4, 7, 8)), Rank.FOURTH),
            Arguments.of(Ticket.from(Arrays.asList(1, 2, 3, 7, 8, 9)), Rank.FIFTH),
            Arguments.of(Ticket.from(Arrays.asList(1, 2, 7, 8, 9, 10)), Rank.MISS),
            Arguments.of(Ticket.from(Arrays.asList(1, 7, 8, 9, 10, 11)), Rank.MISS),
            Arguments.of(Ticket.from(Arrays.asList(7, 8, 9, 10, 11, 12)), Rank.MISS)
        );
    }

    @DisplayName("LottoNumbers 객체를 인자로 받는 정적팩토리 메서드를 호출하면, 객체를 생성한다.")
    @Test
    void createTest1() {
        assertThat(Ticket.from(LOTTO_NUMBER_1_2_3_4_5_6)).isInstanceOf(Ticket.class);
    }

    @DisplayName("List콜렉션 객체를 인자로 받는 정적팩토리 메서드를 호출하면, 객체를 생성한다.")
    @Test
    void createTest2() {
        assertThat(Ticket.from(Arrays.asList(1, 2, 3, 4, 5, 6))).isInstanceOf(Ticket.class);
    }

    @DisplayName("정적팩토리 메서드에 null값을 인자로 받으면, 예외를 던진다.")
    @Test
    void exceptionTest() {
        assertThatThrownBy(() -> Ticket.from((List<Integer>)null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Ticket.from((LottoNumbers)null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("티켓과 우승번호를 입력으로 하는 함수를 호출하면 조건에 맞는 Rank 객체를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideDecideRankByWinningNumbersTest")
    void decideRankByWinningNumbersTest(Ticket ticket, Rank expected) {
        assertThat(ticket.decideRankByWinningNumbers(WINNING_LOTTO_NUMBERS_1_2_3_4_5_6_BONUS_7)).isEqualTo(expected);
    }
}
