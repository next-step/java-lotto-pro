package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {

    private LotteryNumbers lotteryNumbers;
    private WinningNumber winningNumber;
    private WinningNumber winningNumber2;

    @BeforeEach
    void setUp() {
        lotteryNumbers = LotteryNumbers.createAutoLotteryNumber(Arrays.asList(10, 5, 4, 3, 2, 1));
        winningNumber = WinningNumber.createWinningNumber(new String[]{"1", "2", "3", "4", "5", "6"}, 10);
        winningNumber2 = WinningNumber.createWinningNumber(new String[]{"1", "2", "3", "4", "5", "6"}, 17);
    }

    @DisplayName("당첨 번호 생성하기")
    @Test
    void createWinningNumber() {
        assertThat(winningNumber).isEqualTo(WinningNumber.createWinningNumber(new String[]{"1", "2", "3", "4", "5", "6"}, 10));
    }

    @DisplayName("당첨 번호가 6개가 아니면 에러 발생")
    @Test
    void validNumberLength() {
        assertThatThrownBy(() -> winningNumber = WinningNumber.createWinningNumber(new String[]{"1", "2", "3", "4", "5"}, 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호에 존재하는 번호이면 에러 발생")
    @Test
    void validateDuplicate() {
        assertThatThrownBy(() -> winningNumber = WinningNumber.createWinningNumber(new String[]{"1", "2", "3", "4", "5", "6"}, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 로또 번호를 한번 매치해서 몇 등인지 판별")
    @Test
    void match() {
        assertThat(winningNumber.match(lotteryNumbers)).isEqualTo(Rank.SECOND);
        assertThat(winningNumber2.match(lotteryNumbers)).isEqualTo(Rank.THIRD);
    }
}
