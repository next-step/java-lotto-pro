package lotto.domain;

import static lotto.LottoTestUtils.lotto;
import static lotto.LottoTestUtils.lottos;
import static lotto.LottoTestUtils.resultGroup;
import static lotto.LottoTestUtils.winningNumbers;
import static lotto.domain.LottoWinResult.FIFTH;
import static lotto.domain.LottoWinResult.FIRST;
import static lotto.domain.LottoWinResult.NO_WIN;
import static org.assertj.core.api.Assertions.assertThat;

import generic.Money;
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
        final Lottos lottos = Lottos.purchaseAuto(Money.valueOf(purchase));

        // then
        assertThat(lottos.size()).isEqualTo(count);
    }

    @ParameterizedTest
    @CsvSource(value = {"12000;12000", "2000;2000", "2500;2000"}, delimiterString = ";")
    void 로또를_구매한_금액이_맞는지(int purchase, int result) {
        // given
        final Lottos lottos = Lottos.purchaseAuto(Money.valueOf(purchase));

        // when & then
        assertThat(lottos.purchasePrice()).isEqualTo(Money.valueOf(result));
    }

    @ParameterizedTest
    @MethodSource("lottosEndArgs")
    void 로또가_종료되어_당첨결과_확인(Lottos lottos, WinningNumbers winNumbers, LottoWinResultGroup lottoWinResultGroup) {
        // when & then
        assertThat(lottos.draw(winNumbers)).isEqualTo(lottoWinResultGroup);
    }

    static Stream<Arguments> lottosEndArgs() {
        return Stream.of(
                Arguments.of(lottos(lotto(1, 2, 3, 4, 5, 6),
                                lotto(1, 2, 3, 7, 8, 9),
                                lotto(7, 8, 9, 10, 11, 12)),
                        winningNumbers(1, 2, 3, 4, 5, 6, 7),
                        resultGroup(FIRST, FIFTH, NO_WIN))
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

    @Test
    void 로또_병합_확인() {
        // given
        final Lottos firstLottos = lottos(lotto(1, 2, 3, 4, 5, 6));
        final Lottos secondLottos = lottos(lotto(7, 8, 9, 10, 11, 12));

        // when & then
        assertThat(firstLottos.addAll(secondLottos)).isEqualTo(
                lottos(lotto(1, 2, 3, 4, 5, 6), lotto(7, 8, 9, 10, 11, 12)));
    }

}