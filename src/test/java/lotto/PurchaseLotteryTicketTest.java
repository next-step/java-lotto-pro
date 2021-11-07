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
        winningNumber = WinningNumber.createWinningNumber("1, 2, 3, 4, 5, 6".split(", "));
        purchaseLotteryTicket = new PurchaseLotteryTicket();
        purchaseLotteryTicket.add(new LotteryTicket(Arrays.asList(1, 2, 3, 10, 11, 12)));
        purchaseLotteryTicket.add(new LotteryTicket(Arrays.asList(1, 2, 3, 10, 11, 12)));
        purchaseLotteryTicket.add(new LotteryTicket(Arrays.asList(1, 2, 3, 10, 11, 12)));
        purchaseLotteryTicket.add(new LotteryTicket(Arrays.asList(21, 2, 3, 4, 5, 6)));
        purchaseLotteryTicket.add(new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("구매한 로또 티켓 중 당첨 번호가 3개인 티켓 수")
    @Test
    void matchThree() {
        int matchThree = purchaseLotteryTicket.countMatchThree(winningNumber);
        assertThat(matchThree).isEqualTo(3);
    }

    @DisplayName("구매한 로또 티켓 중 당첨 번호가 4개인 티켓 수")
    @Test
    void matchFour() {
        int matchFour = purchaseLotteryTicket.countMatchFour(winningNumber);
        assertThat(matchFour).isEqualTo(0);
    }

    @DisplayName("구매한 로또 티켓 중 당첨 번호가 5개인 티켓 수")
    @Test
    void matchFive() {
        int matchFive = purchaseLotteryTicket.countMatchFive(winningNumber);
        assertThat(matchFive).isEqualTo(1);
    }

    @DisplayName("구매한 로또 티켓 중 당첨 번호가 6개인 티켓 수")
    @Test
    void matchSix() {
        int matchSix = purchaseLotteryTicket.countMatchSix(winningNumber);
        assertThat(matchSix).isEqualTo(1);
    }

}
