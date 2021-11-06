package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.LottoNumber.GAME_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LottoResultTest {

    static Stream<Arguments> listProvide() {
        List<Number> lottoNumber = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(7));
        List<Number> matchNumber = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
        return Stream.of(arguments(lottoNumber, matchNumber, new Number(7)));
    }

    @ParameterizedTest
    @MethodSource("listProvide")
    @DisplayName("로또 수익률 확인")
    public void lottoTest(List<Number> lottoNumber, List<Number> matchNumber, Number bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(matchNumber, bonusNumber);
        LottoNumber lotto = new LottoNumber(lottoNumber);

        LottoResult lottoMatchResult = winningLotto.getLottoMatchResult(Arrays.asList(lotto));
        int exceptedMoney = Rank.SECOND.getPrizeMoney();
        int purchaseMoney = 1 * GAME_PRICE;

        assertThat(lottoMatchResult.getLottoYield()).isEqualTo(exceptedMoney / purchaseMoney);
    }

    static Stream<Arguments> listProvide2() {
        List<Number> lottoNumber = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(7));
        List<Number> matchNumber = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
        return Stream.of(arguments(lottoNumber, matchNumber, new Number(7)));
    }

    @ParameterizedTest
    @MethodSource("listProvide2")
    @DisplayName("로또 번호 보너스 매칭 확인")
    public void activeLottoBonus(List<Number> lottoNumber, List<Number> matchNumber, Number bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(matchNumber, bonusNumber);
        LottoNumber lotto = new LottoNumber(lottoNumber);

        LottoResult lottoMatchResult = winningLotto.getLottoMatchResult(Arrays.asList(lotto));
        int matchRankCount = lottoMatchResult.getMatchRankCount(Rank.SECOND);

        assertThat(matchRankCount).isEqualTo(1);
    }



}
