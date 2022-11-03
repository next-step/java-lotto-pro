package lotto.domain.lotto;

import lotto.prize.Prize;
import lotto.prize.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @ParameterizedTest
    @MethodSource("matchPrizeFirst")
    @DisplayName("로또와 당첨로또 비교 시1등(6개일치)")
    void prize_of_first(Lottos lottos, WinnerLotto winnerLotto, Prize prize, int expect) {
        Prizes prizes = lottos.getPrizeOfLotto(winnerLotto);
        assertThat(prizes.countMatchPrize(prize)).isEqualTo(expect);
    }

    @ParameterizedTest
    @MethodSource("matchPrizeSecond")
    @DisplayName("로또와 당첨로또 비교 시2등(5개 일치 , 보너스볼 일치)")
    void prize_of_second(Lottos lottos, WinnerLotto winnerLotto, Prize prize, int expect) {
        Prizes prizes = lottos.getPrizeOfLotto(winnerLotto);
        assertThat(prizes.countMatchPrize(prize)).isEqualTo(expect);
    }

    @ParameterizedTest
    @MethodSource("matchPrizeThird")
    @DisplayName("로또와 당첨로또 비교 시3등(5개 일치 , 보너스볼 불일치)")
    void prize_of_third(Lottos lottos, WinnerLotto winnerLotto, Prize prize, int expect) {
        Prizes prizes = lottos.getPrizeOfLotto(winnerLotto);
        assertThat(prizes.countMatchPrize(prize)).isEqualTo(expect);
    }

    @ParameterizedTest
    @MethodSource("matchPrizeFourth")
    @DisplayName("로또와 당첨로또 비교 시4등(4개 일치)")
    void prize_of_fourth(Lottos lottos, WinnerLotto winnerLotto, Prize prize, int expect) {
        Prizes prizes = lottos.getPrizeOfLotto(winnerLotto);
        assertThat(prizes.countMatchPrize(prize)).isEqualTo(expect);
    }

    @ParameterizedTest
    @MethodSource("matchPrizeFifth")
    @DisplayName("로또와 당첨로또 비교 시5등(3개 일치)")
    void prize_of_fifth(Lottos lottos, WinnerLotto winnerLotto, Prize prize, int expect) {
        Prizes prizes = lottos.getPrizeOfLotto(winnerLotto);
        assertThat(prizes.countMatchPrize(prize)).isEqualTo(expect);
    }


    private static Stream<Arguments> matchPrizeFirst() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList());
        List<LottoNumber> winnerLottoNumbers = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList());
        return Stream.of(
                Arguments.of(new Lottos(Collections.singletonList(new Lotto(lottoNumbers))),
                        new WinnerLotto(winnerLottoNumbers, new LottoNumber(10)), Prize.FIRST, 1)
        );
    }

    private static Stream<Arguments> matchPrizeSecond() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList());
        List<LottoNumber> winnerLottoNumbers = Stream.of(1, 2, 3, 4, 5, 8).map(LottoNumber::new).collect(Collectors.toList());
        return Stream.of(
                Arguments.of(new Lottos(Collections.singletonList(new Lotto(lottoNumbers))),
                        new WinnerLotto(winnerLottoNumbers, new LottoNumber(6)), Prize.SECOND, 1)
        );
    }

    private static Stream<Arguments> matchPrizeThird() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList());
        List<LottoNumber> winnerLottoNumbers = Stream.of(1, 2, 3, 4, 5, 8).map(LottoNumber::new).collect(Collectors.toList());
        return Stream.of(
                Arguments.of(new Lottos(Collections.singletonList(new Lotto(lottoNumbers))),
                        new WinnerLotto(winnerLottoNumbers, new LottoNumber(10)), Prize.THIRD, 1)
        );
    }

    private static Stream<Arguments> matchPrizeFourth() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList());
        List<LottoNumber> winnerLottoNumbers = Stream.of(1, 2, 3, 4, 7, 8).map(LottoNumber::new).collect(Collectors.toList());
        return Stream.of(
                Arguments.of(new Lottos(Collections.singletonList(new Lotto(lottoNumbers))),
                        new WinnerLotto(winnerLottoNumbers, new LottoNumber(10)), Prize.FOURTH, 1)
        );
    }

    private static Stream<Arguments> matchPrizeFifth() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList());
        List<LottoNumber> winnerLottoNumbers = Stream.of(1, 2, 3, 14, 15, 18).map(LottoNumber::new).collect(Collectors.toList());
        return Stream.of(
                Arguments.of(new Lottos(Collections.singletonList(new Lotto(lottoNumbers))),
                        new WinnerLotto(winnerLottoNumbers, new LottoNumber(10)), Prize.FIFTH, 1)
        );
    }
}
