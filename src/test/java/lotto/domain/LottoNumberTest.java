package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    @DisplayName("LottoNumber 정상 생성")
    void LottoNumber_정상_생성(){
        LottoNumber lottoNumber = new LottoNumber(1);
        assertThat(lottoNumber.getNumber()).isEqualTo(1);
    }

    @ParameterizedTest(name="LottoNumber 비정상 생성: {0}")
    @ValueSource(ints = {0,46})
    void LottoNumber_비정상_생성(int num){
        assertThatThrownBy(() -> {
            LottoNumber lottoNumber = new LottoNumber(num);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
