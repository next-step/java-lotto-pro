package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoPrizeTest {
    @DisplayName("로또 상금 생성 테스트")
    @Test
    void constructLottoPrize_success() {
        LottoPrize lottoPrize = new LottoPrize(5000);
        assertThat(lottoPrize).isEqualTo(new LottoPrize(5000));
    }

    @DisplayName("로또 상금 곱하기 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void calculateMultiple_success(int multiple) {
        assertThat(new LottoPrize(5000).calculateMultiple(multiple)).isEqualTo(new LottoPrize(5000 * multiple));
    }
}
