package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CountTest {
    @DisplayName("0이상의 숫자를 입력받는다")
    @Test
    void createTest() {
        assertThat(new Count(0)).isEqualTo(new Count(0));
    }

    @DisplayName("음수를 넣으면 에러를 발생한다")
    @Test
    void invalidCreateTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Count(-1));
    }

    @DisplayName("숫자가 줄어든지 여부를 확인할수 있다.")
    @Test
    void isDecreaseTest() {
        assertThat(new Count(1).isDecrease()).isTrue();
        assertThat(new Count(0).isDecrease()).isFalse();
    }

    @DisplayName("숫자가 줄어들면 새로운 Count 값을 넘겨준다")
    @Test
    void decreaseTest() {
        assertThat(new Count(1).decrease()).isEqualTo(new Count(0));
    }
}
