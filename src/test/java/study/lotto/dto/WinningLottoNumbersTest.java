package study.lotto.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class WinningLottoNumbersTest {
    @Test
    @DisplayName("콤마로 연결된 숫자 리스트를 입력받아 DTO를 생성합니다.")
    void 유효한_숫자_리스트() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1, 2, 3, 4, 5, 6");
        assertThat(winningLottoNumbers.getLottoNumbers()).containsExactlyElementsOf(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Nested
    @DisplayName("무효한 숫자 리스트")
    class 무효한_숫자_리스트 {
        @Test
        @DisplayName("null 을 입력받으면 IllegalArgumentException 을 발생시킨다.")
        void null_입력() {
            assertThatThrownBy(() -> new WinningLottoNumbers(null)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("빈 문자열을 입력받으면 IllegalArgumentException 을 발생시킨다.")
        void 공백_입력() {
            assertThatThrownBy(() -> new WinningLottoNumbers("")).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("콤마로 연결된 숫자 리스트가 아닌 경우 IllegalArgumentException 을 발생시킨다.")
        void 콤마로_연결된_숫자_리스트가_아닌_경우() {
            assertThatThrownBy(() -> new WinningLottoNumbers("a1;44,23,15,7,2")).isInstanceOf(
                    IllegalArgumentException.class);
        }
    }
}
