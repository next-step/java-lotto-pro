package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @Test
    public void make_lottoNumber() {
        //given
        LottoNumber expectedLottoNumber = new LottoNumber(1);
        //when
        LottoNumber actualLottoNumber = new LottoNumber(1);
        //then
        assertThat(actualLottoNumber).isEqualTo(expectedLottoNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 46})
    public void make_outOfBound(int value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new LottoNumber(value));
    }
}