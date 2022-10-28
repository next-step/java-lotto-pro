package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @ParameterizedTest
    @CsvSource(value = {"6:2000000000", "5:1500000", "4:50000", "3:5000"}, delimiter = ':')
    @DisplayName("번호 일치 개수로 당첨금 구하기")
    void 일치_개수로_당첨금_구하기(int matchCount, int expected) {
        Lotto lotto = new Lotto(matchCount);
        assertThat(lotto.getPrize()).isEqualTo(expected);
    }
}
