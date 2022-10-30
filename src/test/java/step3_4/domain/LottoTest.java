package step3_4.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3_4.utils.NumbersGenerator;

public class LottoTest {

    @Test
    @DisplayName("로또 생성")
    public void testGenerate() {
        UniqueNumbers random = NumbersGenerator.random();
        Lotto lotto = Lotto.generate(random);
        assertThat(lotto).isNotNull();
    }

    @Test
    @DisplayName("번호 비교시 대상 개수가 다른 경우 Exception 발생")
    public void testNumberSizeError() {
        assertThatThrownBy(() -> {
            UniqueNumbers numbers = UniqueNumbers.generate(Arrays.asList(1, 2, 3));
            UniqueNumbers random = NumbersGenerator.random();
            Lotto lotto = Lotto.generate(random);
            lotto.getCountOfMatch(numbers);
        })
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Incomparable subject. please check lottoNumbers size.");
    }
}
