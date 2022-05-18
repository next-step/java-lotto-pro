package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
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
                .isThrownBy(() -> new LottoNumbers(Arrays.asList("3", "7", "10", "35")))
                .withMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("로또 6개의 번호에 중복이 있는지 검증")
    @Test
    void lottoNumbers_duplication_number() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(Arrays.asList("3", "7", "10", "10", "25", "35")))
                .withMessage("[ERROR] 6개의 로또 번호에 중복이 있습니다.");
    }

    @DisplayName("LottoNumbers에 특정 LottoNumber가 있는지 확인")
    @Test
    void contains() {
        LottoNumbers lottoNumbers = new LottoNumbers((Arrays.asList("3", "7", "10", "13", "25", "35")));
        assertAll(
                () -> assertThat(lottoNumbers.contains(new LottoNumber("7"))).isTrue(),
                () -> assertThat(lottoNumbers.contains(new LottoNumber("25"))).isTrue(),
                () -> assertThat(lottoNumbers.contains(new LottoNumber("35"))).isTrue()
        );
    }

    @DisplayName("LottoNumbers에 로또 번호들이 int 배열로 변환")
    @Test
    void numberToIntArray() {
        LottoNumbers lottoNumbers = new LottoNumbers((Arrays.asList("3", "7", "10", "13", "25", "35")));
        assertThat(lottoNumbers.numberToIntArray()).isEqualTo(new int[]{3, 7, 10, 13, 25, 35});
    }

    @DisplayName("당첨로또번호와 구매 로또 번호 일치 개수 확인")
    @Test
    void matchCount() {
        LottoNumbers lottoNumbers = new LottoNumbers((Arrays.asList("3", "7", "10", "13", "25", "35")));
        LottoNumbers winningNumbers3 = new LottoNumbers((Arrays.asList("3", "7", "10", "15", "20", "37")));
        LottoNumbers winningNumbers4 = new LottoNumbers((Arrays.asList("3", "7", "10", "13", "20", "37")));
        LottoNumbers winningNumbers5 = new LottoNumbers((Arrays.asList("3", "7", "10", "13", "25", "37")));
        LottoNumbers winningNumbers6 = new LottoNumbers((Arrays.asList("3", "7", "10", "13", "25", "35")));
        assertAll(
                () -> assertThat(lottoNumbers.matchCount(winningNumbers3)).isEqualTo(3),
                () -> assertThat(lottoNumbers.matchCount(winningNumbers4)).isEqualTo(4),
                () -> assertThat(lottoNumbers.matchCount(winningNumbers5)).isEqualTo(5),
                () -> assertThat(lottoNumbers.matchCount(winningNumbers6)).isEqualTo(6)
        );
    }
}
