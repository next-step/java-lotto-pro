package lotto.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @DisplayName("로또 번호가 6개가 아닌 경우 검증")
    @Test
    void lottoNumbers_non_six_number() {
        assertThatIllegalArgumentException()
                .isThrownBy(() ->  new LottoNumbers(Arrays.asList("3", "7", "10", "35")))
                .withMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("로또 6개의 번호에 중복이 있는지 검증")
    @Test
    void lottoNumbers_duplication_number() {
        assertThatIllegalArgumentException()
                .isThrownBy(() ->  new LottoNumbers(Arrays.asList("3", "7", "10", "10", "25", "35")))
                .withMessage("[ERROR] 6개의 로또 번호에 중복이 있습니다.");
    }

}
