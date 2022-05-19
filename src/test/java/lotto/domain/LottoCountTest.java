package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoCountTest {
    @Test
    @DisplayName("LottoCount 정상 생성 테스트")
    void LottoCount_생성_테스트() {
        LottoCount lottoCount = new LottoCount(10);
        assertThat(lottoCount.getCount()).isEqualTo(10);
    }

    @Test
    @DisplayName("LottoCount 비정상 생성 테스트")
    void LottoCount_비정상_생성_테스트() {
        assertThatThrownBy(() -> {
            LottoCount lottoCount = new LottoCount(-10);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("LottoCount 비교 테스트")
    void LottoCount_비교_테스트() {
        LottoCount lottoCount1 = new LottoCount(10);
        LottoCount lottoCount2 = new LottoCount(20);
        assertThat(lottoCount1.isLessThan(lottoCount2)).isTrue();
    }
}
