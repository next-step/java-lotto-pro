package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoNumbersTest {

    @Test
    void createNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1,2,3,4,5,6));
        assertThat(lottoNumbers)
                .usingRecursiveComparison()
                .isEqualTo(new LottoNumbers(Arrays.asList(1,2,3,4,5,6)));
    }

    @DisplayName("숫자 값이 6개가 아닐 경우, 중복 값이 있을 경우")
    @Test
    void createNumbers_예외처리() {
        assertAll(
                () -> assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(1,2,3,4,5,6,7))).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(1,2,3,4,5))).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(1,2,3,4,5,5))).isInstanceOf(IllegalArgumentException.class)
        );
    }

}
