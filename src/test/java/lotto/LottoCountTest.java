package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoCountTest {

    @DisplayName("로또 개수 생성")
    @Test
    void constructLottoCount_success() {
        LottoCount lottoCount = new LottoCount(2);
        assertThat(lottoCount).isEqualTo(new LottoCount(2));
    }

    @DisplayName("입력받은 숫자보다 큰 로또개수인지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,false", "3,false"})
    void isBiggerThan(int count, boolean result) {
        assertThat(new LottoCount(2).isBiggerThan(count)).isEqualTo(result);
    }
}
