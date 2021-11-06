package study.lotto.model;

import org.junit.jupiter.api.Test;
import study.lotto.model.exception.IllegalLotterySizeException;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


class LotteryTest {
    @Test
    void 서로_다른_6개의_로또번호_로_생성할_수_있다() {
        final HashSet<LottoNumber> lottoNumbers = new HashSet<>(Arrays.asList(LottoNumber.valueOf(1), LottoNumber.valueOf(2), LottoNumber.valueOf(3), LottoNumber.valueOf(4), LottoNumber.valueOf(5), LottoNumber.valueOf(6)));
        final Lottery winningNumber = Lottery.valueOf(lottoNumbers);
        assertThat(winningNumber.containsAll(lottoNumbers)).isTrue();
    }

    @Test
    void 서로_다른_6개보다_작은_로또번호_로_생성시_예외가_발생한다() {
        final HashSet<LottoNumber> lottoNumbers = new HashSet<>(Arrays.asList(LottoNumber.valueOf(2), LottoNumber.valueOf(3), LottoNumber.valueOf(4), LottoNumber.valueOf(5), LottoNumber.valueOf(6)));
        assertThatExceptionOfType(IllegalLotterySizeException.class)
                .isThrownBy(() -> Lottery.valueOf(lottoNumbers))
                .withMessageMatching("로또는 6개의 서로 다른 로또번호를 가지고 있어야 합니다.");
    }

    @Test
    void 서로_다른_6개보다_큰_로또번호_로_생성시_예외가_발생한다() {
        final HashSet<LottoNumber> lottoNumbers = new HashSet<>(Arrays.asList(LottoNumber.valueOf(45), LottoNumber.valueOf(1), LottoNumber.valueOf(2), LottoNumber.valueOf(3), LottoNumber.valueOf(4), LottoNumber.valueOf(5), LottoNumber.valueOf(6)));
        assertThatExceptionOfType(IllegalLotterySizeException.class)
                .isThrownBy(() -> Lottery.valueOf(lottoNumbers))
                .withMessageMatching("로또는 6개의 서로 다른 로또번호를 가지고 있어야 합니다.");
    }
}