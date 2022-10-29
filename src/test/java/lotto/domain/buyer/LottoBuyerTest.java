package lotto.domain.buyer;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;
import lotto.domain.seller.LottoSeller;
import lotto.prize.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
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
        Lottos lottos = lottoBuyer.buyLotto(lottoSeller);
        assertThat(lottos.getLottoCount()).isEqualTo(expectLottoCount);
    }

    @ParameterizedTest
    @MethodSource("calculateStatisticSample")
    @DisplayName("로또에 대한 상금 정보와 자신의 돈을 통해 수익률 계산")
    void calculate_yield(Map<Prize, Integer> prizes, double expect, int lottoCount) {
        LottoBuyer lottoBuyer = new LottoBuyer(new Money(1000));
        assertThat(lottoBuyer.calculateYield(prizes, lottoCount)).isEqualTo(BigDecimal.valueOf(expect));
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
        Lottos buyLottos = new Lottos(lottos);
        Lotto winnerLotto = new Lotto(Stream.of(3, 4, 10, 6, 7, 8).map(LottoNumber::new).collect(Collectors.toList()));
        Map<Prize, Integer> prizes = buyLottos.getPrizeOfLotto(winnerLotto);
        return Stream.of(
                Arguments.of(prizes, 0.35, 14)
        );
    }

}
