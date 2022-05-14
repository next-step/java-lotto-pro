package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    private LottoNumbers lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = new LottoNumbers((list) -> {
            Collections.swap(list, 0, 1);
        });
    }

    @Test
    void 로또_숫자들에서_오름차순으로_정렬된_로또_번호_6개를_생성할_수_있다() {
        assertThat(lottoNumbers.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
