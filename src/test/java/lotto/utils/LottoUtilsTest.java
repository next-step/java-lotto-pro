package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoUtilsTest {

    @Test
    @DisplayName("LottoUtils 정상 반환")
    public void LottoUtils_정상반환() {
        String str = "10, 20, 30,40, 50";
        assertThat(LottoUtils.stringToLottoNumbers(str)).containsExactly(10, 20, 30, 40, 50);
    }

    @Test
    @DisplayName("LottoUtils 숫자가 아닌 값 입력 시, 에러 발생")
    public void LottoUtils_비숫자_에러_발생() {
        assertThatThrownBy(() -> {
            String str = "a, b, 30,40, 50";
            LottoUtils.stringToLottoNumbers(str);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
