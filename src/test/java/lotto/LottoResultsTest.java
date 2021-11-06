package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultsTest {
    @DisplayName("로또 결과들 중 6개 다 맞춘 순위의 개수 테스트")
    @Test
    void getLottoResults() {
        List<LottoResult> lottoResultArr = Arrays.asList(new LottoResult(3), new LottoResult(6));
        LottoResults lottoResults = new LottoResults(lottoResultArr);
        assertThat(lottoResults.getMatchAmount(6)).isEqualTo(1);
    }
}
