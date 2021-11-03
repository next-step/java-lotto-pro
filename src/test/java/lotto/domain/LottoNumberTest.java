package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호 생성 확인")
    public void generateNumbers() {
        LottoNumber lottoNumber = new LottoNumber();
        assertThat(lottoNumber.getLottoNumbers().size()).isEqualTo(6);
    }

}