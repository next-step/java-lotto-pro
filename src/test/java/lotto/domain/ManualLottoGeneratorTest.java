package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("수동 로또 생성 테스트")
class ManualLottoGeneratorTest {

    @ParameterizedTest(name = "{0}은 로또 번호가 될 수 없다.")
    @ValueSource(strings = {"1,22,3,2,44,55", "1, -1, 2,3,5,6", "1a,2,3ab,2,d"})
    void manual_lotto_purchase_failed(String lottoNumbers) {
        Assertions.assertThatThrownBy(() -> new ManualLottoGenerator(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

}