package lotto;

import static generic.Money.wons;
import static lotto.LottoTestUtils.lotto;
import static lotto.LottoTestUtils.lottoNumbers;
import static lotto.LottoTestUtils.lottos;
import static lotto.LottoTestUtils.resultGroup;
import static lotto.LottoWinResult.FIRST;
import static lotto.LottoWinResult.FOURTH;
import static lotto.LottoWinResult.NO_WIN;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LottosTest {

    @Test
    void 로또_콜렉션_생성() {
        // when
        final Lottos lottos = Lottos.of(Lotto.generate(), Lotto.generate());

        // then
        assertThat(lottos).extracting(Lottos::size).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = {"12000;12", "2000;2", "2500;2"}, delimiterString = ";")
    void 로또_자동_구매시_로또가_1000원일때_금액에_맞게_구매하는지(int purchase, int count) {
        // when
        final Lottos lottos = Lottos.purchaseAuto(wons(purchase));

        // then
        assertThat(lottos.size()).isEqualTo(count);
    }

    @ParameterizedTest
    @CsvSource(value = {"12000;12000", "2000;2000", "2500;2000"}, delimiterString = ";")
    void 로또를_구매한_금액이_맞는지(int purchase, int result) {
        // given
        final Lottos lottos = Lottos.purchaseAuto(wons(purchase));

        // when & then
        assertThat(lottos.purchasePrice()).isEqualTo(wons(result));
    }

    @ParameterizedTest
    @MethodSource("lottosEndArgs")
    void 로또가_종료되어_당첨결과_확인(Lottos lottos, LottoNumbers winNumbers, LottoWinResultGroup lottoWinResultGroup) {
        // when & then
        assertThat(lottos.end(winNumbers)).isEqualTo(lottoWinResultGroup);
    }

    static Stream<Arguments> lottosEndArgs() {
        return Stream.of(
                Arguments.of(lottos(lotto(1, 2, 3, 4, 5, 6),
                                lotto(1, 2, 3, 7, 8, 9),
                                lotto(7, 8, 9, 10, 11, 12)),
                        lottoNumbers(1, 2, 3, 4, 5, 6),
                        resultGroup(FIRST, FOURTH, NO_WIN))
        );
    }

    @Test
    void 로또_갯수_만큼_반복() {
        // given
        final Lottos lottos = lottos(Lotto.generate(), Lotto.generate(), Lotto.generate(), Lotto.generate());
        AtomicInteger atomicInteger = new AtomicInteger();

        // when
        lottos.each(lotto -> atomicInteger.incrementAndGet());

        // then
        assertThat(atomicInteger.get()).isEqualTo(4);
    }
}