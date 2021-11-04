package lotto.module;

import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoGeneratorTest {

    @Test
    public void createTest() {
        assertThat(AutoGenerator.getInstance().createLotto())
                .isInstanceOf(LottoNumbers.class);
    }
}
