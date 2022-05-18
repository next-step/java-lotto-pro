package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ManualLottoGeneratorTest {

    @Test
    void 로또_문자열을_받아_수동으로_로또를_생성한다() {
        // given
        String[] numbers = {"1, 2, 3, 4, 5, 6", "1, 3, 4, 5, 6, 7"};
        ManualLottoNumbers manualLottoNumbers = new ManualLottoNumbers(numbers);

        ManualLottoGenerator generator = new ManualLottoGenerator(manualLottoNumbers);
        // when
        Lottos result = generator.generate();
        // then
        assertThat(result.getLottos()).hasSize(2);
    }
}