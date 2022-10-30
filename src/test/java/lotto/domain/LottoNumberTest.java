package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @Test
    @DisplayName("단일 로또번호 생성")
    void create() {
        LottoNumber lottoNumber = LottoNumber.of(1);
        assertThat(LottoNumber.of("1")).isEqualTo(lottoNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("0, 46은 정상 범위의 단일 로또번호가 아니다.")
    void outOfRange(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumber.of(number);
        });
    }
}
