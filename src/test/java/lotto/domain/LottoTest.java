package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("6자리의 로또 번호 생성")
    void create_lotto_test() {
        List<LottoNumber> lottoNumbers = Lotto.autoLotto();
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}
