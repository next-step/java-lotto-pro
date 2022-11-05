package step3;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.LottoNumber;

public class LottoNumberTest {
    @Test
    @DisplayName("로또 숫자 생성")
    public void lotto_number() {
        LottoNumber lottoNumber = new LottoNumber("1");
        assertThat(lottoNumber.getNumber()).isEqualTo(1);
        LottoNumber lottoNumber45 = new LottoNumber("45");
        assertThat(lottoNumber45.getNumber()).isEqualTo(45);
    }

    @Test
    @DisplayName("1부터 45 외의 숫자 예외처리")
    public void lotto_number_1_to_45() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber("0"))
                .withMessageContaining("1부터 45까지의 숫자");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber("46"))
                .withMessageContaining("1부터 45까지의 숫자");
    }

    @Test
    @DisplayName("같은 숫자인지 체크")
    public void lotto_isEquals() {
        LottoNumber lottoNumber = new LottoNumber("1");
        LottoNumber compareNumber = new LottoNumber("1");
        assertThat(lottoNumber.equals(compareNumber)).isTrue();
    }

}
