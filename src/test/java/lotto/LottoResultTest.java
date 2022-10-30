package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    private final List<Rank> LOTTO_LIST = Arrays.asList(Rank.values());
    private final int RANK_SIZE = Rank.values().length;

    @RepeatedTest(10)
    @DisplayName("랜덤하게 발생한 당첨 로또에 대한 당첨금 계산")
    void 당첨금_계산() {
        Collections.shuffle(LOTTO_LIST);
        Rank random1 = LOTTO_LIST.get(0);
        Rank random2 = LOTTO_LIST.get(1);

        LottoResult lottoResult = new LottoResult();
        lottoResult.add(random1);
        lottoResult.add(random2);
        assertThat(lottoResult.getAllPrize()).isEqualTo(random1.getPrize() + random2.getPrize());
    }

    @RepeatedTest(10)
    @DisplayName("랜덤하게 발생한 10개의 로또에 대한 수익률 계산")
    void 수익률_계산() {
        int lottoCount = (int) (Math.random() * 10 + 1);
        Collections.shuffle(LOTTO_LIST);
        LottoResult lottoResult = new LottoResult();

        for(int i=0; i<lottoCount; i++) {
            lottoResult.add(Rank.valueOf(i % RANK_SIZE));
        }

        assertThat(lottoResult.getReturnRate())
                .isEqualTo((double) lottoResult.getAllPrize() / (lottoCount * Lotto.LOTTO_PRICE));
    }
}
