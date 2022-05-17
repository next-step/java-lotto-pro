package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {
    @Test
    @DisplayName("1~45의 캐싱된 로또 번호를 가져온다")
    void caching() {
        for (int i = 1; i <= 45; i++) {
            assertThat(LottoNumber.of(i).getLottoNumber()).isEqualTo(i);
        }
    }

    @ParameterizedTest
    @DisplayName("로또번호 정상범위(1~45) 이외의 값을 입력 받으면 예외가 발생한다")
    @ValueSource(ints = {0, -1, 46, 47, 100})
    void outOfLottoNumberRangeException(int wrongLottoNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(wrongLottoNumber))
                .withMessage("잘못된 로또 번호입니다");
    }
}
