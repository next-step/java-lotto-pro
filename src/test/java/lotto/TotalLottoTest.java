package lotto;

import com.sun.org.glassfish.gmbal.Description;
import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TotalLottoTest {
    private TotalLotto generatorTotalLotto() {
        Money money = Money.of(2000, 0);
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(LottoFactory.manualGenerator("1,2,3,4,5,6"));
        lottoList.add(LottoFactory.manualGenerator("2,3,4,5,6,45"));
        TotalLotto totalLotto = TotalLotto.of(money, new Lottos(lottoList));
        return totalLotto;
    }

    @Test
    @Description(value = "TotalLotto 생성 시 금액에 맞는 개수로 생성되는지 확인")
    void getTotalLotto() {
        TotalLotto totalLotto = generatorTotalLotto();
        assertThat(totalLotto.getCount()).isEqualTo(2);
    }

    @Test
    @Description(value = "로또 최종 스코어 계산")
    public void getLottoScore() {
        Lotto win = LottoFactory.manualGenerator("1,2,3,4,5,6");
        LottoNumber bonusNumber = LottoNumber.from(45);
        WinningLotto winningLotto = WinningLotto.of(win, bonusNumber);

        TotalLotto totalLotto = generatorTotalLotto();
        LottoScore lottoScore = totalLotto.getLottoScore(winningLotto);

        Map<Rank, Integer> map = new HashMap<>();
        map.put(Rank.FIRST, 1);
        map.put(Rank.SECOND, 1);

        int result = (int) lottoScore.getLottoScore().entrySet().stream()
                        .filter(rankIntegerEntry -> map.get(rankIntegerEntry.getKey()).equals(rankIntegerEntry.getValue()))
                        .count();

        assertThat(result).isEqualTo(2);
    }
}
