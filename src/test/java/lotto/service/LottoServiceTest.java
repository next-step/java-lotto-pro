package lotto.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    LottoService lottoService = new LottoService();

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "14900:14", "14100:14", "13900:13", "15100:15"}, delimiter = ':')
    void 구입_가능한_로또_갯수_조회(int amount, int expectedCount) {
        // given, when
        int count = lottoService.countPurchasableLotto(amount);

        // then
        assertThat(count).isEqualTo(expectedCount);
    }
}
