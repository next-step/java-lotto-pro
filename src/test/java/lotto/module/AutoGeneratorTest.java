package lotto.module;

import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoGeneratorTest {

    @Test
    @DisplayName("자동 번호 생성으로 로또 번호 생성")
    public void createTest() {
        assertThat(AutoGenerator.getInstance().createLotto())
                .isInstanceOf(LottoNumbers.class);
    }
}
