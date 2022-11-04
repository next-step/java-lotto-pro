package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoNumberTest {
    @Test
    void LottoNumber_int_생성() {
        assertThat(LottoNumber.from(1)).isEqualTo(LottoNumber.from(1));
    }

    @Test
    void LottoNumber_String_생성() {
        assertThat(LottoNumber.from("1")).isEqualTo(LottoNumber.from("1"));
    }
}
