package nextstep.lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class MatchCountCollectionTest {

    @DisplayName("5개 당첨 + 보너스볼 당첨")
    @ParameterizedTest
    @MethodSource("provide")
    public void winningSecondPrice(PurchaseLotto purchaseLotto, WinningLotto winningLotto, MatchCountCollection expect) {

        // when
        MatchCountCollection result = MatchCountCollection.matchPurchaseLottoWithWinningLotto(purchaseLotto, winningLotto);

        // then
        for (int i = 0; i < result.size(); i++) {
            MatchCount expected = expect.getMatchCounts().get(i);
            MatchCount actual = result.getMatchCounts().get(i);
            Assertions.assertThat(actual.getLottoWinningPrice()).isEqualTo(expected.getLottoWinningPrice());
            Assertions.assertThat(actual.getMatchCount()).isEqualTo(expected.getMatchCount());
        }
    }

    public static Stream<Arguments> provide() {

        Lotto purchasedLotto = new Lotto(
                new LottoNumbers(
                        Arrays.asList(
                                new LottoNumber(1),
                                new LottoNumber(2),
                                new LottoNumber(3),
                                new LottoNumber(4),
                                new LottoNumber(5),
                                new LottoNumber(6)
                        )
                )
        );

        Lotto winningLotto = new Lotto(
                new LottoNumbers(
                        Arrays.asList(
                                new LottoNumber(1),
                                new LottoNumber(2),
                                new LottoNumber(3),
                                new LottoNumber(4),
                                new LottoNumber(5),
                                new LottoNumber(7)
                        )
                )
        );

        return Stream.of(
                Arguments.of(
                        new PurchaseLotto(Collections.singletonList(purchasedLotto)),
                        new WinningLotto(
                                winningLotto,
                                new BonusBall(new LottoNumber(6), winningLotto)
                        ),
                        new MatchCountCollection(
                                Arrays.asList(
                                        new MatchCount(MatchCount.LottoWinningPrice.MATCH_3_COUNT, 0),
                                        new MatchCount(MatchCount.LottoWinningPrice.MATCH_4_COUNT, 0),
                                        new MatchCount(MatchCount.LottoWinningPrice.MATCH_5_COUNT, 0),
                                        new MatchCount(MatchCount.LottoWinningPrice.MATCH_5_BONUS_COUNT, 1),
                                        new MatchCount(MatchCount.LottoWinningPrice.MATCH_6_COUNT, 0)
                                )
                        )
                )
        );
    }
}
