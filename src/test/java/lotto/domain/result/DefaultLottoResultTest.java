package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.matcher.count.MatchCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DefaultLottoResultTest {

    DefaultLottoResult lottoResult = new DefaultLottoResult();

    @ParameterizedTest
    @DisplayName("보너스볼 없이 맞췄을 경우 이익")
    @CsvSource(value = {"3:0", "4:5000", "5:50000", "6:30000000"}, delimiter = ':')
    void totalProfit_bonus(int matchCount, int expected) {
        lottoResult.calculateTotalCount(new MatchCount(matchCount, true));
        assertThat(lottoResult.totalProfit()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("보너스볼 없이 맞췄을 경우 이익")
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    void totalProfit_no_bonus(int matchCount, int expected) {
        lottoResult.calculateTotalCount(new MatchCount(matchCount, false));
        assertThat(lottoResult.totalProfit()).isEqualTo(expected);
    }

}
