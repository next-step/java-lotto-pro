package lotto.domain.buyer;

import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;
import lotto.prize.Prize;
import lotto.prize.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBuyerTest {

    @ParameterizedTest
    @MethodSource("buyLotto")
    @DisplayName("로또 구매하는 기능 테스트(auto만 구입)")
    void buy_lotto(Money money, int expectLottoCount) {
        LottoBuyer lottoBuyer = new LottoBuyer(money);
        Lottos lottos = lottoBuyer.buyAutoAndManualLotto(Collections.EMPTY_LIST);
        assertThat(lottos.getLottoCount()).isEqualTo(expectLottoCount);
    }

    @ParameterizedTest
    @MethodSource("buyLottoOnlyManual")
    @DisplayName("로또 구매하는 기능 테스트(manual만 구입)")
    void buy_lotto_only_manual(Money money, List<String> manualLottoNumbers, int expectLottoCount) {
        LottoBuyer lottoBuyer = new LottoBuyer(money);
        Lottos lottos = lottoBuyer.buyAutoAndManualLotto(manualLottoNumbers);
        assertThat(lottos.getLottoCount()).isEqualTo(expectLottoCount);
    }

    @ParameterizedTest
    @MethodSource("buyLottoOnlyManual")
    @DisplayName("로또 구매하는 기능 테스트(manual과 auto 동시구입)")
    void buy_lotto_manual_and_auto(Money money, List<String> manualLottoNumbers, int expectLottoCount) {
        LottoBuyer lottoBuyer = new LottoBuyer(money);
        Lottos lottos = lottoBuyer.buyAutoAndManualLotto(manualLottoNumbers);
        assertThat(lottos.getLottoCount()).isEqualTo(expectLottoCount);
    }

    private static Stream<Arguments> buyLotto() {
        return Stream.of(
                Arguments.of(new Money(4000), 4),
                Arguments.of(new Money(5000), 5)
        );
    }

    private static Stream<Arguments> buyLottoOnlyManual() {
        List<String> testCase = Stream.of("1,2,3,4,5,6").limit(4).collect(Collectors.toList());
        return Stream.of(
                Arguments.of(new Money(4000), testCase, 4)
        );
    }

    private static Stream<Arguments> buyLottoAutoAndManual() {
        List<String> testCase = Stream.of("1,2,3,4,5,6").limit(1).collect(Collectors.toList());
        return Stream.of(
                Arguments.of(new Money(4000), 4)
        );
    }
}
