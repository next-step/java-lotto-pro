package lotto.domain.ticket;

import lotto.domain.number.MatchedCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.fixture.Fixture.LOTTO_NUMBER_1_2_3_4_5_6;
import static lotto.fixture.Fixture.WINNING_LOTTO_NUMBERS_1_2_3_4_5_6;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TicketTest {
    private static Stream<Arguments> provideCalculateResultTest() {
        return Stream.of(
            Arguments.of(Ticket.from(Arrays.asList(7, 8, 9, 10, 11, 12)), MatchedCount.from(0)),
            Arguments.of(Ticket.from(Arrays.asList(6, 8, 9, 10, 11, 12)), MatchedCount.from(1)),
            Arguments.of(Ticket.from(Arrays.asList(5, 6, 9, 10, 11, 12)), MatchedCount.from(2)),
            Arguments.of(Ticket.from(Arrays.asList(4, 5, 6, 10, 11, 12)), MatchedCount.from(3)),
            Arguments.of(Ticket.from(Arrays.asList(3, 4, 5, 6, 11, 12)), MatchedCount.from(4)),
            Arguments.of(Ticket.from(Arrays.asList(2, 3, 4, 5, 6, 12)), MatchedCount.from(5)),
            Arguments.of(Ticket.from(Arrays.asList(1, 2, 3, 4, 5, 6)), MatchedCount.from(6))
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
        assertThatThrownBy(() -> Ticket.from((List<Integer>) null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Ticket.from((LottoNumbers) null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("티켓과 우승번호를 입력으로 하는 매칭개수함수를 호출하면 매칭개수 객체를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideCalculateResultTest")
    void calculateResultTest(Ticket ticket, MatchedCount expected) {
        assertThat(ticket.countEqualLottoNumber(WINNING_LOTTO_NUMBERS_1_2_3_4_5_6)).isEqualTo(expected);
    }
}
