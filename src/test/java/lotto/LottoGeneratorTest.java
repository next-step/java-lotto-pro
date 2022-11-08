package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @Test
    public void static_factory_method_test() {
        Lotto lotto1 = LottoGenerator.generateLotto();
        Lotto lotto2 = LottoGenerator.generateLotto();

        assertThat(lotto1).isNotEqualTo(lotto2);
    }

}