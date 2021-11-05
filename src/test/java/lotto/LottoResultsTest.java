package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultsTest {

    @DisplayName("로또 결과들 생성 테스트")
    @Test
    void constructLottoResults_success() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(LottoResult.THREE, LottoResult.NONE));
        assertThat(lottoResults).isEqualTo(new LottoResults(Arrays.asList(LottoResult.THREE, LottoResult.NONE)));
    }
}
