package lotto.model;

import java.util.Collections;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoProfitTest {

    @ParameterizedTest(name = "{0}을 가지고 {1}을 당첨되어 수익률은 {2} 검증")
    @MethodSource("parameterVerifyLottoProfit")
    void verifyLottoProfit(String money, LottoRank result, double expected) {
        LottoPurchaseQuantity lottoPurchaseQuantity = new LottoPurchaseQuantity(money);
        LottoRanks lottoRanks = LottoRanks.of(Collections.singletonList(result));
        LottoProfit lottoProfit = LottoProfit.calculate(lottoPurchaseQuantity, lottoRanks);

        Assertions.assertEquals(expected, lottoProfit.getProfitRate());
    }

    public static Stream<Arguments> parameterVerifyLottoProfit() {
        return Stream.of(
                Arguments.of("1000", LottoRank.FOURTH, 5),
                Arguments.of("5000", LottoRank.FOURTH, 1),
                Arguments.of("1000", LottoRank.SEVENTH, 0)
        );
    }
}
