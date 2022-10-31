package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    @DisplayName("보너스 볼 일치 여부 확인")
    void 보너스_볼_일치_여부() {
        final int BONUS_BALL = 10;
        Lotto lottoWithBonusBall = new Lotto(Stream.of(1, 2, 3, 4, 5, BONUS_BALL)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
        Lotto lottoExceptBonusBall = new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));

        assertThat(lottoWithBonusBall.hasBonusBall(new LottoNumber(BONUS_BALL))).isTrue();
        assertThat(lottoExceptBonusBall.hasBonusBall(new LottoNumber(BONUS_BALL))).isFalse();
    }
}
