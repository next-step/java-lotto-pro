package lotto.controller;

import lotto.model.LottoNumber;
import lotto.model.LottoPaper;
import lotto.util.GameRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class LottoNumberGeneratorTest {


    @DisplayName("[정상]당첨번호 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6"}, delimiter = ':')
    void 당첨번호_생성_테스트_정상(String input) {
        // given
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        // when
        LottoPaper winningNumber = lottoNumberGenerator.createWinningNumber(input);
        // then
        assertThat(winningNumber.getLottoNumber().size()).isEqualTo(GameRule.LOTTO_END_INDEX);
        Assertions.assertTrue(winningNumber.getLottoNumber().contains(new LottoNumber(Integer.parseInt(input.split(",")[0]))));
    }

    @DisplayName("[ERROR]당첨번호 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5:1,2,3,4,5,a"}, delimiter = ':')
    void 당첨번호_생성_테스트_예외(String input) {
        // given
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> lottoNumberGenerator.createWinningNumber(input));
    }

    @DisplayName("[정상] 로또번호_생성_테스트")
    @ParameterizedTest
    @CsvSource(value = {"46:-800:0"}, delimiter = ':')
    void 로또번호_생성_테스트(int lottoNumber) {
        // given
        LottoNumberGenerator lottoNumberRandomGenerator = new LottoNumberGenerator();
        // when
        LottoPaper lottoPaper = lottoNumberRandomGenerator.getLottoNumbers();
        // then
        Assertions.assertFalse(lottoPaper.isContainsOf(new LottoNumber(lottoNumber)));

    }
}
