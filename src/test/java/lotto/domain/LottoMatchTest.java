package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchTest {

    @Test
    @DisplayName("로또 1줄 당첨 등수 테스트")
    public void LottoMatch() {
        List<Number> numbers = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));

        LottoNumber matchLotto = new LottoNumber(numbers);
        LottoNumber lotto = new LottoNumber(numbers);

        assertThat(new LottoMatch(matchLotto, lotto).isMatch(Rank.FIRST)).isTrue();
    }

    @Test
    @DisplayName("로또 당첨 등수 테스트")
    public void test() {
        LottoNumber matchNumber = new LottoNumber(Arrays.asList(new Number(1), new Number(2), new Number(3),
                new Number(4), new Number(5), new Number(6)));
        LottoNumber lottoNumber1 = new LottoNumber(Arrays.asList(new Number(1), new Number(2), new Number(3),
                new Number(14), new Number(5), new Number(16)));
        LottoNumber lottoNumber2 = new LottoNumber(Arrays.asList(new Number(1), new Number(2), new Number(3),
                new Number(4), new Number(5), new Number(6)));

        LottoMatch matchLotto1 = new LottoMatch(matchNumber, lottoNumber1);
        LottoMatch matchLotto2 = new LottoMatch(matchNumber, lottoNumber2);
        MatchResult matchResult = new MatchResult(getMatch(matchLotto1, matchLotto2));

        assertThat(matchResult.getLottoMatchList().get(0).isMatch(Rank.THIRD)).isTrue();
        assertThat(matchResult.getLottoMatchList().get(1).isMatch(Rank.FIRST)).isTrue();
    }

    private List<LottoMatch> getMatch(LottoMatch matchLotto1, LottoMatch matchLotto2) {
        List<LottoMatch> matches = new ArrayList<>();
        matches.add(matchLotto1);
        matches.add(matchLotto2);
        return matches;
    }

}