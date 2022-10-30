package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @Test
    @DisplayName("로또 번호들 생성")
    void create() {
        LottoNumbers lottoNumbers = LottoNumbers.generate();
        assertThat(lottoNumbers).as(lottoNumbers.toString()).isNotNull();
    }

    @Test
    @DisplayName("텍스트 번호들을 입력받아 생성")
    void generate_번호를_글자로_입력() {
        assertThat(LottoNumbers.generate("1,2,3,4,5,6")).isEqualTo(LottoNumbers.generate("1,2,3,4,5,6"));
    }

    @Test
    @DisplayName("숫자 번호 리스트를 입력받아 생성")
    void generate_호를_숫자리스트로_입력() {
        assertThat(LottoNumbers.generate(Arrays.asList(1,2,3,4,5,6))).isEqualTo(LottoNumbers.generate("1,2,3,4,5,6"));
    }

}
