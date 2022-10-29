package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
            assertThat(LottoRank.valueOf(lottoRank.getCountMatch())).isEqualTo(lottoRank);
        }
    }

    @DisplayName("로또 랭크 당첨되지 않은 경우 Null이 반환되는지 확인")
    @ParameterizedTest()
    @ValueSource(ints = {2, 7})
    public void valueOf_null(int countOfMatch) throws Exception {
        assertThat(LottoRank.valueOf(countOfMatch)).isNull();
    }

    @DisplayName("로또 랭크가 반환되지는 확인")
    @Test
    public void reverse() throws Exception {
        List<LottoRank> reverseLottoRanks = LottoRank.reverse();
        LottoRank[] lottoRanks = LottoRank.values();

        Collections.reverse(reverseLottoRanks);

        for (int i = 0; i < lottoRanks.length; i++) {
            assertThat(lottoRanks[i]).isSameAs(reverseLottoRanks.get(i));
        }
    }

    @DisplayName("로또 랭크 정보가 반환되지는 확인")
    @Test
    public void rankInfo() throws Exception {
        List<LottoRank> generateRankInfo = LottoRank.generateRankInfo()
            .keySet()
            .stream()
            .collect(Collectors.toList());
        List<LottoRank> reverseLottoRanks = LottoRank.reverse();

        for (int i = 0; i < reverseLottoRanks.size(); i++) {
            assertThat(reverseLottoRanks.get(i)).isSameAs(reverseLottoRanks.get(i));
        }
    }
}