package lotto.domain.factory;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoFactoryTest {

    @Test
    @DisplayName("로또번호 문자열을 입력받아 Lotto 객체를 반환한다")
    void create() {
        assertThat(LottoFactory.create("1, 2, 3, 4, 5, 6")).isEqualTo(
                new Lotto(Arrays.asList(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(3),
                        LottoNumber.of(4),
                        LottoNumber.of(5),
                        LottoNumber.of(6))));
    }

    @Test
    @DisplayName("랜덤 로또 번호 6개를 가진 Lotto 객체를 반환한다")
    void createAuto() {
        assertThat(LottoFactory.createAuto().getValues()).hasSize(6);
    }

    @Test
    @DisplayName("숫자, 공백 및 문자 , 외 입력시 예외가 발생한다")
    void createWrongInput() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoFactory.create("a"))
                .withMessage("숫자, 공백 및 문자 , 만 사용 가능합니다.");
    }
}
