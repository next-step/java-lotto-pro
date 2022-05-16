package lotto.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoRankTest {
    @Test
    @DisplayName("LottoRankType 종류는 4가지")
    void LottoRankType_4Types(){
        assertThat(LottoRank.rankListWithReverseOrder().size()).isEqualTo(4);
    }

    @Test
    @DisplayName("등수별 상금 검증")
    void LottoRankType_등수별_상금_검증(){
        assertAll(
                () -> assertThat(LottoRank.FIRST.getPrice()).isEqualTo(2000000000),
                () -> assertThat(LottoRank.SECOND.getPrice()).isEqualTo(1500000),
                () -> assertThat(LottoRank.THIRD.getPrice()).isEqualTo(50000),
                () -> assertThat(LottoRank.FOURTH.getPrice()).isEqualTo(5000)
        );
    }

    @Test
    @DisplayName("등수별 맞춘 숫자개수 검증")
    void LottoRankType_등수별_맞춘_숫자개수_검증(){
        assertAll(
                () -> assertThat(LottoRank.FIRST.getMatchedCount()).isEqualTo(6),
                () -> assertThat(LottoRank.SECOND.getMatchedCount()).isEqualTo(5),
                () -> assertThat(LottoRank.THIRD.getMatchedCount()).isEqualTo(4),
                () -> assertThat(LottoRank.FOURTH.getMatchedCount()).isEqualTo(3)
        );
    }

    @Test
    @DisplayName("맞춘개수로 등수 산출")
    void LottoRankType_맞춘개수로_등수_산출(){
        assertAll(
                () -> assertThat(LottoRank.matchRank(6)).isEqualTo(LottoRank.FIRST),
                () -> assertThat(LottoRank.matchRank(5)).isEqualTo(LottoRank.SECOND),
                () -> assertThat(LottoRank.matchRank(4)).isEqualTo(LottoRank.THIRD),
                () -> assertThat(LottoRank.matchRank(3)).isEqualTo(LottoRank.FOURTH)
        );
    }

}