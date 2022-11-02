package lotto;



import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호가 보너스로 정상 체킹 되는지 확인한다.")
    void lottoNumber_bonus_test() {
        LottoNumber lottoNumber = new LottoNumber(1,true);
        assertThat(lottoNumber.isBonus()).isTrue();
    }

    @Test
    @DisplayName("로또 번호가 보너스가 아닌 경우 정상 판단되는지 확인한다.")
    void lottoNumber_no_bonus_test() {
        LottoNumber lottoNumber = new LottoNumber(1,false);
        assertThat(lottoNumber.isBonus()).isFalse();
    }

    @Test
    @DisplayName("문자하나, boolean 하나인 생성자로 로또 번호가 보너스가 아닌 경우 정상 판단되는지 확인한다.")
    void lottoNumber_no_bonus_int1_boolean1_constructor_test() {
        LottoNumber lottoNumber = new LottoNumber("1",true);
        assertThat(lottoNumber.isBonus()).isTrue();
    }

    @Test
    @DisplayName("숫자 하나인 생성자로 로또 번호가 보너스가 아닌 경우 정상 판단되는지 확인한다.")
    void lottoNumber_no_bonus_int1_constructor_test() {
        LottoNumber lottoNumber = new LottoNumber(1);
        assertThat(lottoNumber.isBonus()).isFalse();
    }


    @Test
    @DisplayName("문자 하나인 생성자로 로또 번호가 보너스가 아닌 경우 정상 판단되는지 확인한다.")
    void lottoNumber_no_bonus_str1_constructor_test() {
        LottoNumber lottoNumber = new LottoNumber("1");
        assertThat(lottoNumber.isBonus()).isFalse();
    }
}
