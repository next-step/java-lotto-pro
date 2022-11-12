package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinLottoTest {

    @DisplayName("당첨번호 대비 일치 개수 확인")
    @Test
    void 일치_개수_확인() {
        Lotto lotto = new Lotto();
        lotto.addLottoNumber(LottoNumber.getLottoNumberByInt(1));
        lotto.addLottoNumber(LottoNumber.getLottoNumberByInt(2));
        lotto.addLottoNumber(LottoNumber.getLottoNumberByInt(3));
        lotto.addLottoNumber(LottoNumber.getLottoNumberByInt(4));
        lotto.addLottoNumber(LottoNumber.getLottoNumberByInt(5));
        lotto.addLottoNumber(LottoNumber.getLottoNumberByInt(6));
        WinLotto winLotto = new WinLotto(lotto, LottoNumber.getLottoNumberByInt(9));
        Lotto userLotto = new Lotto();
        userLotto.addLottoNumber(LottoNumber.getLottoNumberByInt(1));
        userLotto.addLottoNumber(LottoNumber.getLottoNumberByInt(2));
        userLotto.addLottoNumber(LottoNumber.getLottoNumberByInt(3));
        userLotto.addLottoNumber(LottoNumber.getLottoNumberByInt(4));
        userLotto.addLottoNumber(LottoNumber.getLottoNumberByInt(5));
        userLotto.addLottoNumber(LottoNumber.getLottoNumberByInt(9));

        MatchCount expected = new MatchCount(5, 1);

        assertThat(winLotto.compareWithLotto(userLotto)).isEqualTo(expected);
    }
}
