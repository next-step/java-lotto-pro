package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exception.LottoException;

public class LottoCountTest {

    @DisplayName("로또 개수 생성")
    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void constructLottoCount_success(int count) {
        LottoCount lottoCount = new LottoCount(count);
        assertThat(lottoCount).isEqualTo(new LottoCount(count));
    }

    @DisplayName("로또 개수 생성")
    @Test
    void throwsError_whenNegativeLottoCount() {
        assertThatExceptionOfType(LottoException.class)
            .isThrownBy(() -> new LottoCount(-1))
            .withMessage("로또 티켓 갯수는 양수여야 합니다.");
    }

    @DisplayName("입력받은 숫자보다 큰 로또개수인지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,false", "3,false"})
    void isBiggerThan(int count, boolean result) {
        assertThat(new LottoCount(2).isBiggerThan(count)).isEqualTo(result);
    }
}
