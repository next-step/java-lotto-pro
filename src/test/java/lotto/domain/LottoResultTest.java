package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.LottoConstant.LOTTO_MINIMUM_MATCHING_COUNT;
import static lotto.domain.LottoConstant.LOTTO_SIZE;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    public void 로또_당첨_결과_조회_테스트() {
        PurchasedLotto purchasedLotto = createSamplePurchasedLotto();
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        LottoNo bonusNumber = new LottoNo(7);

        LottoResult result = new LottoResult(purchasedLotto.compareLottos(winningLotto, bonusNumber));

        assertThat(result.getRankingList())
                .contains(Ranking.FIRST)
                .contains(Ranking.SECOND)
                .contains(Ranking.THIRD)
                .contains(Ranking.FOURTH);
    }

    private PurchasedLotto createSamplePurchasedLotto() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 2, 3, 4, 5, 7),
                new Lotto(1, 2, 3, 4, 5, 8),
                new Lotto(1, 2, 3, 4, 7, 8));
        return new PurchasedLotto(lottoList);
    }
}
