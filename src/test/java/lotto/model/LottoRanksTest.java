package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRanksTest {
    private List<LottoRank> lottoRankList;

    @BeforeEach
    void setUp() {
        lottoRankList = Arrays.asList(LottoRank.FIRST, LottoRank.SECOND, LottoRank.FIFTH, LottoRank.FIRST);
    }

    @Test
    @DisplayName("입력 받은 로또 등급들을 설정")
    void setLottoRanks() {
        assertThat(LottoRanks.of(lottoRankList)).isNotNull();
    }

    @Test
    @DisplayName("입력 받은 로또 등급들을 결과 반환")
    void getResultLottoRanks() {
        LottoRanks lottoRanks = LottoRanks.of(lottoRankList);
        Map<LottoRank, Long> result = lottoRanks.resultLottoRanks();

        assertAll(
                () -> assertEquals(2, result.get(LottoRank.FIRST)),
                () -> assertEquals(1, result.get(LottoRank.SECOND)),
                () -> assertEquals(1, result.get(LottoRank.FIFTH))
        );
    }
}
