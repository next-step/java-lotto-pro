package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    @DisplayName("보너스 숫자 생성 테스트")
    @Test
    void constructBonusNumber() {
        BonusNumber bonusNumber = new BonusNumber(new LottoNumber(1));
        assertThat(bonusNumber).isEqualTo(new BonusNumber(new LottoNumber(1)));
    }

    @DisplayName("보너스 번호인지 확인")
    @Test
    void isBonus_true() {
        BonusNumber bonusNumber = new BonusNumber(new LottoNumber(1));
        assertThat(bonusNumber.isBonus(new LottoNumber(1))).isEqualTo(true);
    }

    @DisplayName("보너스 번호가 아닌지 확인")
    @Test
    void isBonus_success() {
        BonusNumber bonusNumber = new BonusNumber(new LottoNumber(1));
        assertThat(bonusNumber.isBonus(new LottoNumber(2))).isEqualTo(false);
    }
}
