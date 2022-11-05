package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    LottoResult result;
    Lottos lottos;
    LottoNumber lottoNumber;

    @BeforeEach
    void init() {
      List<Lotto> lottoList = new ArrayList<>();
      lottoList.add(new Lotto(Arrays.asList(1,10,20,35,38,41)));
      lottoList.add(new Lotto(Arrays.asList(1,3,10,20,35,38)));
      lottoList.add(new Lotto(Arrays.asList(1,10,20,35,38,45)));
      lottoList.add(new Lotto(Arrays.asList(1,10,20,35,40,45)));
      lottoList.add(new Lotto(Arrays.asList(1,10,20,36,42,44)));
      lottoList.add(new Lotto(Arrays.asList(1,10,22,36,42,44)));
      Lotto winLotto = new Lotto(Arrays.asList(1,10,20,35,38,41));
      lottos = new Lottos(lottoList);
      lottoNumber = new LottoNumber(3);
      result = new LottoResult(lottos, winLotto, 6000,lottoNumber);
    }

    @Test
    @DisplayName("LottoResult 당첨 개수 반환")
    public void LottoResult_match_Type() {
        assertThat(result.getRewardMapCount(Rank.FIRST)).isEqualTo(1);
        assertThat(result.getRewardMapCount(Rank.SECOND)).isEqualTo(1);
        assertThat(result.getRewardMapCount(Rank.THIRD)).isEqualTo(1);
        assertThat(result.getRewardMapCount(Rank.FOURTH)).isEqualTo(1);
        assertThat(result.getRewardMapCount(Rank.FIFTH)).isEqualTo(1);
        assertThat(result.getRewardMapCount(Rank.MISS)).isEqualTo(1);
    }

    @Test
    @DisplayName("LottoResult 수익률 테스트")
    void LottoResult_수익률_테스트(){
        assertThat(result.getTotalProfit()).isEqualTo(
                (double) (Rank.FIRST.getWinningMoney()
                        + Rank.SECOND.getWinningMoney()
                        + Rank.THIRD.getWinningMoney()
                        + Rank.FOURTH.getWinningMoney()
                        + Rank.FIFTH.getWinningMoney()) / (lottos.size() * 1000)
        );

    }
}
