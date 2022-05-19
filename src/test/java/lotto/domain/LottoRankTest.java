package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @Test
    @DisplayName("valueOf 테스트")
    public void valueOf() throws Exception {
        LottoRank[] lottoRanks = LottoRank.values();

        for (LottoRank lottoRank : lottoRanks) {
            assertThat(LottoRank.valueOf(lottoRank.getCountOfMatch())).isEqualTo(lottoRank);
        }
    }

    @ParameterizedTest(name = "valueOf 테스트 null 반환")
    @ValueSource(ints = {2, 7})
    public void valueOf_null(int countOfMatch) throws Exception {
        assertThat(LottoRank.valueOf(countOfMatch)).isNull();
    }

    @Test
    @DisplayName("reverse 테스트")
    public void reverse() throws Exception {
        List<LottoRank> reverseLottoRanks = LottoRank.reverse();
        LottoRank[] lottoRanks = LottoRank.values();

        Collections.reverse(reverseLottoRanks);

        for (int i = 0; i < lottoRanks.length; i++) {
            Assertions.assertThat(lottoRanks[i]).isSameAs(reverseLottoRanks.get(i));
        }
    }
}