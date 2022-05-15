package lotto;

import lotto.vo.Number;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class LotteryUtilsTest {
    @Test
    void 로또_번호_범위_예외() {
        assertThatThrownBy(() -> {
            new LotteryUtils(0, 45);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_생성_개수_예외() {
        assertThatThrownBy(() -> {
            new LotteryUtils(1, 3);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 일부터_사십오사이_숫자_여섯개_생성() {
        LotteryUtils lotteryUtils = new LotteryUtils(1, 45);
        List<Number> numbers = lotteryUtils.pickRandomNumbers(6);
        Set<Number> set = new HashSet<>(numbers);

        assertThat(set).hasSize(6);
        assertThatCode(() -> {
            for (Number number : numbers) {
                if (number.value() < 1 || number.value() > 45) {
                    throw new NoSuchElementException("범위 밖의 숫자가 존재합니다.");
                }
            }
        }).doesNotThrowAnyException();
    }
}
