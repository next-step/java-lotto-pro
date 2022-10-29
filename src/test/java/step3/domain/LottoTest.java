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
    public void testInputNumbersError() {
        assertThatThrownBy(() -> {
            Numbers numbers = Numbers.generate(Arrays.asList(1, 1, 1, 1, 1, 1));
            Lotto.generate(numbers);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Duplicate numbers cannot input.");
    }

    @Test
    @DisplayName("번호 비교시 대상 개수가 다른 경우 Exception 발생")
    public void testNumberSizeError() {
        assertThatThrownBy(() -> {
            Numbers numbers = Numbers.generate(Arrays.asList(1, 2, 3));
            Numbers random = NumbersGenerator.random();
            Lotto lotto = Lotto.generate(random);
            lotto.getMatchCount(numbers);
        })
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Incomparable subject. please check lottoNumbers size.");
    }
}
