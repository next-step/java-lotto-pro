package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersGeneratorTest {
    @Test
    @DisplayName("로또 숫자는 생성되어야 하고 그 크기는 6이어야 한다")
    void create_in_range() {
        NumbersGenerator generator = new LottoNumbersGenerator();
        List<Integer> lottoNumbers = generator.generate();
        assertThat(lottoNumbers).hasSize(6);
    }
}
