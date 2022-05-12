package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("LottoGenerator는 ")
public class LottoGeneratorTest {
    @DisplayName("6개의 숫자를 만든다")
    @Test
    void validGenerate(){
        String source = "1,2,3,4,5,6";
        List<Integer> numbers = LottoGenerator.generate(source);

        assertThat(numbers).containsExactly(1,2,3,4,5,6);
    }

    @DisplayName("6개가 아니면 예외를 던진다")
    @Test
    void invalidGenerate(){
        String source = "1,2,3,4,5";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoGenerator.generate(source));
    }
}
