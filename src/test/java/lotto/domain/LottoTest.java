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

    @DisplayName("로또 티켓 생성")
    @Test
    void createLottoTicket() {
        new Lotto(Arrays.asList(5, 10, 23, 27, 30, 35));
    }

    @DisplayName("로또 티켓 생성 - 6자리가 아닌 경우")
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

    @DisplayName("로또 티켓 생성 - 중복된 숫자")
    @Test
    void createLottoTicketDuplicateException() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.EXIST_DUPLICATE_NUMBER_MESSAGE.getMessage());

        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 1, 1, 1, 1, 1)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.EXIST_DUPLICATE_NUMBER_MESSAGE.getMessage());
    }

    @DisplayName("로또 티켓 생성 - 범위를 벗어난 숫자")
    @Test
    void createLottoTicketRangeException() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(0, 1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.OUT_OF_RANGE_NUMBER_MESSAGE.getMessage());

        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 46)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.OUT_OF_RANGE_NUMBER_MESSAGE.getMessage());
    }

    @DisplayName("로또 티켓 생성 - 정렬되지 않은 숫자")
    @Test
    void createLottoTicketSortedException() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(2, 1, 3, 5, 9, 7)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.NON_SORTED_NUMBERS_MESSAGE.getMessage());
    }

    @DisplayName("로또 결과 확인")
    @Test
    void winningRank() {
        LottoNumber bonusNumber = LottoNumber.valueOf(25);
        Rank first = lotto.createWinningRank(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), bonusNumber);
        assertEquals(Rank.FIRST, first);

        Rank third = lotto.createWinningRank(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), bonusNumber);
        assertEquals(Rank.THIRD, third);

        Rank fourth = lotto.createWinningRank(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)), bonusNumber);
        assertEquals(Rank.FOURTH, fourth);

        Rank fifth = lotto.createWinningRank(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)), bonusNumber);
        assertEquals(Rank.FIFTH, fifth);

        Rank missByTwo = lotto.createWinningRank(new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10)), bonusNumber);
        assertEquals(Rank.MISS, missByTwo);

        Rank missByOne = lotto.createWinningRank(new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11)), bonusNumber);
        assertEquals(Rank.MISS, missByOne);

        Rank missByZero = lotto.createWinningRank(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)), bonusNumber);
        assertEquals(Rank.MISS, missByZero);
    }

    @DisplayName("로또 2등 결과 확인")
    @Test
    void winningRankSecond() {
        int bonus = 25;
        LottoNumber bonusNumber = LottoNumber.valueOf(bonus);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, bonus));
        Rank second = lotto.createWinningRank(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), bonusNumber);
        assertEquals(Rank.SECOND, second);
    }

    @DisplayName("존재하는 로또 번호인지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 6})
    void existLottoNumber(int number) {
        assertTrue(lotto.existLottoNumber(LottoNumber.valueOf(number)));
        assertFalse(lotto.existLottoNumber(LottoNumber.valueOf(7)));
    }
}
