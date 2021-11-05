package lotto.model;

import lotto.util.GameRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPaperTest {

    @DisplayName("[정상]로또번호 매칭 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:1,2,3,4,5,6"}, delimiter = ':')
    void 로또번호_매칭_테스트_정상(int inNumber, String inWinningNumber) {
        // given
        LottoNumber lottoNumber = new LottoNumber(inNumber);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        Arrays.asList(inWinningNumber.split(GameRule.LOTTO_NUMBER_DELIMITER)).
                forEach(winningNumber -> lottoNumbers.add(new LottoNumber(Integer.parseInt(winningNumber))));
        LottoPaper winningLottoPaper = new LottoPaper(lottoNumbers);
        LottoResult lottoResult = new LottoResult();
        // when
        winningLottoPaper.checkContainsLottoNumber(lottoNumber, lottoResult);
        // then
        assertThat(lottoResult.getMatchCount()).isEqualTo(1);
    }

    @DisplayName("[정상]로또번호 비매칭 테스트")
    @ParameterizedTest
    @CsvSource(value = {"41:1,2,3,4,5,6"}, delimiter = ':')
    void 로또번호_비매칭_테스트_정상(int inNumber, String inWinningNumber) {
        // given
        LottoNumber lottoNumber = new LottoNumber(inNumber);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        Arrays.asList(inWinningNumber.split(GameRule.LOTTO_NUMBER_DELIMITER)).
                forEach(winningNumber -> lottoNumbers.add(new LottoNumber(Integer.parseInt(winningNumber))));
        LottoPaper winningLottoPaper = new LottoPaper(lottoNumbers);
        LottoResult lottoResult = new LottoResult();
        // when
        winningLottoPaper.checkContainsLottoNumber(lottoNumber, lottoResult);
        // then
        assertThat(lottoResult.getMatchCount()).isEqualTo(0);
    }

    @DisplayName("[정상]로또게임 매칭 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,8,9,10:1,2,3,4,5,6"}, delimiter = ':')
    void 로또게임_매칭_테스트_정상(String inLottoNumber, String inWinningNumber) {
        // given
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        Arrays.asList(inLottoNumber.split(GameRule.LOTTO_NUMBER_DELIMITER)).
                forEach(lottoNumber -> lottoNumbers.add(new LottoNumber(Integer.parseInt(lottoNumber))));
        LottoPaper lottoPaper = new LottoPaper(lottoNumbers);

        List<LottoNumber> winningLottoNumbers = new ArrayList<>();
        Arrays.asList(inWinningNumber.split(GameRule.LOTTO_NUMBER_DELIMITER)).
                forEach(winningNumber -> winningLottoNumbers.add(new LottoNumber(Integer.parseInt(winningNumber))));
        LottoPaper winningLottoPaper = new LottoPaper(winningLottoNumbers);

        LottoResult lottoResult = new LottoResult();
        // when
        lottoPaper.matchLottoPaper(winningLottoPaper, lottoResult);
        // then
        assertThat(lottoResult.getMatchCountMap().get(3)).isEqualTo(1);
        assertThat(lottoResult.getMatchCount()).isEqualTo(0);
    }
}
