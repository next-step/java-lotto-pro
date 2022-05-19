package lotto.service;

import lotto.domain.BonusBall;
import lotto.domain.LottoNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusBallValidatorTest {
    @Test
    @DisplayName("보너스 볼이 당첨번호와 중복되면 IllegalArgumentException을 발생시켜야 한다")
    void bonus_ball_and_winning_numbers_should_not_be_duplicate() {
        // given
        final LottoNumbers winningNumbers = LottoNumbers.convertAndCreate("1,2,3,4,5,6");
        final BonusBall bonusBall = new BonusBall(6);

        // when and then
        Assertions.assertThatThrownBy(() -> BonusBallValidator.validate(bonusBall, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
