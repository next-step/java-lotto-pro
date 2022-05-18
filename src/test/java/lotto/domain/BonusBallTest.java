package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusBallTest {
    @Test
    @DisplayName("보너스볼 번호를 파라미터로 BonusBall 객체가 생성되어야 한다")
    void create() {
        // given
        final int number = 10;

        // when
        final BonusBall bonusBall = new BonusBall(number);

        // when and then
        assertThat(bonusBall).isInstanceOf(BonusBall.class);
        assertThat(bonusBall).isEqualTo(new BonusBall(number));
    }

    @Test
    @DisplayName("보너스볼 번호 문자열을 파라미터로 BonusBall 객체가 생성되어야 한다")
    void convert_and_create() {
        // given
        final String number = "10";

        // when
        final BonusBall bonusBall = BonusBall.convertAndCreate(number);

        // when and then
        assertThat(bonusBall).isInstanceOf(BonusBall.class);
        assertThat(bonusBall).isEqualTo(new BonusBall(10));
    }
}
