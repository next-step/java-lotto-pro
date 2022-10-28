package lotto.domain.buyer;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.money.Money;
import lotto.domain.seller.LottoSeller;
import lotto.dto.LottoBill;
import lotto.dto.StatisticResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBuyerTest {

    @ParameterizedTest
    @MethodSource("buyLotto")
    @DisplayName("로또 구매하는 기능 테스트")
    void buy_lotto(Money money, int expectLottoCount) {
        LottoSeller lottoSeller = new LottoSeller();
        LottoBuyer lottoBuyer = new LottoBuyer(money);
        LottoBill lottoBill = lottoBuyer.buyLotto(lottoSeller);
        assertThat(lottoBill.getLottoPiece()).isEqualTo(expectLottoCount);
    }

    @ParameterizedTest
    @MethodSource("calculateStatisticSample")
    @DisplayName("구매한 로또와 당첨 로또번호를 비교하여 통계 계산")
    void calculate_statistic(Money money, int lottoCount, List<Lotto> lottos, double expect, Lotto winnerLotto) {
        LottoBuyer lottoBuyer = new LottoBuyer(money);
        lottoBuyer.initInfo(new LottoBill(lottoCount, lottos));

        StatisticResult result = lottoBuyer.calculateYieldStatistic(winnerLotto);
        assertThat(result.getYield().doubleValue()).isEqualTo(expect);
    }

    private static Stream<Arguments> buyLotto() {
        return Stream.of(
                Arguments.of(new Money(4000), 4),
                Arguments.of(new Money(5000), 5)
        );
    }

    private static Stream<Arguments> calculateStatisticSample() {
        Lotto lotto = new Lotto(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList()));

        List<Lotto> lottos = Stream.iterate(1, n -> n + 1)
                .map(v -> new Lotto(Stream.of(10, 20, 30, 40, 44, 34).map(LottoNumber::new).collect(Collectors.toList())))
                .limit(13)
                .collect(Collectors.toList());
        lottos.add(lotto);

        Lotto winnerLotto = new Lotto(Stream.of(3, 4, 10, 6, 7, 8).map(LottoNumber::new).collect(Collectors.toList()));
        return Stream.of(
                Arguments.of(new Money(14000), 14, lottos, 0.35, winnerLotto)
        );

    }

}
