package lotto;

import lotto.model.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("LottoGenerator는 ")
public class LottoGeneratorTest {
    @DisplayName("6개의 숫자를 만든다")
    @Test
    void validGenerateNumbers() {
        String source = "1,2,3,4,5,6";
        List<Integer> numbers = LottoGenerator.generateNumbers(source);

        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("6개가 아니면 예외를 던진다")
    @Test
    void invalidGenerateNumbers() {
        String source = "1,2,3,4,5";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoGenerator.generateNumbers(source));
    }

    @DisplayName("하나의 문자를 숫자로 변환한다")
    @Test
    void validGenerateNumber() {
        String source = "1";

        assertThat(LottoGenerator.generateNumber(source)).isEqualTo(1);
    }

    @DisplayName("문자가 숫자형이 아니라면 예외를 던진다")
    @Test
    void invalidGenerateNumber() {
        String source = "a";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoGenerator.generateNumber(source));
    }
}
