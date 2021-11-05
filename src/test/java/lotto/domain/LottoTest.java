package lotto.domain;

import lotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또 매치 개수 확인")
    public void lottoTest() {
        Lotto lotto = new Lotto(Arrays.asList(Rank.of(6, false),
                Rank.of(6, false), Rank.of(6, false)));

        assertThat(lotto.getMatchRankCount(Rank.FIRST)).isEqualTo(3);
    }

    @Test
    @DisplayName("수익률 확인")
    public void lottoYieldTest() {
        Lotto lotto = new Lotto(getTestData());

        assertThat(lotto.getLottoYield()).isEqualTo(0.357);
    }

    @Test
    @DisplayName("수익률 메세지 확인")
    public void lottoYieldTest2() {
        Lotto lotto = new Lotto(getTestData());

        double lottoYield = lotto.getLottoYield();

        assertThat(
                "총 수익률은 " + lottoYield + "입니다."
                        + (lottoYield < 1 ? "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" : "")
        ).contains("0.357", "손해");
    }

    public List<Rank> getTestData() {
        return Arrays.asList(
                Rank.of(3, false), Rank.of(0, false),
                Rank.of(0, false), Rank.of(0, false),
                Rank.of(0, false), Rank.of(0, false),
                Rank.of(0, false), Rank.of(0, false),
                Rank.of(0, false), Rank.of(0, false),
                Rank.of(0, false), Rank.of(0, false),
                Rank.of(0, false), Rank.of(0, false)
                );
    }

}
