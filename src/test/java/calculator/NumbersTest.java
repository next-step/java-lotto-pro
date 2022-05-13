package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumbersTest {

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-3"})
    void numbers_객체는_음수를_입력하면_오류를_반환한다(String input) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Numbers(new String[]{input}))
                .withMessageContaining("음수는 입력할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "&", "값"})
    void numbers_객체는_숫자가_아닌_값을_입력하면_오류를_반환한다(String input) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Numbers(new String[]{input}))
                .withMessageContaining("유효한 숫자를 입력하세요.");
    }

    @Test
    void numbers_객체는_숫자_배열의_합을_반환한다() {
        // given
        Numbers numbers = new Numbers(new String[]{"1", "2", "3"});

        // when
        int sum = numbers.sumNumbers();

        // then
        assertThat(sum).isEqualTo(6);
    }
}
