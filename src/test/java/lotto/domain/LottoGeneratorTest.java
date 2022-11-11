package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("로또 번호 생성기")
class LottoGeneratorTest {

    @DisplayName("생성")
    @Test
    void constructor() {
        assertThatNoException().isThrownBy(() -> new LottoGenerator());
    }

    @DisplayName("구매횟수만큼 로또 번호들 리스트 생성")
    @ParameterizedTest
    @CsvSource(value = {"3000:1", "4000:1", "5000:1"}, delimiter = ':')
    void generate(int lottoMoney, int manualLottoCount) {
        assertThat(LottoGenerator.generate(new LottoMoney(lottoMoney).purchaseCount(1)).getLottos()).hasSize(lottoMoney / 1000 - manualLottoCount);
    }
}
