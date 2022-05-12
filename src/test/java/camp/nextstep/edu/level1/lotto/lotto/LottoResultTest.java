package camp.nextstep.edu.level1.lotto.lotto;

import camp.nextstep.edu.until.RandomGenerator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

class LottoResultTest {

    static MockedStatic<RandomGenerator> util;

    @BeforeAll
    static void beforeAll() {
        util = mockStatic(RandomGenerator.class);
    }

    @AfterAll
    static void afterAll() {
        util.close();
    }

    @Test
    void 구입_로또와_당첨_번호를_입력_후_당첨_금액을_조회_할_수_있어야_한다() {
        LottoNumbers winnerLottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<LottoNumbers> purchaseLotto = Arrays.asList(
            new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 7)),
            new LottoNumbers(Arrays.asList(1, 2, 3, 4, 7, 8)),
            new LottoNumbers(Arrays.asList(1, 2, 3, 7, 8, 9))
        );
        LottoResult result = new LottoResult(purchaseLotto, winnerLottoNumbers);

        Money expectedAmount = new Money(0);
        List<Money> expectedRanks = Arrays.asList(
                LottoRank.FIRST.rankPrice(),
                LottoRank.SECOND.rankPrice(),
                LottoRank.THIRD.rankPrice(),
                LottoRank.FORTH.rankPrice()
        );

        for (Money expectedRank : expectedRanks) {
            expectedAmount = expectedAmount.add(expectedRank);
        }

        assertThat(result.winningAmount()).isEqualTo(expectedAmount);
    }
}
