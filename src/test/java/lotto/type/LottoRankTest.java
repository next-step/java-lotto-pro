package lotto.type;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @Test
    @DisplayName("맞춘 개수에 따라 로또 등수를 출력")
    void 맞춘_숫자에_따른_로또등수_출력() {
        LottoRank lottoRank = LottoRank.rankMatch(3, true).get();
        assertEquals(lottoRank, LottoRank.THREE);
    }

}
