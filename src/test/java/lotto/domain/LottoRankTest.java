package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoRankTest {

    @Test
    @DisplayName("valueOf 테스트")
    public void valueOf() {
        LottoRank[] lottoRanks = LottoRank.values();

        for (LottoRank lottoRank : lottoRanks) {
            assertThat(LottoRank.valueOf(lottoRank.getCountOfMatch(), lottoRank.isMatchBonus()))
                    .isEqualTo(lottoRank);
        }
    }

    @ParameterizedTest(name = "valueOf 테스트 null 반환")
    @ValueSource(ints = {2, 7})
    public void valueOf_null(int countOfMatch) {
        assertAll(
                () -> assertThat(LottoRank.valueOf(countOfMatch, false)).isEqualTo(LottoRank.MISS),
                () -> assertThat(LottoRank.valueOf(countOfMatch, true)).isEqualTo(LottoRank.MISS)
        );
    }

    @Test
    @DisplayName("reverse 테스트")
    public void reverse() {
        List<LottoRank> reverseLottoRanks = LottoRank.reverse();
        List<LottoRank> lottoRanks = new ArrayList<>(Arrays.asList(LottoRank.values()));
        lottoRanks.remove(LottoRank.MISS);

        Collections.reverse(reverseLottoRanks);

        for (int i = 0; i < lottoRanks.size(); i++) {
            Assertions.assertThat(lottoRanks.get(i)).isSameAs(reverseLottoRanks.get(i));
        }
    }
}