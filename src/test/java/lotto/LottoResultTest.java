package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    private final List<Rank> LOTTO_LIST = Arrays.asList(Rank.values());

    @RepeatedTest(10)
    @DisplayName("랜덤하게 발생한 당첨 로또에 대한 당첨금 계산")
    void 당첨금_계산_랜덤() {
        Collections.shuffle(LOTTO_LIST);
        Rank random1 = LOTTO_LIST.get(0);
        Rank random2 = LOTTO_LIST.get(1);

        LottoResult lottoResult = new LottoResult();
        lottoResult.add(random1);
        lottoResult.add(random2);
        assertThat(lottoResult.getAllPrize()).isEqualTo(random1.getPrize() + random2.getPrize());
    }

    @Test
    @DisplayName("3등과 5등에 당첨되면 당첨금은 150만 5000원")
    void 당첨금_계산() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.add(Rank.THIRD);
        lottoResult.add(Rank.FIFTH);
        lottoResult.add(Rank.NONE);

        assertThat(lottoResult.getAllPrize()).isEqualTo(Rank.THIRD.getPrize() + Rank.FIFTH.getPrize());
        assertThat(lottoResult.getAllPrize()).isEqualTo(1505000);
    }

    @RepeatedTest(10)
    @DisplayName("랜덤하게 발생한 10개의 로또에 대한 수익률 계산")
    void 수익률_계산_랜덤() {
        int lottoCount = 10;
        Random random = new Random();
        Collections.shuffle(LOTTO_LIST);
        LottoResult lottoResult = new LottoResult();

        for(int i=0; i<lottoCount; i++) {
            int matchCount = random.nextInt(6) + 1;
            boolean hasBonusBall = random.nextBoolean();
            lottoResult.add(Rank.valueOf(matchCount, hasBonusBall));
        }

        assertThat(lottoResult.getReturnRate())
                .isEqualTo((double) lottoResult.getAllPrize() / (lottoCount * Lotto.LOTTO_PRICE));
    }

    @Test
    @DisplayName("10장 중에 1장만 5등에 당첨되면 수익률 0.50")
    void 수익률_계산() {
        LottoResult lottoResult = new LottoResult();

        for(int i=0; i<9; i++) {
            lottoResult.add(Rank.NONE);
        }
        lottoResult.add(Rank.FIFTH);

        assertThat(lottoResult.getReturnRate()).isEqualTo(0.50);
    }
}
