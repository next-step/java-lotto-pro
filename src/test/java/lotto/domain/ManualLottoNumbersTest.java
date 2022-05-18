package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ManualLottoNumbersTest {

    @Test
    void 로또_번호_배열을_lottos로_변환한다() {
        // given
        String[] numbers = {"1, 2, 3, 4, 5, 6"};
        ManualLottoNumbers manualLottoNumbers = new ManualLottoNumbers(numbers);
        // when
        Lottos result = manualLottoNumbers.convertLottos();
        // then
        assertThat(result.getLottos()).hasSize(1);
    }
}