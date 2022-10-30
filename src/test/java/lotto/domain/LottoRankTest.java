package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoRankTest {


    @DisplayName("로또 랭크 값이 반환되는지 확인")
    @Test
    public void valueOf() throws Exception {
        LottoRank[] lottoRanks = LottoRank.values();

        for (LottoRank lottoRank : lottoRanks) {
            assertThat(LottoRank.valueOf(lottoRank.getCountMatch(), lottoRank.isMatchBonus())).isEqualTo(lottoRank);
        }
    }

    @DisplayName("로또 랭크 당첨되지 않은 경우 None이 반환되는지 확인")
    @ParameterizedTest()
    @ValueSource(ints = {2, 7})
    public void valueOf_null(int countOfMatch) throws Exception {
        LottoRank lottoRank = LottoRank.valueOf(countOfMatch, false);

        assertThat(LottoRank.isNone(lottoRank)).isTrue();
    }

    @DisplayName("로또 랭크가 반환되지는 확인")
    @Test
    public void reverse() throws Exception {
        List<LottoRank> reverseLottoRanks = LottoRank.reverse();
        LottoRank[] lottoRanks = LottoRank.values();

        Collections.reverse(reverseLottoRanks);

        for (int i = 0; i < lottoRanks.length - 1; i++) {
            assertThat(lottoRanks[i]).isSameAs(reverseLottoRanks.get(i));
        }
    }
}