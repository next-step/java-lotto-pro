package model;

import exception.LottoNumberDuplicationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("정상적으로 로도 번호를 추가시키는 테스트")
    void add_bonus_ball_success_test() {
        LottoNumbers purchaseLotto = new LottoNumbers("1,2,3,4,5,6");

        purchaseLotto.addBonusBall(new LottoNumber("7"));

        assertThat(purchaseLotto.equalsBonusBall(new LottoNumber("7"))).isTrue();
    }

    @Test
    @DisplayName("중복된 값을 추가시 에러를 발생시키는 테스트")
    void lotto_number_add_duplication_exception_test() {
        LottoNumbers purchaseLotto = new LottoNumbers("1,2,3,4,5,6");

        assertThatThrownBy(() -> purchaseLotto.addBonusBall(new LottoNumber("3")))
                .isInstanceOf(LottoNumberDuplicationException.class);
    }
}