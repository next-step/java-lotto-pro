package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.params.ParameterizedTest.DEFAULT_DISPLAY_NAME;

@DisplayName("로또 발급기 테스트")
class LottoIssuerTest {

    @ParameterizedTest(name = "발급 성공 " + DEFAULT_DISPLAY_NAME)
    @CsvSource(value = { "10:10", "20:20", "0:0" }, delimiter = ':')
    void issue_lottoList_success(int availableCount, int numberOfLotto) {
        //given:
        LottoBag lottoBag = LottoIssuer.issueAuto(availableCount, new LottoNumberGenerator());
        //when, then:
        assertThat(lottoBag.lottoSize()).isEqualTo(numberOfLotto);
    }

    @DisplayName("로또 수동 발급 성공")
    @Test
    void issueManually_lottoList_success() {
        //given:
        List<LottoNumberManualGenerator> lottoNumberManualGeneratorList = new ArrayList<>(
                Arrays.asList(
                        new LottoNumberManualGenerator("1,2,3,4,5,6"),
                        new LottoNumberManualGenerator("2,3,4,5,6,7")));
        //when, then:
        assertThatNoException().isThrownBy(() -> LottoIssuer.issueManuals(lottoNumberManualGeneratorList));
    }

    @DisplayName("로또 당첨 결과 성공")
    @Test
    void result_issuedLotto_success() {
        LottoBag lottoList = LottoIssuer.issueAuto(0, new LottoNumberGenerator());
        WinningLottoBallBag winningLottoBallBag = new WinningLottoBallBag("1,2,3,4,5,6");
        assertThatNoException().isThrownBy(() -> LottoIssuer.result(lottoList, winningLottoBallBag));
    }

}
