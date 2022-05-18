package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottosResultTest {

    @DisplayName("plusReturnMoney 상금 추가시 반영이 잘 되는지 확인")
    @Test
    void plusReturnMoneyTest() {
        int purchase = 1000;
        int returnMoney = 0;
        LottosResult lottosResult = new LottosResult(purchase);

        int winner = 1000;
        lottosResult.plusReturnMoney(winner);
        returnMoney += winner;
        assertThat(lottosResult.ratio())
                .isEqualTo(getExpectedRatio(purchase, returnMoney));

        winner = 2000;
        lottosResult.plusReturnMoney(winner);
        returnMoney += winner;
        assertThat(lottosResult.ratio())
                .isEqualTo(getExpectedRatio(purchase, returnMoney));
    }

    float getExpectedRatio(int purchase, int returnMoney) {
        return (float) returnMoney / purchase;
    }
}