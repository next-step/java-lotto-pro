package step3.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {
    @DisplayName("로또번호 객체의 동등성 테스트.")
    @Test
    void 로또번호_같은_객체_확인() {
        Assertions.assertThat(LottoNumber.of(1)).isEqualTo(LottoNumber.of(1));
    }

    @ParameterizedTest(name = "로또번호의 범위는 1~45의 숫자만 허용된다. ({0})")
    @ValueSource(ints = {0, 46, -1})
    void invalid_로또번호_범위(int source) {
        assertThatThrownBy(() -> {
            LottoNumber.of(source);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~45의 숫자만 입력해주세요.");
    }
}
