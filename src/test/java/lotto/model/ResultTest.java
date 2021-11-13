package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    private WinningLotto winLotto;
    private Lottos lottos;
    private Result result;
    private Lotto fifth;
    private Lotto miss;

    @BeforeEach
    void setUp() {
        Lotto first = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto second = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto third = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        Lotto fourth = new Lotto(Arrays.asList(1, 2, 3, 5, 8, 9));
        fifth = new Lotto(Arrays.asList(1, 2, 5, 8, 9, 10));
        miss = new Lotto(Arrays.asList(1, 5, 8, 9, 10, 45));
        winLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(7));
        lottos = new Lottos(Arrays.asList(first, second, third, fourth, fifth, miss));
        result = new Result(lottos, winLotto);
    }

    @DisplayName("수익률 결과")
    @Test
    void yieldResult() {
        assertThat(result.yield(lottos.size())).isEqualTo("338592.50");

        lottos = new Lottos(Arrays.asList(fifth, miss));
        result = new Result(lottos, winLotto);
        assertThat(result.yield(lottos.size())).isEqualTo("2.50");
    }

    @DisplayName("로또를 얼만큼 맞췄는지 확인 하는 기능 검증")
    @Test
    void matchResult() {
        String when = result.getMatchResult().toString();
        assertThat(when).isEqualTo("{FIFTH=1, FOURTH=1, THIRD=1, SECOND=1, FIRST=1}");
    }
}
