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
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        LottoNumber matchLotto = new LottoNumber(numbers);
        LottoNumber lotto = new LottoNumber(numbers);

        assertThat(new LottoMatch(matchLotto, lotto).isMatch(Rank.FIRST)).isTrue();
    }

    @Test
    @DisplayName("로또 당첨 등수 테스트")
    public void test() {
        LottoNumber matchNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber1 = new LottoNumber(Arrays.asList(1, 2, 3, 14, 5, 16));
        LottoNumber lottoNumber2 = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));

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