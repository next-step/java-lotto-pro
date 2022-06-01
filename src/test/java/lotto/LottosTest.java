package lotto;

import lotto.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottosTest {
    @Test
    void 로또_그룹_생성() {
        Money money = Money.of(5000, 0);
        List<String> stringList = new ArrayList<>();
        ManualLotto manualLotto = ManualLotto.of(money, stringList);
        Lottos lottos = LottoFactory.generateTotalLottos(manualLotto);
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

    @Test
    void 로또_점수_계산() {
        WinningLotto winningLotto = WinningLotto.of(LottoFactory.manualGenerator("1,2,3,4,5,6"), LottoNumber.from(7));

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(LottoFactory.manualGenerator("1,2,3,4,5,7"));
        lottoList.add(LottoFactory.manualGenerator("1,2,3,4,5,6"));

        Lottos lottos = new Lottos(lottoList);
        LottoScore lottoScore = lottos.getLottoScore(winningLotto);

        Map<Rank, Integer> map = new HashMap<>();
        map.put(Rank.FIRST, 1);
        map.put(Rank.SECOND, 1);

        int result = (int) lottoScore.getLottoScore().entrySet().stream()
                .filter(rankIntegerEntry -> map.get(rankIntegerEntry.getKey()).equals(rankIntegerEntry.getValue()))
                .count();

        Assertions.assertThat(result).isEqualTo(2);
    }
}
