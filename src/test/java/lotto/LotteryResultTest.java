package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryResultTest {
    private WinningNumber winningNumber;
    private PurchaseLotteryTicket purchaseLotteryTicket;

    @BeforeEach
    void setUp() {
        winningNumber = WinningNumber.createWinningNumber("1, 2, 3, 4, 5, 6".split(", "), 7);
        purchaseLotteryTicket = new PurchaseLotteryTicket();
    }


    @DisplayName("1등 1개, 2등 1개, 3등 1개일 때 상금 구하기")
    @Test
    void calculateFirstSecondThirdTotalWinningMoney() {
        purchaseLotteryTicket.add(new LotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 12)));
        purchaseLotteryTicket.add(new LotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 7)));
        purchaseLotteryTicket.add(new LotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));

        LotteryResult lotteryResult = purchaseLotteryTicket.countMatchInAllTicket(winningNumber);
        assertThat(lotteryResult.calculateTotalWinningMoney()).isEqualTo(2_000_000_000 + 30_000_000 + 1_500_000);
    }

    @DisplayName("4등 1개, 5등 1개, 꽝 1개일 때 상금 구하기")
    @Test
    void calculateFourthFifthNoMatchTotalWinningMoney() {
        purchaseLotteryTicket.add(new LotteryNumbers(Arrays.asList(1, 2, 3, 4, 11, 12)));
        purchaseLotteryTicket.add(new LotteryNumbers(Arrays.asList(1, 2, 3, 11, 12, 13)));
        purchaseLotteryTicket.add(new LotteryNumbers(Arrays.asList(11, 12, 13, 14, 5, 6)));

        LotteryResult lotteryResult = purchaseLotteryTicket.countMatchInAllTicket(winningNumber);
        assertThat(lotteryResult.calculateTotalWinningMoney()).isEqualTo(50_000 + 5000);
    }
}
