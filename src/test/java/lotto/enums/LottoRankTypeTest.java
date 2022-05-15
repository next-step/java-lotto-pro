package lotto.enums;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class LottoRankTypeTest {
    @Test
    @DisplayName("LottoRankType 종류는 4가지")
    void LottoRankType_4Types(){
        assertThat(LottoRankType.rankListWithReverseOrder().size()).isEqualTo(4);
    }

    @Test
    @DisplayName("등수별 상금 검증")
    void LottoRankType_등수별_상금_검증(){
        assertThat(LottoRankType.FIRST.getPrice()).isEqualTo(2000000000);
        assertThat(LottoRankType.SECOND.getPrice()).isEqualTo(1500000);
        assertThat(LottoRankType.THIRD.getPrice()).isEqualTo(50000);
        assertThat(LottoRankType.FOURTH.getPrice()).isEqualTo(5000);
    }

    @Test
    @DisplayName("등수별 맞춘 숫자개수 검증")
    void LottoRankType_등수별_맞춘_숫자개수_검증(){
        assertThat(LottoRankType.FIRST.getMatchedCount()).isEqualTo(6);
        assertThat(LottoRankType.SECOND.getMatchedCount()).isEqualTo(5);
        assertThat(LottoRankType.THIRD.getMatchedCount()).isEqualTo(4);
        assertThat(LottoRankType.FOURTH.getMatchedCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("등수 산출 테스트")
    void LottoRankType_등수_산출_테스트(){
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9));
        Lotto lotto4 = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
        assertThat(LottoRankType.matchRankType(lotto1, winningLotto)).isEqualTo(LottoRankType.FIRST);
        assertThat(LottoRankType.matchRankType(lotto2, winningLotto)).isEqualTo(LottoRankType.SECOND);
        assertThat(LottoRankType.matchRankType(lotto3, winningLotto)).isEqualTo(LottoRankType.THIRD);
        assertThat(LottoRankType.matchRankType(lotto4, winningLotto)).isEqualTo(LottoRankType.FOURTH);
    }

}