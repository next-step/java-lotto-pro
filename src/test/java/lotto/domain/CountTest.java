package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exception.LottoException;

public class CountTest {

    @DisplayName("로또 개수 생성")
    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void constructCount_success(int num) {
        Count count = new Count(num);
        assertThat(count).isEqualTo(new Count(num));
    }

    @DisplayName("음수로 로또 개수 생성 시 에러")
    @Test
    void throwsError_whenNegativeCount() {
        assertThatExceptionOfType(LottoException.class)
            .isThrownBy(() -> new Count(-1))
            .withMessage("로또 티켓 갯수는 양수여야 합니다.");
    }

    @DisplayName("입력받은 숫자보다 큰 개수인지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,false", "3,false"})
    void isBiggerThan(int count, boolean result) {
        assertThat(new Count(2).isBiggerThan(count)).isEqualTo(result);
    }

    @DisplayName("입력받은 숫자보다 큰 개수 class인지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,false", "3,false"})
    void isBiggerThanCount(int count, boolean result) {
        assertThat(new Count(2).isBiggerThan(new Count(count))).isEqualTo(result);
    }
}
