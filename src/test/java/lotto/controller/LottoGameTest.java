package lotto.controller;

import lotto.model.LottoNumber;
import lotto.model.LottoPaper;
import lotto.model.LottoResult;
import lotto.util.GameRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoGameTest {

    @DisplayName("[정상]로또구입금액 입력값 테스트")
    @ParameterizedTest
    @CsvSource(value = {"14000:3000:3500"}, delimiter = ':')
    void 로또구입금액_입력값_테스트_정상(String buyPrice) {
        // given
        int parseBuyPrice = LottoGame.parseIntBuyPrice(buyPrice);
        // when
        // then
        assertThat(parseBuyPrice).isEqualTo(Integer.parseInt(buyPrice));
    }

    @DisplayName("[ERROR]로또구입금액 입력값 테스트")
    @ParameterizedTest
    @CsvSource(value = {"가나:800:-2000"}, delimiter = ':')
    void 로또구입금액_입력값_테스트_예외(String buyPrice) {
        assertThrows(IllegalArgumentException.class, () -> LottoGame.parseIntBuyPrice(buyPrice));
    }

    @DisplayName("[정상]로또생성 사이즈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"14:1000:3500"}, delimiter = ':')
    void 로또사이즈_테스트(long size) {
        // given
        // when
        long lottoPaperSize = LottoGame.getLottoPaperList(size).getLottoPaperList().size();
        // then
        assertThat(lottoPaperSize).isEqualTo(size);
    }

    @DisplayName("[정상]당첨번호 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6"}, delimiter = ':')
    void 당첨번호_생성_테스트_정상(String input) {
        // given
        // when
        LottoPaper winningNumber = LottoGame.getWinningNumber(input);
        // then
        assertThat(winningNumber.getLottoNumber().size()).isEqualTo(GameRule.LOTTO_END_INDEX);
        Assertions.assertTrue(winningNumber.getLottoNumber().contains(new LottoNumber(Integer.parseInt(input.split(",")[0]))));
    }

    @DisplayName("[ERROR]당첨번호 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5:1,2,3,4,5,a"}, delimiter = ':')
    void 당첨번호_생성_테스트_예외(String input) {
        assertThrows(IllegalArgumentException.class, () -> LottoGame.getWinningNumber(input));
    }

    @DisplayName("[정상]로또번호 매칭 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:1,2,3,4,5,6"}, delimiter = ':')
    void 로또번호_매칭_테스트_정상(int inNumber, String inWinningNumber) {
        // given
        LottoNumber lottoNumber = new LottoNumber(inNumber);
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        Arrays.asList(inWinningNumber.split(GameRule.LOTTO_NUMBER_DELIMITER)).
                forEach(winningNumber -> lottoNumberList.add(new LottoNumber(Integer.parseInt(winningNumber))));
        LottoPaper winningLottoPaper = new LottoPaper(lottoNumberList);
        LottoResult lottoResult = new LottoResult();
        // when
        LottoGame.checkContainsLottoNumber(lottoNumber, winningLottoPaper, lottoResult);
        // then
        assertThat(lottoResult.getMatchCount()).isEqualTo(1);
    }

    @DisplayName("[정상]로또번호 비매칭 테스트")
    @ParameterizedTest
    @CsvSource(value = {"41:1,2,3,4,5,6"}, delimiter = ':')
    void 로또번호_비매칭_테스트_정상(int inNumber, String inWinningNumber) {
        // given
        LottoNumber lottoNumber = new LottoNumber(inNumber);
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        Arrays.asList(inWinningNumber.split(GameRule.LOTTO_NUMBER_DELIMITER)).
                forEach(winningNumber -> lottoNumberList.add(new LottoNumber(Integer.parseInt(winningNumber))));
        LottoPaper winningLottoPaper = new LottoPaper(lottoNumberList);
        LottoResult lottoResult = new LottoResult();
        // when
        LottoGame.checkContainsLottoNumber(lottoNumber, winningLottoPaper, lottoResult);
        // then
        assertThat(lottoResult.getMatchCount()).isEqualTo(0);
    }

    @DisplayName("[정상]로또게임 매칭 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,8,9,10:1,2,3,4,5,6"}, delimiter = ':')
    void 로또게임_매칭_테스트_정상(String inLottoNumber, String inWinningNumber) {
        // given
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        Arrays.asList(inLottoNumber.split(GameRule.LOTTO_NUMBER_DELIMITER)).
                forEach(lottoNumber -> lottoNumberList.add(new LottoNumber(Integer.parseInt(lottoNumber))));
        LottoPaper lottoPaper = new LottoPaper(lottoNumberList);

        List<LottoNumber> winningLottoNumberList = new ArrayList<>();
        Arrays.asList(inWinningNumber.split(GameRule.LOTTO_NUMBER_DELIMITER)).
                forEach(winningNumber -> winningLottoNumberList.add(new LottoNumber(Integer.parseInt(winningNumber))));
        LottoPaper winningLottoPaper = new LottoPaper(winningLottoNumberList);

        LottoResult lottoResult = new LottoResult();
        // when
        LottoGame.matchLottoPaper(lottoPaper, winningLottoPaper, lottoResult);
        // then
        assertThat(lottoResult.getMatchCountMap().get(3)).isEqualTo(1);
        assertThat(lottoResult.getMatchCount()).isEqualTo(0);
    }
}
