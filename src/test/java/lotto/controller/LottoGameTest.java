package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {
    @Test
    @DisplayName("당첨번호와 보너스볼 중복여부 테스트")
    public void validateDuplicateBonusBallTest() {
        assertThatThrownBy(() -> LottoGame.of(0).validateDuplicateBonusBall(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().collect(Collectors.toList())
                , 1)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}