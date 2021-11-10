package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryResultTest {

    @DisplayName("1등 1개, 2등 1개, 4등 1개일 때 상금 구하기")
    @Test
    void calculateTotalWinningMoney() {
        WinningNumber winningNumber = WinningNumber.createWinningNumber("1, 2, 3, 4, 5, 6".split(", "));
        PurchaseLotteryTicket purchaseLotteryTicket = new PurchaseLotteryTicket();
        purchaseLotteryTicket.add(new LotteryTicket(Arrays.asList(1, 2, 3, 10, 11, 12)));
        purchaseLotteryTicket.add(new LotteryTicket(Arrays.asList(21, 2, 3, 4, 5, 6)));
        purchaseLotteryTicket.add(new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));

        LotteryResult lotteryResult = purchaseLotteryTicket.countMatchInAllTicket(winningNumber);
        assertThat(lotteryResult.calculateTotalWinningMoney()).isEqualTo(2000000000 + 1500000 + 5000);
    }
}
