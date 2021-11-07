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

    static Stream<Arguments> isExistBonusNumberTest() {
        List<Integer> matchNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;

        List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 7);

        return Stream.of(arguments(lottoNumber, matchNumber, bonusNumber));
    }

    static Stream<Arguments> isNumberTest() {
        List<Integer> matchNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        return Stream.of(arguments(matchNumber, bonusNumber));
    }

    static Stream<Arguments> getLottoMatchResult() {
        List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> matchNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        return Stream.of(arguments(lottoNumber, matchNumber, 7));
    }

    LottoMachine lottoMachine = new LottoMachine();

    @ParameterizedTest
    @MethodSource("isExistBonusNumberTest")
    @DisplayName("로또 번호 보너스 매칭 확인")
    public void isExistBonusNumberTest(List<Integer> lottoNumber, List<Integer> matchNumber, Integer bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(lottoMachine.getLottoNumber(matchNumber),
                lottoMachine.getBonusNumber(bonusNumber));

        boolean actual = winningLotto.isExistBonusNumber(lottoMachine.getLottoNumber(lottoNumber));

        assertThat(actual).isTrue();
    }

    @ParameterizedTest
    @MethodSource("isNumberTest")
    @DisplayName("로또 번호 매칭 확인")
    public void isNumberTest(List<Integer> matchNumber, Integer bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(lottoMachine.getLottoNumber(matchNumber),
                lottoMachine.getBonusNumber(bonusNumber));
        Number number = Number.of(3);

        boolean actual = winningLotto.isMatchNumber(number);

        assertThat(actual).isTrue();
    }

    @ParameterizedTest
    @MethodSource("getLottoMatchResult")
    @DisplayName("로또 매칭 결과 확인")
    public void getLottoMatchResult(List<Integer> lottoNumber, List<Integer> matchNumber, Integer bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(lottoMachine.getLottoNumber(matchNumber),
                lottoMachine.getBonusNumber(bonusNumber));
        LottoResult lottoMatchResult = winningLotto.getLottoMatchResult(Arrays.asList(lottoMachine.getLottoNumber(lottoNumber)));

        int actualMatchRankCount = lottoMatchResult.getMatchRankCount(Rank.SECOND);

        assertThat(actualMatchRankCount).isEqualTo(1);
    }

}