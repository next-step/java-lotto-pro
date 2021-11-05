package lotto.domain;

import static lotto.domain.LottoTicket.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {
    @DisplayName("로또 티켓 생성")
    @Test
    void createLottoTicket() {
        new LottoTicket(Arrays.asList(5, 10, 23, 27, 30, 35));
    }

    @DisplayName("로또 티켓 생성 - 6자리가 아닌 경우")
    @Test
    void createLottoTicketSizeException() {
        assertThatThrownBy(() -> new LottoTicket(Collections.emptyList()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(WRONG_NUMBERS_SIZE_MESSAGE);

        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(WRONG_NUMBERS_SIZE_MESSAGE);

        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(WRONG_NUMBERS_SIZE_MESSAGE);
    }

    @DisplayName("로또 티켓 생성 - 중복된 숫자")
    @Test
    void createLottoTicketDuplicateException() {
        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(1, 1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(EXIST_DUPLICATE_NUMBER_MESSAGE);

        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(1, 1, 1, 1, 1, 1)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(EXIST_DUPLICATE_NUMBER_MESSAGE);
    }

    @DisplayName("로또 티켓 생성 - 범위를 벗어난 숫자")
    @Test
    void createLottoTicketRangeException() {
        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(0, 1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(OUT_OF_RANGE_NUMBER_MESSAGE);

        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 46)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(OUT_OF_RANGE_NUMBER_MESSAGE);
    }

    @DisplayName("로또 티켓 생성 - 정렬되지 않은 숫자")
    @Test
    void createLottoTicketSortedException() {
        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(2, 1, 3, 5, 9, 7)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(NON_SORTED_NUMBERS_MESSAGE);
    }
}
