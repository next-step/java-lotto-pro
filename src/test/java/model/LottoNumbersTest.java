package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @BeforeEach
    void setUp() {}

    @Test
    @DisplayName("서로 다른 로또숫자들의 매치 테스트")
    void lotto_number_generate_test() {
        LottoNumbers purchaseLotto = new LottoNumbers("1,2,3,4,5,6");
        LottoNumbers winningLotto = new LottoNumbers("1,2,3,4,8,10");

        assertThat(purchaseLotto.match(winningLotto)).isEqualTo(4);
    }
}