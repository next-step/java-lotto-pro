package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryNumbersTest {

    private LotteryNumbers lotteryNumbers;
    private WinningNumber winningNumber;

    @BeforeEach
    void setUp() {
        lotteryNumbers = LotteryNumbers.createAutoLotteryNumber(Arrays.asList(10, 5, 4, 3, 2, 1));
    }

    @DisplayName("로또 번호 자동 생성  확인")
    @Test
    void createAutoLotteryNumber() {
        assertThat(lotteryNumbers).isEqualTo(LotteryNumbers.createAutoLotteryNumber(Arrays.asList(10, 5, 4, 3, 2, 1)));
    }

    @DisplayName("로또 번호 자동 생성 시 숫자가 오름차순 정렬되어 저장되는지 확인")
    @Test
    void checkNumberSort() {
        assertThat(lotteryNumbers.getLotteryNumber()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 10));
    }

    @DisplayName("자동 생성 로또 번호 사이즈 확인")
    @Test
    void size() {
        assertThat(lotteryNumbers.size()).isEqualTo(6);
    }

    @DisplayName("자동 생성 로또 번호 가져오기")
    @Test
    void getLotteryNumber() {
        assertThat(lotteryNumbers.getLotteryNumber()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 10));
    }

    @DisplayName("로또 번호와 일치하는 번호가 있는지 확인")
    @Test
    void contains() {
        assertThat(lotteryNumbers.contains(1)).isTrue();
        assertThat(lotteryNumbers.contains(12)).isFalse();
    }
}
