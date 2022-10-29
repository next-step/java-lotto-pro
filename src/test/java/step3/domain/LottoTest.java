package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.utils.NumbersGenerator;

public class LottoTest {

    @Test
    @DisplayName("로또 생성")
    public void testGenerate() {
        Numbers random = NumbersGenerator.random();
        Lotto lotto = Lotto.generate(random);
        assertThat(lotto).isNotNull();
    }

    @Test
    @DisplayName("중복된 번호를 가진 로또 생성시 Exception 발생")
    public void testValidateError() {
        assertThatThrownBy(() -> {
            Numbers numbers = Numbers.generate(Arrays.asList(1, 1, 1, 1, 1, 1));
            Lotto.generate(numbers);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Duplicate numbers cannot input.");
    }
}
