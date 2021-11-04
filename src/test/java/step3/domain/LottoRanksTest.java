package step3.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRanksTest {

    @Test
    void create() {
        assertThat(new LottoRanks()).isEqualTo(new LottoRanks());
    }

    @Test
    @DisplayName("5개번호 일치에 대한 출력을 검증합니다.")
    void lottoRanks_toString() {
        int matchCount = 5;
        LottoRanks lottoRanks = new LottoRanks();
        lottoRanks.matchOfMatchCount(matchCount);
        assertThat(lottoRanks.toString()).contains("5개 일치 (1500000원)- 1개");
    }
}
