package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ManualLottoInputTest {

    @Test
    @DisplayName("입력받은 문자열은 ,로 구분된 숫자들로 이루어진다.")
    void createManualLottoInput() {
        ManualLottoInput input = ManualLottoInput.create("1,2,3,4,5,6");
        assertThat(input.convertIntegers()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("입력받은 문자열에 ,를 제외하고 숫자 외 문자가 올 수 없습니다.")
    void validateOnlyNumber() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> ManualLottoInput.create("1,2,3,가,a,!")
        );
    }

    @Test
    @DisplayName("숫자가 6개가 아니면 예외를 발생시킨다.")
    void sizeExceptionTest(){
        assertThatIllegalArgumentException().isThrownBy(
                () -> ManualLottoInput.create("1,2,3,4,5,6,7")
        );
    }

    @Test
    @DisplayName("숫자가 중복되면 예외를 발생시킨다.")
    void duplicateExceptionTest(){
        assertThatIllegalArgumentException().isThrownBy(
                () -> ManualLottoInput.create("1,2,3,4,6,6")
        );
    }
}

