package stringadder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositiveIntTest {
    @DisplayName("값이 같으면 동일한 객체이다.")
    @Test
    void 동일성() {
        final PositiveInt one = new PositiveInt(1);
        final PositiveInt another = new PositiveInt(1);

        assertThat(one).isEqualTo(another);
    }

    @DisplayName("음수로 생성할 수 없다.")
    @Test
    void 음수_유효성() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PositiveInt(-1))
                .withMessageStartingWith("음수가 아니어야 합니다.");
    }

    @DisplayName("문자열에서 양수를 파싱할 수 있다.")
    @Test
    void 문자열_파싱() {
        final PositiveInt expected = new PositiveInt(2);
        final PositiveInt actual = PositiveInt.parse("2");

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("ZERO는 0이다.")
    @Test
    void ZERO는_0이다() {
        assertThat(PositiveInt.ZERO).isEqualTo(new PositiveInt(0));
    }

    @DisplayName("양수끼리 더할 수 있다.")
    @Test
    void 더하기() {
        final PositiveInt a = new PositiveInt(1);
        final PositiveInt b = new PositiveInt(2);
        final PositiveInt expectedSum = new PositiveInt(3);

        final PositiveInt actualSum = a.plus(b);

        assertThat(actualSum).isEqualTo(expectedSum);
    }

    @DisplayName("정수로 변환할 수 있다.")
    @Test
    void 정수로_변환할_수_있다() {
        final PositiveInt positiveInt = new PositiveInt(3);

        assertThat(positiveInt.toInt()).isEqualTo(3);
    }
}
