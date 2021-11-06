package lotto.controller;

import lotto.model.*;
import lotto.util.GameRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @DisplayName("[정상]로또결과 확인 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,8,9,10:1,2,3,4,9,10:1,2,3,4,5,6"}, delimiter = ':')
    void 로또결과_확인_테스트_정상(String inLottoNumber1, String inLottoNumber2, String inWinningNumber) {
        // given
        LottoGame lottoGame = new LottoGame();
        List<LottoNumber> lottoNumbers1 = new ArrayList<>();
        Arrays.asList(inLottoNumber1.split(GameRule.LOTTO_NUMBER_DELIMITER)).
                forEach(lottoNumber -> lottoNumbers1.add(new LottoNumber(Integer.parseInt(lottoNumber))));
        LottoPaper lottoPaper1 = new LottoPaper(lottoNumbers1);

        List<LottoNumber> lottoNumbers2 = new ArrayList<>();
        Arrays.asList(inLottoNumber2.split(GameRule.LOTTO_NUMBER_DELIMITER)).
                forEach(lottoNumber -> lottoNumbers2.add(new LottoNumber(Integer.parseInt(lottoNumber))));
        LottoPaper lottoPaper2 = new LottoPaper(lottoNumbers2);

        List<LottoPaper> lottoPapers = new ArrayList<>();
        lottoPapers.add(lottoPaper1);
        lottoPapers.add(lottoPaper2);

        List<LottoNumber> winningLottoNumbers = new ArrayList<>();
        Arrays.asList(inWinningNumber.split(GameRule.LOTTO_NUMBER_DELIMITER)).
                forEach(winningNumber -> winningLottoNumbers.add(new LottoNumber(Integer.parseInt(winningNumber))));
        LottoPaper winningLottoPaper = new LottoPaper(winningLottoNumbers);
        // when
        LottoResult lottoResult = lottoGame.getLottoResult(new LottoPapers(lottoPapers), winningLottoPaper);
        // then
        assertThat(lottoResult.getMatchCounts().get(LottoWinningPrice.THREE)).isEqualTo(1);
        assertThat(lottoResult.getMatchCounts().get(LottoWinningPrice.FOUR)).isEqualTo(1);
    }
}
