package lotto;

import lotto.model.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RadomNumberGenerator는 ")
public class RandomNumberGeneratorTest {
    @DisplayName("여러개의 LottoNumbers를 만든다")
    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    void generate(int quantity) {
        assertThat(RandomNumberGenerator.generate(quantity)).hasSize(quantity);
    }

    @DisplayName("여러개의 LottoNumbers를 만든다")
    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    void duplicate(int quantity) {
        assertThat(RandomNumberGenerator.generate(quantity)).doesNotHaveDuplicates();
    }
}