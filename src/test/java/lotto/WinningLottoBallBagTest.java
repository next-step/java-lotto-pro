package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.WinScore.WIN_SCORE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoBallBagTest {

    @Test
    void validUnique_lottoBalls_IllegalArgumentException() {
        assertThatThrownBy(() -> new WinningLottoBallBag("1,1,2,3,4,5,6", () -> 0))
                .isInstanceOf(IllegalStateException.class);
    }

    public static List<LottoBall> makeLottoBalls(List<String> numbers) {
        return numbers.stream().map(it -> new LottoBall(it, () -> WIN_SCORE))
                .collect(Collectors.toList());
    }
}
