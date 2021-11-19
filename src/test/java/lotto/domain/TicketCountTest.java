package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exception.LottoException;

public class TicketCountTest {

    @DisplayName("티켓 갯수 생성")
    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void constructCount_success(int num) {
        TicketCount ticketCount = new TicketCount(num);
        assertThat(ticketCount).isEqualTo(new TicketCount(num));
    }

    @DisplayName("음수로 티켓 개수 생성 시 에러")
    @Test
    void throwsError_whenNegativeCount() {
        assertThatExceptionOfType(LottoException.class)
            .isThrownBy(() -> new TicketCount(-1))
            .withMessage("로또 티켓 갯수는 양수여야 합니다.");
    }

    @DisplayName("입력받은 갯수보다 큰 티켓 갯수인지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,false", "3,false"})
    void isBiggerThan(int count, boolean result) {
        assertThat(new TicketCount(2).isBiggerThan(count)).isEqualTo(result);
    }

    @DisplayName("입력받은 갯수보다 큰 티켓 개수 class인지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,false", "3,false"})
    void isBiggerThanCount(int count, boolean result) {
        assertThat(new TicketCount(2).isBiggerThan(new TicketCount(count))).isEqualTo(result);
    }

    @DisplayName("티켓 갯수 빼기")
    @Test
    public void minus() {
        assertThat(new TicketCount(3).minus(new TicketCount(3))).isEqualTo(new TicketCount(0));
    }

    @DisplayName("티켓 갯수 빼기 에러")
    @Test
    public void throwsError_whenInValidMinus() {
        assertThatExceptionOfType(LottoException.class)
            .isThrownBy(() -> new TicketCount(3).minus(new TicketCount(4)))
            .withMessage("전체 갯수보다 큰 갯수입니다.");
    }
}
