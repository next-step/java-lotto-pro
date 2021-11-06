package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WinningLottoTest {

    static Stream<Arguments> listProvide() {
        List<Number> matchNumber = Arrays.asList(Number.of(1), Number.of(2), Number.of(3),
                Number.of(4), Number.of(5), Number.of(6));
        Number bonusNumber = Number.of(7);

        List<Number> lottoNumber = Arrays.asList(Number.of(1), Number.of(2), Number.of(3),
                Number.of(4), Number.of(5), Number.of(7));

        return Stream.of(arguments(lottoNumber, matchNumber, bonusNumber));
    }

    @ParameterizedTest
    @MethodSource("listProvide")
    @DisplayName("로또 번호 보너스 매칭 확인")
    public void isExistBonusNumberTest(List<Number> lottoNumber, List<Number> matchNumber, Number bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(matchNumber, bonusNumber);

        boolean actual = winningLotto.isExistBonusNumber(lottoNumber);

        assertThat(actual).isTrue();
    }

    static Stream<Arguments> listProvide2() {
        List<Number> matchNumber = Arrays.asList(Number.of(1), Number.of(2), Number.of(3),
                Number.of(4), Number.of(5), Number.of(6));
        Number bonusNumber = Number.of(7);
        return Stream.of(arguments(matchNumber, bonusNumber));
    }

    @ParameterizedTest
    @MethodSource("listProvide2")
    @DisplayName("로또 번호 매칭 확인")
    public void isNumberTest(List<Number> matchNumber, Number bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(matchNumber, bonusNumber);
        Number number = Number.of(3);

        boolean actual = winningLotto.isMatchNumber(number);

        assertThat(actual).isTrue();
    }

    static Stream<Arguments> listProvide3() {
        List<Number> lottoNumber = Arrays.asList(Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(7));
        List<Number> matchNumber = Arrays.asList(Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(6));
        return Stream.of(arguments(lottoNumber, matchNumber, Number.of(7)));
    }

    @ParameterizedTest
    @MethodSource("listProvide3")
    @DisplayName("로또 매칭 결과 확인")
    public void getLottoMatchResult(List<Number> lottoNumber, List<Number> matchNumber, Number bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(matchNumber, bonusNumber);
        LottoResult lottoMatchResult = winningLotto.getLottoMatchResult(Arrays.asList(new LottoNumber(lottoNumber)));

        int actualMatchRankCount = lottoMatchResult.getMatchRankCount(Rank.SECOND);

        assertThat(actualMatchRankCount).isEqualTo(1);
    }

}