package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {
    private LottoNumbers lottoNumbers;

    @BeforeEach
    void setUp() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        lottoNumbers = LottoNumbers.valueOf(numbers);
    }

    @Test
    @DisplayName("로또 숫자 개수 확인")
    void 로또_개수_확인() {
        assertThat(lottoNumbers.getSize()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 당첨 숫자 확인")
    void 로또_당첨_숫자_확인() {
        LottoNumbers winningNumbers = LottoNumbers.valueOf(Arrays.asList(3, 4, 5, 6, 7, 8));
        assertThat(lottoNumbers.countMatchNumber(winningNumbers)).isEqualTo(4);
    }
}
