package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTicketTest {

    private LotteryTicket lotteryTicket;

    @BeforeEach
    void setUp() {
        lotteryTicket = LotteryTicket.createAutoLotteryNumber(Arrays.asList(10, 5, 4, 3, 2, 1));
    }

    @DisplayName("로또 번호 자동 생성 시 숫자가 오름차순 정렬되어 저장되는지 확인")
    @Test
    void checkNumberSort() {
        assertThat(lotteryTicket.getLotteryNumber()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 10));
    }

    @DisplayName("로또 티켓의 로또 번호에 당첨 번호가 몇개 있는지 세기")
    @Test
    void countMatch() {
        WinningNumber winningNumber = WinningNumber.createWinningNumber("1, 2, 3, 4, 5, 6".split(", "));
        assertThat(lotteryTicket.countMatch(winningNumber)).isEqualTo(5);
    }

    @DisplayName("자동 생성 로또 번호 사이즈 확인")
    @Test
    void size() {
        assertThat(lotteryTicket.size()).isEqualTo(6);
    }

    @DisplayName("자동 생성 로또 번호 가져오기")
    @Test
    void getLotteryNumber() {
        assertThat(lotteryTicket.getLotteryNumber()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 10));
    }
}
