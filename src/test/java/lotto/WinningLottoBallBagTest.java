package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.WinScore.WIN_SCORE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("우승 로또 목록 테스트")
class WinningLottoBallBagTest {

    @DisplayName("중복 로또 번호 입력 테스트")
    @Test
    void validUnique_lottoBalls_IllegalArgumentException() {
        assertThatThrownBy(() -> new WinningLottoBallBag("1,1,2,3,4,5,6", () -> 0))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void validUnique_addLottoBalls_IllegalArgumentException() {
        //given:
        WinningLottoBallBag winningLottoBallBag = new WinningLottoBallBag("1,2,3,4,5,6", () -> 0);
        //when, then:
        assertThatThrownBy(() -> winningLottoBallBag.add(new LottoBall("1", () -> 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static List<LottoBall> makeLottoBalls(List<String> numbers) {
        return numbers.stream().map(it -> new LottoBall(it, () -> WIN_SCORE))
                .collect(Collectors.toList());
    }
}
