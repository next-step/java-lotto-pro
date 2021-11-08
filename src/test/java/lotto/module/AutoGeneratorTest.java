package lotto.module;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoGeneratorTest {

    @Test
    @DisplayName("자동 번호 생성으로 로또 번호 생성")
    public void autoLottoNumberGenerateTest() {
        assertThat(new AutoGenerator(5).createLottos().size())
                .isEqualTo(5);
    }
}
