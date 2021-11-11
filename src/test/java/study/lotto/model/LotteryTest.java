package study.lotto.model;

import org.junit.jupiter.api.Test;
import study.lotto.model.exception.IllegalLotterySizeException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;


class LotteryTest {
    @Test
    void 서로_다른_6개의_로또번호_로_생성할_수_있다() {
        final List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final Lottery winningNumber = Lottery.valueOf(lottoNumbers);
        assertAll(() -> {
            assertThat(winningNumber.containsAll(winningNumber.getLottoNumbers())).isTrue();
            assertThat(winningNumber.contains(LottoNumber.valueOf(1))).isTrue();
            assertThat(winningNumber.contains(LottoNumber.valueOf(2))).isTrue();
            assertThat(winningNumber.contains(LottoNumber.valueOf(3))).isTrue();
            assertThat(winningNumber.contains(LottoNumber.valueOf(4))).isTrue();
            assertThat(winningNumber.contains(LottoNumber.valueOf(5))).isTrue();
            assertThat(winningNumber.contains(LottoNumber.valueOf(6))).isTrue();

        });
    }

    @Test
    void 서로_다른_6개보다_작은_로또번호_로_생성시_예외가_발생한다() {
        final List<Integer> lottoNumbers = Arrays.asList(2, 3, 4, 5, 6);
        assertThatExceptionOfType(IllegalLotterySizeException.class)
                .isThrownBy(() -> Lottery.valueOf(lottoNumbers))
                .withMessageMatching("로또는 6개의 서로 다른 로또번호를 가지고 있어야 합니다.");
    }

    @Test
    void 서로_다른_6개보다_큰_로또번호_로_생성시_예외가_발생한다() {
        final List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        assertThatExceptionOfType(IllegalLotterySizeException.class)
                .isThrownBy(() -> Lottery.valueOf(lottoNumbers))
                .withMessageMatching("로또는 6개의 서로 다른 로또번호를 가지고 있어야 합니다.");
    }
}