package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @Test
    @DisplayName("로또 번호들 생성")
    void create() {
        LottoNumbers lottoNumbers = LottoNumbers.generate();
        assertThat(lottoNumbers).as(lottoNumbers.toString()).isNotNull();
    }

}
