package step3;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import step3.domain.Amount;
import step3.domain.LottoNumber;
import step3.domain.LottoNumbers;
import step3.domain.LottoNumbersBundle;
import step3.domain.LottoRank;
import step3.domain.LottoRanks;
import step3.domain.WinningLotto;
import step3.domain.factory.LottoNumbersFactory;

public class LottoRanksTest {
    private static final int BUY_AMOUNT = 1000;

    @ParameterizedTest
    @MethodSource("getResultStatisticsGenerateData")
    @DisplayName("등수별 수익률을 비교합니다")
    void getCalculatedYield_수익률_테스트(LottoNumbersBundle boughtLottoNumberBundle, WinningLotto winningLotto,
        BigDecimal expectYield) {
        // given

        // when
        LottoRanks lottoRanks = new LottoRanks.Build()
            .init()
            .setAmount(new Amount(BUY_AMOUNT))
            .match(boughtLottoNumberBundle, winningLotto)
            .build();

        // then
        assertAll(
            () -> assertThat(lottoRanks.getCalculatedYield()).isEqualTo(expectYield)
        );
    }

    private static Stream<Arguments> getResultStatisticsGenerateData() {
        return Stream.of(
            Arguments.of(
                createListLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)),
                createWinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 10),
                BigDecimal.valueOf(LottoRank.FIRST.prize / BUY_AMOUNT).setScale(2, RoundingMode.CEILING)
            ),
            Arguments.of(
                createListLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 10)),
                createWinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 10),
                BigDecimal.valueOf(LottoRank.SECOND.prize / BUY_AMOUNT).setScale(2, RoundingMode.CEILING)
            ),
            Arguments.of(
                createListLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 20)),
                createWinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 10),
                BigDecimal.valueOf(LottoRank.THIRD.prize / BUY_AMOUNT).setScale(2, RoundingMode.CEILING)
            ),
            Arguments.of(
                createListLottoNumber(Arrays.asList(1, 2, 3, 4, 21, 20)),
                createWinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 10),
                BigDecimal.valueOf(LottoRank.FOURTH.prize / BUY_AMOUNT).setScale(2, RoundingMode.CEILING)
            ),
            Arguments.of(
                createListLottoNumber(Arrays.asList(1, 2, 3, 22, 21, 20)),
                createWinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 10),
                BigDecimal.valueOf(LottoRank.FIFTH.prize / BUY_AMOUNT).setScale(2, RoundingMode.CEILING)
            )
        );
    }

    private static WinningLotto createWinningLotto(List<Integer> winnerLottoNumbers, int bonusNumber) {
        return WinningLotto.of(
            LottoNumbersFactory.createManualLottoNumbers(winnerLottoNumbers),
            LottoNumber.of(bonusNumber)
        );
    }

    private static LottoNumbersBundle createListLottoNumber(List<Integer> lottoNumbers) {
        List<LottoNumbers> result = new ArrayList<>();
        result.add(LottoNumbers.of(LottoNumbersFactory.createManualLottoNumbersToList(lottoNumbers)));
        return LottoNumbersBundle.of(result);
    }
}
