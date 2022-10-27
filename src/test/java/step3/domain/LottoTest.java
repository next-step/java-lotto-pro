package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.utils.LottoNumbersGenerator;

public class LottoTest {

    @Test
    @DisplayName("로또 생성")
    public void testGenerate() {
        Numbers random = LottoNumbersGenerator.random();
        Lotto lotto = Lotto.generate(random);
        assertThat(lotto).isNotNull();
    }
}
