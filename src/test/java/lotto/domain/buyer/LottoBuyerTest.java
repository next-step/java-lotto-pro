package lotto.domain.buyer;

import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;
import lotto.domain.seller.LottoSeller;
import lotto.prize.Prize;
import lotto.prize.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBuyerTest {

    @ParameterizedTest
    @MethodSource("buyLotto")
    @DisplayName("로또 구매하는 기능 테스트")
    void buy_lotto(Money money, int expectLottoCount) {
        LottoSeller lottoSeller = new LottoSeller();
        LottoBuyer lottoBuyer = new LottoBuyer(money);
        Lottos lottos = lottoBuyer.buyLotto(lottoSeller);
        assertThat(lottos.getLottoCount()).isEqualTo(expectLottoCount);
    }

    @ParameterizedTest
    @MethodSource("calculateStatisticSample")
    @DisplayName("로또에 대한 상금 정보와 자신의 돈을 통해 수익률 계산")
    void calculate_yield(Prizes prizes, Lottos lottos, LottoBuyer lottoBuyer, double expect) {
        assertThat(lottoBuyer.calculateYield(prizes, lottos.getLottoCount())).isEqualTo(BigDecimal.valueOf(expect));
    }

    private static Stream<Arguments> buyLotto() {
        return Stream.of(
                Arguments.of(new Money(4000), 4),
                Arguments.of(new Money(5000), 5)
        );
    }

    private static Stream<Arguments> calculateStatisticSample() {
        LottoBuyer lottoBuyer = new LottoBuyer(new Money(14000));
        Lottos lottos = lottoBuyer.buyLotto(new LottoSeller());
        return Stream.of(
                Arguments.of(new Prizes(Collections.singletonList(Prize.FIFTH)), lottos, lottoBuyer, 0.35)
        );
    }

}
