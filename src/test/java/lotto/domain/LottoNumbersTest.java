package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoNumbersTest {
    @Test
    @DisplayName("1~45 의 로또 번호 목록을 저장하는 일급컬렉션이 생성된다.")
    void checkLottoNumbers() {
        assertAll(
            () -> assertThat(LottoNumbers.LOTTO_NUMBERS.size()).isEqualTo(45),
            () -> {
                List<LottoNumber> lottoNumbers = new ArrayList<>(LottoNumbers.LOTTO_NUMBERS);
                Collections.sort(lottoNumbers);
                assertThat(lottoNumbers.get(0).getLottoNumber()).isEqualTo(1);
                assertThat(lottoNumbers.get(lottoNumbers.size() - 1).getLottoNumber()).isEqualTo(45);
            }
        );
    }
}
