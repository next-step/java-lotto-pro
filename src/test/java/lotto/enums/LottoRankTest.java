package lotto.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoRankTest {
    @Test
    @DisplayName("LottoRankType 종류는 5가지")
    void LottoRankType_4Types(){
        assertThat(LottoRank.rankListWithReverseOrder().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("등수별 상금 검증")
    void LottoRank_등수별_상금_검증(){
        assertAll(
                () -> assertThat(LottoRank.FIRST.getPrize()).isEqualTo(2_000_000_000),
                () -> assertThat(LottoRank.SECOND.getPrize()).isEqualTo(30_000_000),
                () -> assertThat(LottoRank.THIRD.getPrize()).isEqualTo(1_500_000),
                () -> assertThat(LottoRank.FOURTH.getPrize()).isEqualTo(50_000),
                () -> assertThat(LottoRank.FIFTH.getPrize()).isEqualTo(5_000)
        );
    }

    @Test
    @DisplayName("등수별 맞춘 숫자개수 검증")
    void LottoRank_등수별_맞춘_숫자개수_검증(){
        assertAll(
                () -> assertThat(LottoRank.FIRST.getMatchedCount()).isEqualTo(6),
                () -> assertThat(LottoRank.SECOND.getMatchedCount()).isEqualTo(5),
                () -> assertThat(LottoRank.THIRD.getMatchedCount()).isEqualTo(5),
                () -> assertThat(LottoRank.FOURTH.getMatchedCount()).isEqualTo(4),
                () -> assertThat(LottoRank.FIFTH.getMatchedCount()).isEqualTo(3)
        );
    }

    @Test
    @DisplayName("맞춘개수로 등수 산출")
    void LottoRank_맞춘개수로_등수_산출(){
        assertAll(
                () -> assertThat(LottoRank.valueOf(6, false)).isEqualTo(LottoRank.FIRST),
                () -> assertThat(LottoRank.valueOf(5, true)).isEqualTo(LottoRank.SECOND),
                () -> assertThat(LottoRank.valueOf(5, false)).isEqualTo(LottoRank.THIRD),
                () -> assertThat(LottoRank.valueOf(4, false)).isEqualTo(LottoRank.FOURTH),
                () -> assertThat(LottoRank.valueOf(3, false)).isEqualTo(LottoRank.FIFTH)
        );
    }

    @Test
    @DisplayName("보너스볼 매치 테스트")
    void LottoRank_보너스볼_매치(){
        assertAll(
                () -> assertThat(LottoRank.FIRST.bonusBallMatched()).isFalse(),
                () -> assertThat(LottoRank.SECOND.bonusBallMatched()).isTrue(),
                () -> assertThat(LottoRank.THIRD.bonusBallMatched()).isFalse(),
                () -> assertThat(LottoRank.FOURTH.bonusBallMatched()).isFalse(),
                () -> assertThat(LottoRank.FIFTH.bonusBallMatched()).isFalse()
        );
    }
}