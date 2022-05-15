package lotto.domain;

import lotto.enums.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoResultTest {
    Lottos lottos;
    LottoResult result;
    @BeforeEach
    void initialize(){
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12)));
        Lotto winningLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        lottos = new Lottos(lottoList);
        result = new LottoResult(lottos, winningLotto);
    }

    @Test
    @DisplayName("LottoResult 당첨 개수 테스트")
    void LottoResult_당첨_개수_테스트(){
        assertThat(result.winningCountByRank(LottoRank.FIRST)).isEqualTo(1);
        assertThat(result.winningCountByRank(LottoRank.SECOND)).isEqualTo(1);
        assertThat(result.winningCountByRank(LottoRank.THIRD)).isEqualTo(1);
        assertThat(result.winningCountByRank(LottoRank.FOURTH)).isEqualTo(1);
    }
}
