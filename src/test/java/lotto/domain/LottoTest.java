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

class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("정상적으로 로또를 생성한다")
    @Test
    void createLottoTicket() {
        Lotto lotto = new Lotto(Arrays.asList(5, 10, 23, 27, 30, 35));
        assertNotNull(lotto);
    }

    @DisplayName("로또는 6자리의 숫자로 이루어져야 한다")
    @Test
    void createLottoTicketSizeException() {
        assertThatThrownBy(() -> new Lotto(Collections.emptyList()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.WRONG_NUMBERS_SIZE_MESSAGE.getMessage());

        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.WRONG_NUMBERS_SIZE_MESSAGE.getMessage());

        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.WRONG_NUMBERS_SIZE_MESSAGE.getMessage());
    }

    @DisplayName("로또 번호는 중복된 번호가 없어야 한다")
    @Test
    void createLottoTicketDuplicateException() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.EXIST_DUPLICATE_NUMBER_MESSAGE.getMessage());

        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 1, 1, 1, 1, 1)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.EXIST_DUPLICATE_NUMBER_MESSAGE.getMessage());
    }

    @DisplayName("로또 번호는 1~45 사이의 숫자만 가능하다")
    @Test
    void createLottoTicketRangeException() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(0, 1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.OUT_OF_RANGE_NUMBER_MESSAGE.getMessage());

        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 46)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.OUT_OF_RANGE_NUMBER_MESSAGE.getMessage());
    }

    @DisplayName("로또 번호는 정렬되어 있어야 한다")
    @Test
    void createLottoTicketSortedException() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(2, 1, 3, 5, 9, 7)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.NON_SORTED_NUMBERS_MESSAGE.getMessage());
    }

    @DisplayName("0개부터 6개까지 맞춘 숫자를 확인한다")
    @Test
    void winningRank() {
        int first = lotto.match(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertEquals(6, first);

        int third = lotto.match(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        assertEquals(5, third);

        int fourth = lotto.match(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)));
        assertEquals(4, fourth);

        int fifth = lotto.match(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
        assertEquals(3, fifth);

        int missByTwo = lotto.match(new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10)));
        assertEquals(2, missByTwo);

        int missByOne = lotto.match(new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11)));
        assertEquals(1, missByOne);

        int missByZero = lotto.match(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)));
        assertEquals(0, missByZero);
    }

    @DisplayName("현재 로또 번호들과 중복되는 번호인지 확인한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 6})
    void existLottoNumber(int number) {
        assertTrue(lotto.existLottoNumber(LottoNumber.valueOf(number)));
        assertFalse(lotto.existLottoNumber(LottoNumber.valueOf(7)));
    }
}
