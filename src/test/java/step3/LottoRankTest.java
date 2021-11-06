package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step3.domain.LottoRank;

public class LottoRankTest {

    @ParameterizedTest
    @CsvSource(value = {
        "6:False:FIRST",
        "5:False:THIRD",
        "4:False:FOURTH",
        "3:False:FIFTH",
        "0:False:NONE",
        "6:True:FIRST",
        "5:True:SECOND", // 2등 보너스
        "4:True:FOURTH",
        "3:True:FIFTH",
        "0:True:NONE",
    }, delimiter = ':')
    @DisplayName("LottoRank 랭킹별 상금 테스트")
    void valueOf_prize_matching(int matchCount, boolean isBonus, String expected) {
        // given

        // when
        LottoRank lottoRank = LottoRank.valueOf(matchCount, isBonus);

        //then
        assertThat(lottoRank.name()).isEqualTo(expected);
    }
}
