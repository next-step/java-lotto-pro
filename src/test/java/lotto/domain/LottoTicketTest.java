package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTicketTest {
    private LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

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
            .hasMessage(Message.WRONG_NUMBERS_SIZE_MESSAGE.getMessage());

        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.WRONG_NUMBERS_SIZE_MESSAGE.getMessage());

        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.WRONG_NUMBERS_SIZE_MESSAGE.getMessage());
    }

    @DisplayName("로또 티켓 생성 - 중복된 숫자")
    @Test
    void createLottoTicketDuplicateException() {
        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(1, 1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.EXIST_DUPLICATE_NUMBER_MESSAGE.getMessage());

        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(1, 1, 1, 1, 1, 1)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.EXIST_DUPLICATE_NUMBER_MESSAGE.getMessage());
    }

    @DisplayName("로또 티켓 생성 - 범위를 벗어난 숫자")
    @Test
    void createLottoTicketRangeException() {
        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(0, 1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.OUT_OF_RANGE_NUMBER_MESSAGE.getMessage());

        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 46)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.OUT_OF_RANGE_NUMBER_MESSAGE.getMessage());
    }

    @DisplayName("로또 티켓 생성 - 정렬되지 않은 숫자")
    @Test
    void createLottoTicketSortedException() {
        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(2, 1, 3, 5, 9, 7)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.NON_SORTED_NUMBERS_MESSAGE.getMessage());
    }

    @DisplayName("로또 결과 확인")
    @Test
    void winningRank() {
        Rank first = lottoTicket.winningRank(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertEquals(Rank.FIRST, first);

        Rank second = lottoTicket.winningRank(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 7)));
        assertEquals(Rank.SECOND, second);

        Rank third = lottoTicket.winningRank(new LottoTicket(Arrays.asList(1, 2, 3, 4, 7, 8)));
        assertEquals(Rank.THIRD, third);

        Rank fifth = lottoTicket.winningRank(new LottoTicket(Arrays.asList(1, 2, 3, 7, 8, 9)));
        assertEquals(Rank.FIFTH, fifth);

        Rank missByTwo = lottoTicket.winningRank(new LottoTicket(Arrays.asList(1, 2, 7, 8, 9, 10)));
        assertEquals(Rank.MISS, missByTwo);

        Rank missByOne = lottoTicket.winningRank(new LottoTicket(Arrays.asList(1, 7, 8, 9, 10, 11)));
        assertEquals(Rank.MISS, missByOne);

        Rank missByZero = lottoTicket.winningRank(new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12)));
        assertEquals(Rank.MISS, missByZero);
    }

    @DisplayName("존재하는 로또 번호인지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 6})
    void existLottoNumber(int number) {
        assertTrue(lottoTicket.existLottoNumber(new LottoNumber(number)));
        assertFalse(lottoTicket.existLottoNumber(new LottoNumber(7)));
    }
}
