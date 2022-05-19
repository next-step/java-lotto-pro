package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoPrizeTest {
    @Test
    @DisplayName("valueOf 메소드는 numberOfMatch에 맞는 LottoPrize Enum을 반환한다")
    void value_of_with_number_of_match() {
        assertAll(
                () -> assertThat(LottoPrize.valueOf(0)).isEqualTo(LottoPrize.NONE),
                () -> assertThat(LottoPrize.valueOf(1)).isEqualTo(LottoPrize.NONE),
                () -> assertThat(LottoPrize.valueOf(2)).isEqualTo(LottoPrize.NONE),
                () -> assertThat(LottoPrize.valueOf(3)).isEqualTo(LottoPrize.WIN_WITH_3_MATCHES),
                () -> assertThat(LottoPrize.valueOf(4)).isEqualTo(LottoPrize.WIN_WITH_4_MATCHES),
                () -> assertThat(LottoPrize.valueOf(5)).isEqualTo(LottoPrize.WIN_WITH_5_MATCHES),
                () -> assertThat(LottoPrize.valueOf(6)).isEqualTo(LottoPrize.WIN_WITH_FULL_MATCHES)
        );
    }

    @Test
    @DisplayName("valueOf 메소드는 numberOfMatch와 맞는 보너스 볼을 가졌는지 여부에 따라 맞는 LottoPrize Enum을 반환한다.")
    void value_of_with_number_of_match_and_has_bonus_ball() {
        assertAll(
                () -> assertThat(LottoPrize.valueOf(0, true)).isEqualTo(LottoPrize.NONE),
                () -> assertThat(LottoPrize.valueOf(0, false)).isEqualTo(LottoPrize.NONE),
                () -> assertThat(LottoPrize.valueOf(1, true)).isEqualTo(LottoPrize.NONE),
                () -> assertThat(LottoPrize.valueOf(1, false)).isEqualTo(LottoPrize.NONE),
                () -> assertThat(LottoPrize.valueOf(2, true)).isEqualTo(LottoPrize.NONE),
                () -> assertThat(LottoPrize.valueOf(2, false)).isEqualTo(LottoPrize.NONE),
                () -> assertThat(LottoPrize.valueOf(3, true)).isEqualTo(LottoPrize.WIN_WITH_3_MATCHES),
                () -> assertThat(LottoPrize.valueOf(3, false)).isEqualTo(LottoPrize.WIN_WITH_3_MATCHES),
                () -> assertThat(LottoPrize.valueOf(4, true)).isEqualTo(LottoPrize.WIN_WITH_4_MATCHES),
                () -> assertThat(LottoPrize.valueOf(4, false)).isEqualTo(LottoPrize.WIN_WITH_4_MATCHES),
                () -> assertThat(LottoPrize.valueOf(5, true)).isEqualTo(LottoPrize.WIN_WITH_5_MATCHES_AND_BONUS),
                () -> assertThat(LottoPrize.valueOf(5, false)).isEqualTo(LottoPrize.WIN_WITH_5_MATCHES),
                () -> assertThat(LottoPrize.valueOf(6, true)).isEqualTo(LottoPrize.WIN_WITH_FULL_MATCHES),
                () -> assertThat(LottoPrize.valueOf(6, false)).isEqualTo(LottoPrize.WIN_WITH_FULL_MATCHES)
        );
    }

}
