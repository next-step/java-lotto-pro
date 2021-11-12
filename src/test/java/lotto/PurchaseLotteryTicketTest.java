package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseLotteryTicketTest {

    private WinningNumber winningNumber;
    private PurchaseLotteryTicket purchaseLotteryTicket;

    @BeforeEach
    void setUp() {
        winningNumber = WinningNumber.createWinningNumber("1, 2, 3, 4, 5, 6".split(", "), 7);
        purchaseLotteryTicket = new PurchaseLotteryTicket();
        purchaseLotteryTicket.add(new LotteryNumbers(Arrays.asList(1, 2, 3, 10, 11, 12)));
        purchaseLotteryTicket.add(new LotteryNumbers(Arrays.asList(1, 2, 3, 10, 11, 12)));
        purchaseLotteryTicket.add(new LotteryNumbers(Arrays.asList(1, 2, 3, 10, 11, 12)));
        purchaseLotteryTicket.add(new LotteryNumbers(Arrays.asList(21, 2, 3, 4, 5, 6)));
        purchaseLotteryTicket.add(new LotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("구매한 전체 로또 티켓에서 등수별 티켓 수 확인(보너스 번호 추가)")
    @Test
    void countMatchInAllTicket() {
        LotteryResult lotteryResult = purchaseLotteryTicket.countMatchInAllTicket(winningNumber);
        assertThat(lotteryResult.getOrDefault(Rank.FIRST, 0)).isEqualTo(1);
        assertThat(lotteryResult.getOrDefault(Rank.SECOND, 0)).isEqualTo(0);
        assertThat(lotteryResult.getOrDefault(Rank.THIRD, 0)).isEqualTo(1);
        assertThat(lotteryResult.getOrDefault(Rank.FOURTH, 0)).isEqualTo(0);
        assertThat(lotteryResult.getOrDefault(Rank.FIFTH, 0)).isEqualTo(3);
    }
}
