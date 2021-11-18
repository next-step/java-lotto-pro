package lotto.utils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.Ball;
import lotto.domain.Money;
import lotto.domain.Ticket;
import lotto.domain.TicketCount;
import lotto.exception.LottoException;

class ParserTest {
    @DisplayName("money 변환")
    @Test
    void parseMoney() {
        assertThat(Parser.parseMoney("1")).isEqualTo(new Money(1));
    }

    @DisplayName("money 변환 에러")
    @ParameterizedTest
    @ValueSource(strings = {"a", "", " ", "~", "1a"})
    void parseMoney_error(String invalidNumber) {
        assertThatExceptionOfType(LottoException.class)
            .isThrownBy(() -> Parser.parseMoney(invalidNumber))
            .withMessage("숫자가 아닌 값이 있습니다.");
    }

    @DisplayName("count 변환")
    @Test
    void parseCount() {
        assertThat(Parser.parseCount("1")).isEqualTo(new TicketCount(1));
    }

    @DisplayName("ticket 변환")
    @Test
    void parseTicket() {
        assertThat(Parser.parseTicket("1,2,3,4,5,6")).isEqualTo(new Ticket(Arrays.asList(1,2,3,4,5,6)));
    }

    @DisplayName("ticket 변환 에러")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,a", "1,2,3,4,5,6a", "~,2,3,4,5,6", ",2,3,4,5,6", " ,2,3,4,5,6"})
    void parseTicket_error(String invalidNumber) {
        assertThatExceptionOfType(LottoException.class)
            .isThrownBy(() -> Parser.parseTicket(invalidNumber))
            .withMessage("숫자가 아닌 값이 있습니다.");
    }

    @DisplayName("ball 변환")
    @Test
    void parseBall() {
        assertThat(Parser.parseBall("1")).isEqualTo(Ball.of(1));
    }
}