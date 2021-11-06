package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseLotteryTicketTest {

    private String[] winningNumber;
    private PurchaseLotteryTicket purchaseLotteryTicket;

    @BeforeEach
    void setUp() {
        winningNumber = "1, 2, 3, 4, 5, 6".split(", ");
        purchaseLotteryTicket = new PurchaseLotteryTicket();
        purchaseLotteryTicket.add(new LotteryTicket(Arrays.asList(1,2,3,10,11,12)));
        purchaseLotteryTicket.add(new LotteryTicket(Arrays.asList(1,2,3,10,11,12)));
        purchaseLotteryTicket.add(new LotteryTicket(Arrays.asList(1,2,3,10,11,12)));
        purchaseLotteryTicket.add(new LotteryTicket(Arrays.asList(21,2,3,4,5,6)));
        purchaseLotteryTicket.add(new LotteryTicket(Arrays.asList(1,2,3,4,5,6)));
    }

    @Test
    void matchThree() {
        int matchThree = purchaseLotteryTicket.countMatchThree(winningNumber);
        assertThat(matchThree).isEqualTo(3);
    }

    @Test
    void matchFour() {
        int matchFour = purchaseLotteryTicket.countMatchFour(winningNumber);
        assertThat(matchFour).isEqualTo(0);
    }

    @Test
    void matchFive() {
        int matchFive = purchaseLotteryTicket.countMatchFive(winningNumber);
        assertThat(matchFive).isEqualTo(1);
    }

    @Test
    void matchSix() {
        int matchSix = purchaseLotteryTicket.countMatchSix(winningNumber);
        assertThat(matchSix).isEqualTo(1);
    }

}
