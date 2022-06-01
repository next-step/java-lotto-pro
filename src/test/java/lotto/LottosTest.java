package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottosTest {
    @Test
    void 로또_그룹_생성() {
        Money money = Money.of(5000, 0);
        Lottos lottos = LottoFactory.generateLottos(money, new ArrayList<String>());
        assertThat(lottos.getLottoList().size()).isEqualTo(5);
    }

    @Test
    void 로또_매치() {
        String[] input = new String[3];
        input[0] = "1,2,3,4,5,6";
        input[1] = "1,2,3,7,8,9";
        input[2] = "1,2,3,4,5,7";
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(LottoFactory.manualGenerator(input[0]));
        lottoList.add(LottoFactory.manualGenerator(input[1]));
        lottoList.add(LottoFactory.manualGenerator(input[2]));
        Lottos lottos = new Lottos(lottoList);

        Lotto winningLottoNumbers = LottoFactory.manualGenerator(input[0]);
        LottoNumber bonusNumber = LottoNumber.from(7);
        WinningLotto winningLotto = WinningLotto.of(winningLottoNumbers, bonusNumber);
        List<Rank> list = lottos.matchLottoStatic(winningLotto);
        assertThat(list.get(0)).isEqualTo(Rank.FIRST);
        assertThat(list.get(1)).isEqualTo(Rank.FIFTH);
        assertThat(list.get(2)).isEqualTo(Rank.SECOND);
    }
}
